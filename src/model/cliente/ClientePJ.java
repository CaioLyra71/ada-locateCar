package model.cliente;

public class ClientePJ extends Cliente{

    private String cnpj;

    public ClientePJ(String nomeCliente, String cnpj) {
        super(nomeCliente);
        this.cnpj = cnpj;
    }

    public ClientePJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
