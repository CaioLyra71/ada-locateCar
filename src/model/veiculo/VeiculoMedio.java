package model.veiculo;


import java.math.BigDecimal;

public class VeiculoMedio extends Veiculo{
    public VeiculoMedio(String nomeVeiculo, String placaVeiculo, Boolean estaDisponivel, BigDecimal valorDiaria) {
        super(nomeVeiculo, placaVeiculo, estaDisponivel, valorDiaria);
    }

    public VeiculoMedio() {
    }
}
