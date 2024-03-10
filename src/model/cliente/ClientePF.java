package model.cliente;

public class ClientePF extends Cliente{

    private String cpf;

    public ClientePF(String nomeCliente, String cpf) {
        super(nomeCliente);
        this.cpf = cpf;
    }

    public ClientePF(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
