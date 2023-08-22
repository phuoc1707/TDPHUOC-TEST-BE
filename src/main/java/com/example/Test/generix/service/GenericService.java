package com.example.Test.generix.service;

import io.github.perplexhub.rsql.RSQLJPASupport;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;
import com.example.Test.generix.dto.PagedListResponse;
import com.example.Test.generix.exception.GenerixResourceNotFoundException;
import com.example.Test.generix.mapper.DefaultGenericMapper;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public abstract class GenericService<E, ID, I, O> implements CrudService<ID, I, O> {

    private String resourceName;
    private JpaRepository<E, ID> repository;
    private JpaSpecificationExecutor<E> specificationExecutor;
    private DefaultGenericMapper<E, I, O> mapper;
    private List<String> searchFields = Collections.emptyList();
    private ApplicationContext context;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    protected abstract void initialize();

    protected void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    protected <R extends JpaRepository<E, ID> & JpaSpecificationExecutor<E>> void setRepository(Class<R> repository) {
        this.repository = context.getBean(repository);
        this.specificationExecutor = context.getBean(repository);
    }

    protected void setMapper(Class<? extends DefaultGenericMapper<E, I, O>> mapper) {
        this.mapper = context.getBean(mapper);
    }

    protected void setSearchFields(List<String> searchFields) {
        this.searchFields = searchFields;
    }

    protected void setSearchFields(String... searchFields) {
        this.searchFields = List.of(searchFields);
    }

    @Autowired
    private void setContext(ApplicationContext context) {
        this.context = context;
    }

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public PagedListResponse<O> findAll(int page, int size, String sort, String filter, String search, boolean all) {
        Specification<E> sortable = RSQLJPASupport.toSort(sort);
        Specification<E> filterable = RSQLJPASupport.toSpecification(filter);
        Specification<E> searchable = parseSearchText(search, searchFields);
        Pageable pageable = all ? Pageable.unpaged() : PageRequest.of(page - 1, size);
        Page<E> entities = specificationExecutor.findAll(sortable.and(filterable).and(searchable), pageable);
        List<O> entityResponses = mapper.entityToResponse(entities.getContent());
        return PagedListResponse.of(entityResponses, entities);
    }

    @Override
    public O findById(ID id) {
        return repository.findById(id)
                .map(mapper::entityToResponse)
                .orElseThrow(() -> new GenerixResourceNotFoundException(resourceName, "id", id));
    }

    @Override
    public O create(I request) {
        E entity = mapper.requestToEntity(request);
        System.out.println(entity);
        repository.save(entity);
        return mapper.entityToResponse(entity);
    }

    @Override
    public O update(ID id, I request) {
        return repository.findById(id)
                .map(entity -> mapper.update(entity, request))
                .map(repository::save)
                .map(mapper::entityToResponse)
                .orElseThrow(() -> new GenerixResourceNotFoundException(resourceName, "id", id));
    }

    public <R> O patch(ID id, R request, BiFunction<E, R, E> mapperFunction) {
        return repository.findById(id)
                .map(entity -> mapperFunction.apply(entity, request))
                .map(repository::save)
                .map(mapper::entityToResponse)
                .orElseThrow(() -> new GenerixResourceNotFoundException(resourceName, "id", id));
    }

    @Override
    @Transactional
    public List<O> batchSave(List<I> requests) {
        List<E> entities = mapper.requestToEntity(requests);
        return repository.saveAllAndFlush(entities)
                .stream()
                .peek(entityManager::refresh)
                .map(mapper::entityToResponse)
                .toList();
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(List<ID> ids) {
        repository.deleteAllById(ids);
    }

    private <T> Specification<T> parseSearchText(String search, List<String> searchFields) {
        if (search == null || search.isBlank() || searchFields == null || searchFields.size() == 0) {
            return RSQLJPASupport.toSpecification((String) null);
        }

        return searchFields.stream()
                .map(field -> field + "=like='" + search.trim() + "'")
                .collect(Collectors.collectingAndThen(Collectors.joining(","), RSQLJPASupport::toSpecification));
    }

}
