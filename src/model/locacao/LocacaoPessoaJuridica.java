package model.locacao;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LocacaoPessoaJuridica extends Locacao{
    public LocacaoPessoaJuridica(Cliente cliente, Veiculo veiculo, String localDevolucao, LocalDateTime dataReserva, LocalDateTime dataDevolucaoPrevista, BigDecimal desconto) {
        super(cliente, veiculo, localDevolucao, dataReserva, dataDevolucaoPrevista, desconto);
    }

    public LocacaoPessoaJuridica() {
    }
}
