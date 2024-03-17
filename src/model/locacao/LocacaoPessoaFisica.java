package model.locacao;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class LocacaoPessoaFisica extends Locacao{
    public LocacaoPessoaFisica(Cliente cliente, Veiculo veiculo, String localDevolucao, LocalDateTime dataReserva, LocalDateTime dataDevolucaoPrevista, BigDecimal desconto) {
        super(cliente, veiculo, localDevolucao, dataReserva, dataDevolucaoPrevista, desconto);
    }

    public LocacaoPessoaFisica() {
    }
}
