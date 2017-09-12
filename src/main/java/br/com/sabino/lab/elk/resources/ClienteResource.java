package br.com.sabino.lab.elk.resources;

import br.com.sabino.lab.elk.domain.Cliente;
import br.com.sabino.lab.elk.services.ClienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Stateless
@Path("/clientes")
public class ClienteResource {

    private static final Logger logger = LogManager.getLogger(ClienteResource.class.getName());
    public static final String BAD_REQUEST_CONTENT = "400 Bad Request";
    private ClienteService service;

    @Inject
    public void setService(ClienteService service) {
        this.service = service;
    }

    @POST
    @Consumes("application/json")
    public Response create(Cliente cliente) {
        service.novo(cliente);
        logger.warn("O cliente " + cliente.getNome() + " foi inserido!");
        return getResponse(cliente, "Criado");
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response deleteById(@PathParam("id") Long id) {
        Cliente cliente = service.buscarPeloId(id);
        service.remove(id);
        logger.info("O cliente " + cliente.getNome() + " foi excluido!");
        return getResponse(cliente, "Removido");
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public Cliente findById(@PathParam("id") Long id) {
        Cliente cliente = service.buscarPeloId(id);
        logger.info("foi buscado o cliente " + cliente.getNome());
        return service.buscarPeloId(id);
    }

    @GET
    @Produces("application/json")
    public List<Cliente> listAll() {
        logger.info("Foram buscados " + service.todos().size() + " clientes");
        return service.todos();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @Consumes("application/json")
    public Response update(@PathParam("id") Long id) {
        Cliente cliente = service.atualiza(service.buscarPeloId(id));
        logger.info("O cliente " + cliente.getNome() + " foi alterado!");
        return getResponse(cliente, "atualizado");
    }

    private Response getResponse(Cliente cliente, String message) {
        Response response = Response.status(200).type("application/json")
                .entity("Cliente: " + cliente.getNome() + ", " + message + " com sucesso!").build();
        if (cliente == null) {
            response = Response.status(403).type("text/plain").entity("Cliente inválido!").build();
        }
        return response;
    }
}
