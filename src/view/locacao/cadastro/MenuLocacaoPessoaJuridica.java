package view.locacao.cadastro;

import model.locacao.Locacao;
import model.locacao.LocacaoPessoaFisica;
import model.locacao.LocacaoPessoaJuridica;
import model.veiculo.Veiculo;
import service.LocacaoService;
import service.PessoaFisicaService;
import service.PessoaJuridicaService;
import service.VeiculoService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaFisica;
import view.cliente.util.MostrarTodosPessoaJuridica;
import view.locacao.util.MenuEscolhaVeiculos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuLocacaoPessoaJuridica {
    private final Scanner scanner;
    private final PessoaJuridicaService clienteService;
    private final VeiculoService veiculoService;
    private final LocacaoService locacaoService;


    public MenuLocacaoPessoaJuridica(Scanner scanner, PessoaJuridicaService clienteService, VeiculoService veiculoService, LocacaoService locacaoService) {
        this.scanner = scanner;
        this.clienteService = clienteService;
        this.veiculoService = veiculoService;
        this.locacaoService = locacaoService;
    }


    public void executar() {
        scanner.nextLine();
        MostrarTodosPessoaJuridica todosPessoaJuridica = new MostrarTodosPessoaJuridica(
                new String[]{"Nome", "CNPJ"}, clienteService.listarTodos()
        );
        todosPessoaJuridica.executar();

        System.out.println("Informe o CNPJ do cliente: ");
        String cnpjCliente = scanner.nextLine();
        try {
            var clienteDesejado = clienteService.buscarClientePorId(cnpjCliente);

            var escolhaVeiculos = new MenuEscolhaVeiculos(scanner, veiculoService);
            Veiculo veiculoDesejado = escolhaVeiculos.executar();

            System.out.print("Informe o local de devolução: ");
            String localDevolucao = scanner.nextLine();

            System.out.print("Informe a quantidade de diárias: ");
            long diarias = scanner.nextLong();

            LocalDateTime dataReserva = LocalDateTime.now();
            LocalDateTime dataDevolucaoPrevista = dataReserva.plusDays(diarias);

            Locacao novaLocacao = new LocacaoPessoaJuridica(clienteDesejado, veiculoDesejado, localDevolucao, dataReserva, dataDevolucaoPrevista, new BigDecimal("10.00"));

            System.out.println(locacaoService.salvarLocacao(novaLocacao));

        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }
    }
}
