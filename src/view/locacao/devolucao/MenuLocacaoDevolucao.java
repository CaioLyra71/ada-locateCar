package view.locacao.devolucao;

import infra.BancoDadosLocacao;
import infra.BancoDadosPessoaFisica;
import repository.ClienteRepository;
import repository.LocacaoRepository;
import service.LocacaoService;
import service.PessoaFisicaService;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuLocacaoDevolucao extends MenuAbstrato {
    public MenuLocacaoDevolucao(Scanner scanner) {
        super(new ItemMenu[]{
                new ItemMenu(1, "Locação Pessoa Física"),
                new ItemMenu(2, "Locação Pessoa Jurídica"),
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> new MenuLocacaoDevolucaoPessoaFisica(scanner,
                    new PessoaFisicaService(new ClienteRepository<>(new BancoDadosPessoaFisica())),
                    new LocacaoService(new LocacaoRepository(new BancoDadosLocacao())))
                    .exectuar();
            case 2 -> System.out.println("locação pj");
            default -> System.out.println("Opção Inválida");
        }
    }
}
