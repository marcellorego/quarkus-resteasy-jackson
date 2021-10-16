package br.com.fourmart.resource.api;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fourmart.dto.ProductDto;

@Path("/api/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductApi {
    
    @GET
    List<ProductDto> listAll();

    @GET
    @Path(value = "/code/{code}")
    public ProductDto findByCode(@PathParam(value = "code") final String code) throws NotFoundException;

    @POST
    public ProductDto create(@Valid ProductDto product);

    @PUT
    @Path(value = "/{id}")
    public ProductDto update(@PathParam("id") Long id, @Valid ProductDto product) throws NotFoundException;

}
