package py.com.ffcc.jee.example.rs;

import py.com.ffcc.jee.example.model.Venta;
import py.com.ffcc.jee.example.service.VentaService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/venta")
public class VentaResource {

    @Inject
    VentaService ventaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venta> listar() {
        return ventaService.listar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Venta crear(Venta venta) {
        return ventaService.crear(venta);
    }
}
