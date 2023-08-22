package com.example.Test.generix.mapper;

import org.mapstruct.Mapping;

public interface GenericCompositeMapper<E, I, O> extends DefaultGenericMapper<E, I, O> {

    @Mapping(target = "id", ignore = true)
    E idToEntity(ReferenceMapper.CompositeKey id);

}
