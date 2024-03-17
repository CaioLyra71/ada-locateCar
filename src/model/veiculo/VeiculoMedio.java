package model.veiculo;


import java.math.BigDecimal;

public class VeiculoMedio extends Veiculo{
    public VeiculoMedio(String nomeVeiculo, String placaVeiculo) {
        super(nomeVeiculo, "MEDIO", placaVeiculo, true, new BigDecimal("150.00"));
    }

    public VeiculoMedio() {
    }
}
