package view.locacao.devolucao;

import model.cliente.ClientePessoaFisica;
import model.locacao.Locacao;
import service.LocacaoService;
import service.PessoaFisicaService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuLocacaoDevolucaoPessoaFisica {

    private final Scanner scanner;
    private final PessoaFisicaService clienteService;
    private final LocacaoService locacaoService;

    public MenuLocacaoDevolucaoPessoaFisica(Scanner scanner, PessoaFisicaService clienteService, LocacaoService locacaoService) {
        this.scanner = scanner;
        this.clienteService = clienteService;
        this.locacaoService = locacaoService;
    }

    private void validarData(String dataString) {
        if (!dataString.matches("^\\d\\d\\d\\d-(0?[1-9]|1[0-2])-(0?[1-9]|[12][0-9]|3[01]) (00|[0-9]|1[0-9]|2[0-3]):([0-9]|[0-5][0-9])$")){
            throw new ModeloException("Data inválida. Ex.: 2024-01-02 12:12");
        }
    }
    public void exectuar(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        scanner.nextLine();
        System.out.println("Informe o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();

        try {
            ClientePessoaFisica clienteDesejado = clienteService.buscarClientePorId(cpfCliente);
            Locacao locacaoDesejada = locacaoService.buscarLocacaoPorId(clienteDesejado);
            System.out.print("Informe a data de devolução: ");
            String dataDevolucao = scanner.nextLine();
            validarData(dataDevolucao);
            LocalDateTime dataEntega = LocalDateTime.parse(dataDevolucao, formatter);

            System.out.println(locacaoService.devolverVeiculo(locacaoDesejada, dataEntega));

        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }


    }
}
