package model.veiculo;

import java.math.BigDecimal;

public abstract class Veiculo {
    private String nomeVeiculo;
    private String placaVeiculo;
    private Boolean estaDisponivel;
    private BigDecimal valorDiaria;


    public Veiculo(String nomeVeiculo, String placaVeiculo, Boolean estaDisponivel, BigDecimal valorDiaria) {
        this.nomeVeiculo = nomeVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.estaDisponivel = estaDisponivel;
        this.valorDiaria = valorDiaria;
    }

    public Veiculo() {}

    public String getNomeVeiculo() {
        return nomeVeiculo;
    }

    public void setNomeVeiculo(String nomeVeiculo) {
        this.nomeVeiculo = nomeVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public Boolean getEstaDisponivel() {
        return estaDisponivel;
    }

    public void setEstaDisponivel(Boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
}
