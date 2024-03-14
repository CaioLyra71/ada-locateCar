package model.cliente;

public class ClientePessoaFisica extends Cliente{

    private String cpf;

    public ClientePessoaFisica(String nomeCliente, String cpf) {
        super(nomeCliente);
        this.cpf = cpf;
    }

    public ClientePessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
