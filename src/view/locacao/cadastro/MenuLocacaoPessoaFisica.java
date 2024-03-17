package view.locacao.cadastro;

import model.locacao.Locacao;
import model.locacao.LocacaoPessoaFisica;
import model.veiculo.Veiculo;
import service.LocacaoService;
import service.PessoaFisicaService;
import service.VeiculoService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaFisica;
import view.locacao.util.MenuEscolhaVeiculos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuLocacaoPessoaFisica {
    private final Scanner scanner;
    private final PessoaFisicaService clienteService;
    private final VeiculoService veiculoService;
    private final LocacaoService locacaoService;

    public MenuLocacaoPessoaFisica(Scanner scanner, PessoaFisicaService clienteService, VeiculoService veiculoService, LocacaoService locacaoService) {
        this.scanner = scanner;
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
        this.locacaoService = locacaoService;
    }

    public void executar() {
        scanner.nextLine();
        MostrarTodosPessoaFisica todosPessoaFisica = new MostrarTodosPessoaFisica(
                new String[]{"Nome", "CPF"}, clienteService.listarTodos()
        );
        todosPessoaFisica.executar();

        System.out.println("Informe o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();
        try {
            var clienteDesejado = clienteService.buscarClientePorId(cpfCliente);

            var escolhaVeiculos = new MenuEscolhaVeiculos(scanner, veiculoService);
            Veiculo veiculoDesejado = escolhaVeiculos.executar();

            System.out.print("Informe o local de devolução: ");
            String localDevolucao = scanner.nextLine();

            System.out.print("Informe a quantidade de diárias: ");
            long diarias = scanner.nextLong();

            LocalDateTime dataReserva = LocalDateTime.now();
            LocalDateTime dataDevolucaoPrevista = dataReserva.plusDays(diarias);

            Locacao novaLocacao = new LocacaoPessoaFisica(clienteDesejado, veiculoDesejado, localDevolucao, dataReserva, dataDevolucaoPrevista, new BigDecimal("5.00"));

            System.out.println(locacaoService.salvarLocacao(novaLocacao));

        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }
    }
}
