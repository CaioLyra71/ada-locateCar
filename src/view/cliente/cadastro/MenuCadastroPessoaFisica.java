package view.cliente.cadastro;

import model.cliente.ClientePessoaFisica;
import service.PessoaFisicaService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaFisica;

import java.util.Scanner;

public class MenuCadastroPessoaFisica {
    private final Scanner scanner;
    private final PessoaFisicaService clienteService;
    private final MostrarTodosPessoaFisica todosPessoaFisica;

    public MenuCadastroPessoaFisica(Scanner scanner, PessoaFisicaService clienteService) {
        this.scanner = scanner;
        this.clienteService = clienteService;
        this.todosPessoaFisica = new MostrarTodosPessoaFisica(new String[]{"Nome", "CPF"}, clienteService.listarTodos());
    }

    public void executar() {
        scanner.nextLine();
        todosPessoaFisica.executar();
        System.out.print("Informe o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Informe o CPF do cliente: ");
        String cpfCliente = scanner.nextLine();

        ClientePessoaFisica cliente = new ClientePessoaFisica(nomeCliente, cpfCliente);

        try {
            System.out.println(clienteService.salvarCliente(cliente));
        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }
    }
}
