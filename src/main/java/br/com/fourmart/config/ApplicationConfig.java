package br.com.fourmart.config;

import javax.inject.Singleton;

import org.mapstruct.factory.Mappers;

import br.com.fourmart.mapper.ProductMapper;

public class ApplicationConfig {
    
    @Singleton
    public ProductMapper productMapper() {
        return Mappers.getMapper(ProductMapper.class);
    }

}
