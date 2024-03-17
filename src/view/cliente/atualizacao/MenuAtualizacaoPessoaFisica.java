package view.cliente.atualizacao;

import model.cliente.ClientePessoaFisica;
import service.PessoaFisicaService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaFisica;

import java.util.Scanner;

public class MenuAtualizacaoPessoaFisica {
    private final Scanner scanner;
    private final PessoaFisicaService clienteService;
    private final MostrarTodosPessoaFisica todosPessoaFisica;

    public MenuAtualizacaoPessoaFisica(Scanner scanner, PessoaFisicaService clienteService) {
        this.scanner = scanner;
        this.clienteService = clienteService;
        this.todosPessoaFisica = new MostrarTodosPessoaFisica(new String[]{"Nome", "CPF"}, clienteService.listarTodos());
    }

    public void executar() {
        scanner.nextLine();
        todosPessoaFisica.executar();

        System.out.print("Informe o CPF do cliente: ");
        String cpfClienteDesejado = scanner.nextLine();
        try {
            ClientePessoaFisica clienteDesejado = clienteService.buscarClientePorId(cpfClienteDesejado);
            System.out.print("Informe o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Infome o novo CPF: ");
            String novoCpf = scanner.nextLine();

            if (novoNome != null && !novoNome.trim().isEmpty()){
                clienteDesejado.setNomeCliente(novoNome);
            }
            if (novoCpf != null && !novoCpf.trim().isEmpty()) {
                clienteDesejado.setCpf(novoCpf);
            }

            System.out.println(clienteService.atualizarCliente(cpfClienteDesejado, clienteDesejado));
        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }
    }
}
