package com.example.Test.generix.mapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/*
 * References: https://stackoverflow.com/a/65739712
 */
@Component
public class ReferenceMapper {

    @PersistenceContext
    private EntityManager entityManager;

    @ObjectFactory
    public <T> T map(@NonNull final Long id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }

    @ObjectFactory
    public <T, K extends CompositeKey> T map(@NonNull final K id, @TargetType Class<T> type) {
        return entityManager.getReference(type, id);
    }

    public interface CompositeKey {}

}
