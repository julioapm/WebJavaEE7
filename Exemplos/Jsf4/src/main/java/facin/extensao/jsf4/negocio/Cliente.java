package facin.extensao.jsf4.negocio;

/**
 *
 * @author Julio
 */
public class Cliente {

    private String nome;
    private int idade;
    private Cpf cpf;

    public Cliente() {
        nome = "Desconhecido";
        idade = 1;
        cpf = new Cpf("00000000000");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }
}
