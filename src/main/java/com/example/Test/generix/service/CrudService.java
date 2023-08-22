package com.example.Test.generix.service;



import com.example.Test.generix.dto.PagedListResponse;

import java.util.List;

public interface CrudService<ID, I, O> {

    PagedListResponse<O> findAll(int page, int size, String sort, String filter, String search, boolean all);

    O findById(ID id);

    O create(I request);

    O update(ID id, I request);

    List<O> batchSave(List<I> requests);

    void delete(ID id);

    void deleteAll(List<ID> ids);

}
