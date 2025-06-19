package edu.utl.aws.rest;

import edu.utl.aws.controlador.ControladorLibro;
import edu.utl.aws.modelo.Libro;
import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("libros")
public class RESTLibro {

    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertar(@FormParam("libro") @DefaultValue("") String datos){
        Gson objGS = new Gson();
        Libro l = objGS.fromJson(datos, Libro.class);

        if (l == null || l.getTitulo() == null || l.getEditorial() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("{\"error\": \"Datos incompletos o inválidos\"}")
                           .build();
        }

        String out = "";
        ControladorLibro cl = new ControladorLibro();
        try {
            cl.insertarLibro(l);
            out = "{\"ok\": \"Registro exitoso :D\"}";
        } catch (Exception e) {
            e.printStackTrace();
            out = String.format("{\"error\": \"Error interno: %s\"}", e.getMessage());
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
