package com.softdesign.demo.base.core.mapper;

import com.softdesign.demo.base.core.dto.BaseDTO;
import com.softdesign.demo.base.core.exception.BaseIdentifiedException;
import com.softdesign.demo.base.core.model.AbstractModel;
import com.softdesign.demo.base.core.model.GenericErrors;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.TypeFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public class BaseMapperFactory<D extends BaseDTO, M extends AbstractModel> {

    private static final MapperFactory factory = SingletonOrikaMapperFactory.getInstance();


    @PostConstruct
    protected void register() {
        registerClass();
        registerConverters();
        registerFactory();
    }

    private void registerConverters() {
        ConverterFactory converterFactory = factory.getConverterFactory();
        getConverters().forEach(converterFactory::registerConverter);
    }

    private Map<String, Converter> getConverters() {
        return new HashMap<>();
    }

    protected void registerClass() {
        ClassMapBuilder<D, M> classMapBuilder = factory.classMap(getDTOClass(), getModelClass());

        prepareMapper(classMapBuilder);

        CustomMapper<D, M> mapper = getCustomizedMapper();
        if (nonNull(mapper)) {
            classMapBuilder.customize(mapper);
        }

        classMapBuilder.register();
    }

    protected CustomMapper<D, M> getCustomizedMapper() {
        return null;
    }

    protected ClassMapBuilder<D, M> prepareMapper(ClassMapBuilder<D, M> mapper) {
        return mapper.byDefault();
    }

    protected void registerFactory() {
        factory.registerObjectFactory((o, mappingContext) -> newDTO(), TypeFactory.valueOf(getDTOClass()));
        factory.registerObjectFactory((o, mappingContext) -> newModel(), TypeFactory.valueOf(getModelClass()));
    }

    public static <A, B> BoundMapperFacade<A, B> getMapper(Class<A> classFrom, Class<B> classTo) {
        return factory.getMapperFacade(classFrom, classTo);
    }

    @SuppressWarnings("unchecked")
    public Class<D> getDTOClass() {
        Class<D> result;
        try {
            result = (Class<D>) getInternalDTOType();
        } catch (Exception ignored) {
            throw new BaseIdentifiedException(GenericErrors.EINT002);
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public Class<M> getModelClass() {
        Class<M> result;
        try {
            result = (Class<M>) getInternalModelType();
        } catch (Exception ignored) {
            throw new BaseIdentifiedException(GenericErrors.EINT002);
        }
        return result;
    }

    private Type getInternalDTOType() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    private Type getInternalModelType() {
        return ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private D newDTO() {
        try {
            return getDTOClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    private M newModel() {
        try {
            return getModelClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BaseIdentifiedException(GenericErrors.EINT002);
        }
    }
}
