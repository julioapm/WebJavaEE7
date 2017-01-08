package facin.extensao.jsf4.web;

import facin.extensao.jsf4.negocio.Cliente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Julio
 */
@Named
@RequestScoped
public class CadastroBean {

    private Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
