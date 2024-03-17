package view.locacao.cadastro;

import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuLocacaoCadastro extends MenuAbstrato {
    public MenuLocacaoCadastro(Scanner scanner) {
        super(new ItemMenu[]{
                new ItemMenu(1, "Locação Pessoa Física"),
                new ItemMenu(2, "Locação Pessoa Jurídica"),
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> System.out.println("locação pf");
            case 2 -> System.out.println("locação pj");
            default -> System.out.println("Opção Inválida");
        }
    }
}
