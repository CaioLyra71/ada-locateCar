package model.locacao;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private String localDevolucao;
    private LocalDateTime dataReserva;
    private LocalDateTime dataDevolucaoPrevista;
    private BigDecimal desconto;


    public Locacao(Cliente cliente, Veiculo veiculo, String localDevolucao, LocalDateTime dataReserva, LocalDateTime dataDevolucaoPrevista, BigDecimal desconto) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.localDevolucao = localDevolucao;
        this.dataReserva = dataReserva;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.desconto = desconto;
    }

    public Locacao() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getLocalDevolucao() {
        return localDevolucao;
    }

    public void setLocalDevolucao(String localDevolucao) {
        this.localDevolucao = localDevolucao;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }


    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }
}
