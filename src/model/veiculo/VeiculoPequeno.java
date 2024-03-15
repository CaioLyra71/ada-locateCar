package model.veiculo;

import java.math.BigDecimal;

public class VeiculoPequeno extends Veiculo{
    public VeiculoPequeno(String nomeVeiculo, String placaVeiculo) {
        super(nomeVeiculo, "PEQUENO", placaVeiculo, true, BigDecimal.valueOf(100.00));
    }

    public VeiculoPequeno() {
    }
}
