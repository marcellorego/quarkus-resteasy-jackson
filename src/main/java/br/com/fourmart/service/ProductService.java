package br.com.fourmart.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
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

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(
        ProductRepository repository,
        ProductMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ProductDto> listAll(final Sort sort) {
        return repository.listAll(sort)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<ProductDto> findById(final Long id) {
        return repository.findByIdOptional(id).map(mapper::toDto);
    }

    @Transactional(Transactional.TxType.SUPPORTS)
    public Optional<ProductDto> findByCode(final String code) {
        return repository.findByCode(code).map(mapper::toDto);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public ProductDto create(ProductDto product) {

        if (repository.findByCode(product.getCode()).isPresent()) {
            throw new BadRequestException("There is another product with same code");
        }

        Product entity = mapper.toEntity(product);
        repository.persist(entity);

        return mapper.toDto(entity);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public ProductDto update(final Long id, final ProductDto product) throws NotFoundException, BadRequestException {

        if (Objects.isNull(id)) {
            throw new BadRequestException("Invalid product id");
        }

        Product entity = repository.findByIdOptional(product.getId()).orElseThrow(() -> new NotFoundException("Product id not found"));

        if (!entity.getCode().equals(product.getCode())) {
            throw new BadRequestException("Invalid product code");
        }

        if (repository.findByCode(product.getCode()).map(Product::getId).filter(idCode -> idCode.equals(id)).isPresent()) {
            throw new BadRequestException("There is another product with same code");
        }

        entity.setName(product.getName());
        entity.setValue(product.getValue());

        repository.persist(entity);

        return mapper.toDto(entity);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(final Long id) throws NotFoundException, BadRequestException {
        Product entity = repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Product id not found"));
        repository.delete(entity);
    }

}
