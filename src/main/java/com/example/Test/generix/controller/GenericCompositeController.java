package com.example.Test.generix.controller;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.Test.generix.dto.ListResponse;
import com.example.Test.generix.dto.PagedListResponse;
import com.example.Test.generix.dto.SingleResponse;
import com.example.Test.generix.service.CrudService;

import java.util.List;

@Validated
public abstract class GenericCompositeController<ID, I, O> {

    private CrudService<ID, I, O> service;
    private ApplicationContext context;

    @PostConstruct
    protected abstract void initialize();

    protected void setService(Class<? extends CrudService<ID, I, O>> service) {
        this.service = context.getBean(service);
    }

    @Autowired
    private void setContext(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "[generix] getAll API")
    public ResponseEntity<PagedListResponse<O>> getAllResources(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "sort", defaultValue = "createdAt,desc") String sort,
            @RequestParam(name = "filter", required = false) @Nullable String filter,
            @RequestParam(name = "search", required = false) @Nullable String search,
            @RequestParam(name = "all", required = false) boolean all
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(page, size, sort, filter, search, all));
    }

    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "[generix] getById API")
    public ResponseEntity<SingleResponse<O>> getResource(@ParameterObject @Valid ID id) {
        return ResponseEntity.status(HttpStatus.OK).body(SingleResponse.of(service.findById(id)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "[generix] create API")
    public ResponseEntity<SingleResponse<O>> createResource(@RequestBody @Valid I request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(SingleResponse.of(service.create(request)));
    }

    @PutMapping(value = "/id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "[generix] update API")
    public ResponseEntity<SingleResponse<O>> updateResource(@ParameterObject @Valid ID id, @RequestBody @Valid I request) {
        return ResponseEntity.status(HttpStatus.OK).body(SingleResponse.of(service.update(id, request)));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "[generix] batch save API")
    public ResponseEntity<ListResponse<O>> batchSaveResource(@RequestBody List<@Valid I> request) {
        return ResponseEntity.status(HttpStatus.OK).body(ListResponse.of(service.batchSave(request)));
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "[generix] deleteById API")
    public ResponseEntity<Void> deleteResource(@ParameterObject @Valid ID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "[generix] deleteAllById API")
    public ResponseEntity<Void> deleteAllResources(@RequestBody @Size(min = 1, max = 100) List<ID> ids) {
        service.deleteAll(ids);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
