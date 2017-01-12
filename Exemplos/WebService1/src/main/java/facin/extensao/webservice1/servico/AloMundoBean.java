package facin.extensao.webservice1.servico;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Julio
 */
@WebService(serviceName = "AloMundoBean")
@Stateless
public class AloMundoBean {

    @WebMethod
    public String getSaudacao() {
        return "Alô Mundo!";
    }

    @WebMethod(operationName = "saudar")
    public String getSaudacaoNomeada(String nome) {
        return "Alô " + nome + " !";
    }
}
