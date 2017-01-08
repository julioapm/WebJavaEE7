package facin.extensao.jsf4.negocio;

/**
 *
 * @author Julio
 */
public class Cpf {

    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }

    public Cpf() {

    }

    public Cpf(String valor) {
        this.valor = valor;
    }
}
