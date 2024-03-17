package view.cliente.atualizacao;

import infra.BancoDadosPessoaFisica;
import repository.ClienteRepository;
import service.PessoaFisicaService;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuAtualizacaoCliente extends MenuAbstrato {
    public MenuAtualizacaoCliente(Scanner scanner) {
        super(new ItemMenu[] {
                new ItemMenu(1, "Pessoa Física"),
                new ItemMenu(2, "Pessoa Jurídica")
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> new MenuAtualizacaoPessoaFisica(scanner,
                    new PessoaFisicaService(new ClienteRepository<>(new BancoDadosPessoaFisica())))
                    .executar();
            default -> System.out.println("Opção inválida");
        }
    }
}
