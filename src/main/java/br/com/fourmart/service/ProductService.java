package br.com.fourmart.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import br.com.fourmart.dto.ProductDto;
import br.com.fourmart.entity.Product;
import br.com.fourmart.mapper.ProductMapper;
import br.com.fourmart.repository.ProductRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    @Inject
    private ProductMapper mapper;

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProductDto> listAll(final Sort sort) {
        return repository.listAll(sort)
                .stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<ProductDto> findByCode(final String code) {
        return repository.findByCode(code).map(mapper::toProductDto);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public ProductDto create(ProductDto product) {

        Product entity = mapper.toProduct(product);
        repository.persist(entity);

        return mapper.toProductDto(entity);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public ProductDto update(Long id, ProductDto product) throws NotFoundException, BadRequestException {

        Product entity = repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Product id not found"));

        if (!entity.getCode().equals(product.getCode())) {
            throw new BadRequestException("Invalid product code");
        }

        entity.setName(product.getName());
        entity.setValue(product.getValue());

        repository.persist(entity);

        return mapper.toProductDto(entity);
    }

}
