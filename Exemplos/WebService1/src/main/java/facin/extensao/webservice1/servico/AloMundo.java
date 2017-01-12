package facin.extensao.webservice1.servico;

import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Julio
 */
@WebService
public class AloMundo {

    @WebMethod
    public String getSaudacao() {
        return "Alô Mundo!";
    }
    
    @WebMethod(operationName = "saudar")
    public String getSaudacaoNomeada(String nome) {
        return "Alô " + nome + " !";
    }
}
