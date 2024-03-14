package model.cliente;

public class ClientePessoaJuridica extends Cliente{

    private String cnpj;

    public ClientePessoaJuridica(String nomeCliente, String cnpj) {
        super(nomeCliente);
        this.cnpj = cnpj;
    }

    public ClientePessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
