package view.cliente.cadastro;

import infra.BancoDadosPessoaFisica;
import infra.BancoDadosPessoaJuridica;
import repository.ClienteRepository;
import service.PessoaFisicaService;
import service.PessoaJuridicaService;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuCadastroCliente extends MenuAbstrato {
    public MenuCadastroCliente(Scanner scanner) {
        super(new ItemMenu[]{
                new ItemMenu(1, "Pessoa Física"),
                new ItemMenu(2, "Pessoa Jurídica")
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> new MenuCadastroPessoaFisica(scanner,
                    new PessoaFisicaService(new ClienteRepository<>(new BancoDadosPessoaFisica())))
                    .executar();
            case 2 -> new MenuCadastroPessoaJuridica(scanner,
                    new PessoaJuridicaService(new ClienteRepository<>(new BancoDadosPessoaJuridica())))
                    .executar();
            default -> System.out.println("Opção Inválida");
        }
    }
}
