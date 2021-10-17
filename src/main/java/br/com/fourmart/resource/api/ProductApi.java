package br.com.fourmart.resource.api;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fourmart.dto.ProductDto;

@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductApi {
    

    // @APIResponses(
    //         value = {
    //                 @APIResponse(
    //                         responseCode = "200",
    //                         description = "Get All Customers",
    //                         content = @Content(mediaType = "application/json",
    //                                 schema = @Schema(type = SchemaType.ARRAY, implementation = Customer.class)))
    //         }
    // )
    @GET
    List<ProductDto> listAll();

    @GET
    @Path(value = "/code/{code}")
    public ProductDto findByCode(@PathParam(value = "code") final String code) throws NotFoundException;

    @POST
    public ProductDto create(@Valid final ProductDto product);

    @PUT
    @Path(value = "/{id}")
    public ProductDto update(@PathParam("id") final Long id, @Valid final ProductDto product) throws NotFoundException;

    @DELETE
    @Path(value = "/{id}")
    public Response delete(final Long id) throws NotFoundException;

}