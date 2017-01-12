package facin.extensao.webservice2cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author Julio
 */
public class Cliente {
    public static void main(String[] args){
        Client cliente = null;
        try{
            cliente = ClientBuilder.newClient();
            String resultado =
                    cliente.target("http://localhost:8080/WebService2/rest/")
                    .path("alomundo")
                    .request()
                    .get(String.class);
            System.out.println(resultado);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if(cliente != null) {
                cliente.close();
            }
        }
    }
}
