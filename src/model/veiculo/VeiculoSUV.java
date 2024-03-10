package model.veiculo;

import java.math.BigDecimal;

public class VeiculoSUV extends Veiculo{
    public VeiculoSUV(String nomeVeiculo, String placaVeiculo, Boolean estaDisponivel, BigDecimal valorDiaria) {
        super(nomeVeiculo, placaVeiculo, estaDisponivel, valorDiaria);
    }

    public VeiculoSUV() {
    }
}
