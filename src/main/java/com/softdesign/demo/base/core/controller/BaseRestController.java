package com.softdesign.demo.base.core.controller;

import com.softdesign.demo.base.core.dto.BaseDTO;
import com.softdesign.demo.base.core.mapper.BaseMapperFactory;
import com.softdesign.demo.base.core.model.AbstractModel;
import com.softdesign.demo.base.core.service.BaseService;
import ma.glasnost.orika.BoundMapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseRestController<D extends BaseDTO, M extends AbstractModel, S extends BaseService<M>> {

    @Autowired
    private BaseMapperFactory<D, M> mapperFactory;

    @Autowired
    protected S service;


    protected M toModel(D dto) {
        return getDTOMapper().map(dto);
    }

    protected D toDTO(M model) {
        return getModelMapper().map(model);
    }

    protected List<D> toDTOList(List<M> models) {
        return models.stream().map(this::toDTO).collect(Collectors.toList());
    }

    protected List<M> toModelList(List<D> dtos) {
        return dtos.stream().map(this::toModel).collect(Collectors.toList());
    }

    protected BoundMapperFacade<D, M> getDTOMapper() {
        return BaseMapperFactory.getMapper(mapperFactory.getDTOClass(), mapperFactory.getModelClass());
    }

    protected BoundMapperFacade<M, D> getModelMapper() {
        return BaseMapperFactory.getMapper(mapperFactory.getModelClass(), mapperFactory.getDTOClass());
    }

    protected Page<D> toDTOPage(Page<M> modelPage) {
        return modelPage.map(this::toDTO);
    }

}
