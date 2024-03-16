package model.locacao;

import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class LocacaoPessoaFisica extends Locacao{
    public LocacaoPessoaFisica(Cliente cliente, Set<Veiculo> veiculos, String localDevolucao, LocalDateTime dataReserva, LocalDateTime dataDevolucaoPrevista, BigDecimal desconto) {
        super(cliente, veiculos, localDevolucao, dataReserva, dataDevolucaoPrevista, desconto);
    }

    public LocacaoPessoaFisica() {
    }
}
