package br.com.fourmart.resource;

import java.util.List;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import br.com.fourmart.dto.ProductDto;
import br.com.fourmart.resource.api.ProductApi;
import br.com.fourmart.service.ProductService;
import io.quarkus.panache.common.Sort;

public class ProductResource implements ProductApi {

    private final ProductService service;
    
    public ProductResource(ProductService service) {
        this.service = service;
    }

    @Override
    public List<ProductDto> listAll() {
        return service.listAll(Sort.ascending("name"));
    }

    @Override
    public ProductDto findByCode(final String code) throws NotFoundException {
        return service.findByCode(code).orElseThrow(() -> new NotFoundException("No such product code"));
    }

    @Override
    public ProductDto create(final ProductDto product) {
        return service.create(product);
    }

    @Override
    public ProductDto update(final Long id, final ProductDto product) throws NotFoundException {
        return service.update(id, product);
    }

    @Override
    public Response delete(final Long id) throws NotFoundException {
        service.delete(id);
        return Response.noContent().build();
    }
}