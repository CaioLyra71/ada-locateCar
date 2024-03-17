package view.locacao;

import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;
import view.locacao.cadastro.MenuLocacaoCadastro;
import view.locacao.devolucao.MenuLocacaoDevolucao;

import java.util.Scanner;

public class MenuLocacao extends MenuAbstrato {
    public MenuLocacao(Scanner scanner) {
        super(new ItemMenu[] {
                new ItemMenu(1, "Cadastrar"),
                new ItemMenu(2, "Atualizar"),
                new ItemMenu(3, "Devolução"),
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> new MenuLocacaoCadastro(scanner).executar();
            case 2 -> System.out.println("Ainda não implementado. Virá em novas versões.");
            case 3 -> new MenuLocacaoDevolucao(scanner).executar();
            default -> System.out.println("Opção Inválida");
        }
    }
}
