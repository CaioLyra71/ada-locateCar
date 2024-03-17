package model.locacao;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public abstract class Locacao {
    private Cliente cliente;
    private Set<Veiculo> veiculos;
    private String localDevolucao;
    private LocalDateTime dataReserva;
    private LocalDateTime dataDevolucaoPrevista;
    private BigDecimal desconto;


    public Locacao(Cliente cliente, Set<Veiculo> veiculos, String localDevolucao, LocalDateTime dataReserva, LocalDateTime dataDevolucaoPrevista, BigDecimal desconto) {
        this.cliente = cliente;
        this.veiculos = veiculos;
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

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculo(Set<Veiculo> veiculo) {
        this.veiculos = veiculo;
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
