package com.example.Test.generix.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface DefaultGenericMapper<E, I, O> {

    E requestToEntity(I request);

    O entityToResponse(E entity);

    List<E> requestToEntity(List<I> requests);

    List<O> entityToResponse(List<E> entities);

    @InheritConfiguration
    E update(@MappingTarget E entity, I request);

}
