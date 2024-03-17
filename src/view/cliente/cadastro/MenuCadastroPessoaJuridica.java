package view.cliente.cadastro;

import model.cliente.ClientePessoaJuridica;
import service.PessoaJuridicaService;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaFisica;
import view.cliente.util.MostrarTodosPessoaJuridica;

import java.util.Scanner;

public class MenuCadastroPessoaJuridica {

    private final Scanner scanner;
    private final PessoaJuridicaService pessoaJuridicaService;
    private final MostrarTodosPessoaJuridica todosPessoaJuridica;



    public MenuCadastroPessoaJuridica(Scanner scanner, PessoaJuridicaService pessoaJuridicaService) {
        this.scanner = scanner;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.todosPessoaJuridica = new MostrarTodosPessoaJuridica(new String[]{"Nome", "CNPJ"}, pessoaJuridicaService.listarTodos());
    }
    
    public void executar() {
        scanner.nextLine();
        todosPessoaJuridica.executar();
        System.out.print("Informe o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Informe o CNPJ do cliente: ");
        String cnpjCliente = scanner.nextLine();

        ClientePessoaJuridica cliente = new ClientePessoaJuridica(nomeCliente, cnpjCliente);

        try {
            System.out.println(pessoaJuridicaService.salvarCliente(cliente));
        } catch (ServicoException e) {
            System.err.println(e.getMessage());
        }
    }
}
