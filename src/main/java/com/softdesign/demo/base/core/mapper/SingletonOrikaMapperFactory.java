package com.softdesign.demo.base.core.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import static java.util.Objects.isNull;

public class SingletonOrikaMapperFactory {
    private static MapperFactory factory;

    private SingletonOrikaMapperFactory() {}

    public static MapperFactory getInstance() {
        if (isNull(factory)) {
            factory = new DefaultMapperFactory.Builder().build();
        }
        return factory;
    }


}
