package view.cliente.atualizacao;

import model.cliente.ClientePessoaFisica;
import service.PessoaJuridicaService;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;
import view.cliente.util.MostrarTodosPessoaJuridica;

import java.util.Scanner;

public class MenuAtualizacaoPessoaJuridica {
    private final Scanner scanner;
    private final PessoaJuridicaService pessoaJuridicaService;
    private final MostrarTodosPessoaJuridica todosPessoaJuridica;

    public MenuAtualizacaoPessoaJuridica(Scanner scanner, PessoaJuridicaService pessoaJuridicaService, MostrarTodosPessoaJuridica todosPessoaJuridica) {
        this.scanner = scanner;
        this.pessoaJuridicaService = pessoaJuridicaService;
        this.todosPessoaJuridica = new MostrarTodosPessoaJuridica(new String[]{"Nome", "CNPJ"}, pessoaJuridicaService.listarTodos());
    }

    public void executar(){
        scanner.nextLine();
        todosPessoaJuridica.executar();

        System.out.print("Informe o CNPJ do cliente: ");
        String cnpjClienteDesejado = scanner.nextLine();
        try {
            var clienteDesejado = pessoaJuridicaService.buscarClientePorId(cnpjClienteDesejado);
            System.out.print("Informe o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Infome o novo CNPJ: ");
            String novoCnpj = scanner.nextLine();

            if (novoNome != null && !novoNome.trim().isEmpty()){
                clienteDesejado.setNomeCliente(novoNome);
            }
            if (novoCnpj != null && !novoCnpj.trim().isEmpty()) {
                clienteDesejado.setCnpj(novoCnpj);
            }

            System.out.println(pessoaJuridicaService.atualizarCliente(cnpjClienteDesejado, clienteDesejado));
        } catch (ServicoException | ModeloException e) {
            System.err.println(e.getMessage());
        }
    }
}
