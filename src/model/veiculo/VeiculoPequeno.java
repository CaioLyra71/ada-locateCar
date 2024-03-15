package model.veiculo;

import java.math.BigDecimal;

public class VeiculoPequeno extends Veiculo{
    public VeiculoPequeno(String nomeVeiculo, String placaVeiculo, Boolean estaDisponivel, BigDecimal valorDiaria) {
        super(nomeVeiculo, "PEQUENO", placaVeiculo, estaDisponivel, valorDiaria);
    }

    public VeiculoPequeno() {
    }
}
