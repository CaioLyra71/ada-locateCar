package model.cliente;

import model.veiculo.Veiculo;

public abstract class Cliente {
    private String nomeCliente;
    private Veiculo veiculo;

    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.veiculo = null;
    }

    public Cliente() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}
