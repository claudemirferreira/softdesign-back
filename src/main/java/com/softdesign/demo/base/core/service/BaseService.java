package com.softdesign.demo.base.core.service;

import com.softdesign.demo.base.core.exception.BaseIdentifiedException;
import com.softdesign.demo.base.core.model.AbstractModel;
import com.softdesign.demo.base.core.model.IdentifiedError;
import com.softdesign.demo.base.core.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<M extends AbstractModel> {

    public List<M> getByIds(Collection<UUID>ids) {
        return getRepository().getByIds(ids);
    }

    public Optional<M> findById(UUID id) {
        return getRepository().findById(id);
    }

    public Optional<M> findByIdNotDeleted(UUID id) {
        Optional<M> model = getRepository().findById(id);
        if(model.isPresent()) {
            return Optional.empty();
        }
        return model;
    }

    public M findOrThrow(UUID id, IdentifiedError error) {
        return findByIdNotDeleted(id).orElseThrow(() -> new BaseIdentifiedException(error));
    }

    public M getById(UUID id) {
        return getRepository().getById(id);
    }

    public Page<M> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }


    protected abstract BaseRepository<M> getRepository();


}
