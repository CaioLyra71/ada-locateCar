package model.veiculo;

import java.math.BigDecimal;

public class VeiculoSUV extends Veiculo{
    public VeiculoSUV(String nomeVeiculo, String placaVeiculo) {
        super(nomeVeiculo, "SUV", placaVeiculo, true, new BigDecimal("200.00"));
    }

    public VeiculoSUV() {
    }
}
