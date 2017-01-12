package facin.extensao.webservice2.servico;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Julio
 */
@Path("alomundo")
public class AloMundo {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSaudacao() {
        return "Alô Mundo!";
    }

    @GET
    @Path("{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSaudacaoNomeada(@PathParam("nome") String nome) {
        return "Alô " + nome + " !";
    }
    
}
