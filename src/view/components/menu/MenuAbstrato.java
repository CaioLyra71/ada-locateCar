package view.components.menu;

import java.util.Scanner;

public abstract class MenuAbstrato {

    private final ItemMenu[] itensMenu;
    protected final Scanner scanner;

    public MenuAbstrato(ItemMenu[] itensMenu, Scanner scanner) {
        this.itensMenu = itensMenu;
        this.scanner = scanner;
    }

    public void executar() {
        for(ItemMenu itemMenu : itensMenu) {
            System.out.println(itemMenu.getCodigo() + " - " + itemMenu.getTexto());
        }
        System.out.print("Informe o número da opção: ");
        try {
            Integer opcao = scanner.nextInt();
            System.out.println();
            executarOpcao(opcao);
        } catch (Exception e) {
            System.err.println("Entrada inválida");
            executar();
        }
    }

    protected abstract void executarOpcao(Integer opcao);
}

