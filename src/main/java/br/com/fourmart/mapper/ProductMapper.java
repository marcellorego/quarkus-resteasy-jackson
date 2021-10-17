package br.com.fourmart.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.fourmart.dto.ProductDto;
import br.com.fourmart.entity.Product;

@Mapper(
    config = MappingConfig.class,
    implementationName = "ProductMapperImpl")
public abstract class ProductMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "value", source = "value")
    public abstract ProductDto toDto(Product product);

    @InheritInverseConfiguration
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract Product toEntity(ProductDto product);
}
