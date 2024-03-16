package model.locacao;

import model.cliente.Cliente;
import model.exceptions.VeiculoNaoEncontradoException;
import model.veiculo.Veiculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    public String locarVeiculo(Veiculo veiculo){
        veiculo.setEstaDisponivel(false);
        veiculos.add(veiculo);
        return "Locação realizada com sucesso!";
    }

    public String devolverVeiculo(Veiculo veiculo) {
        if (!veiculos.contains(veiculo)) {
            throw new VeiculoNaoEncontradoException("Veículos não está registrado neste contrato de locação.");
        }
        Long dias = calcularDiarias();

        BigDecimal valorAluguel = BigDecimal.valueOf(veiculo.getValorDiaria().doubleValue() * dias);
        BigDecimal descontoPercentual = desconto.divide(new BigDecimal("100.00"), RoundingMode.HALF_UP);
        if(dias >= 5) {
            valorAluguel = valorAluguel.multiply(descontoPercentual);
        }
        veiculo.setEstaDisponivel(true);
        return "Veículo devolvido com sucesso\n" +
                "Total a pagar: R$" + valorAluguel;
    }

    private Long calcularDiarias(){
        Long diasTranscorridos = ChronoUnit.DAYS.between(dataReserva, dataDevolucaoPrevista);
        Long horasTranscorridas = ChronoUnit.HOURS.between(dataReserva,dataDevolucaoPrevista);

        if (horasTranscorridas % 24 != 0){
            diasTranscorridos++;
        }

        return diasTranscorridos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Veiculo> getVeiculo() {
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
