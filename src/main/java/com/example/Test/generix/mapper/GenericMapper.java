package com.example.Test.generix.mapper;

import org.mapstruct.Mapping;

public interface GenericMapper<E, I, O> extends DefaultGenericMapper<E, I, O> {

    @Mapping(target = "id", ignore = true)
    E idToEntity(Long id);

}
