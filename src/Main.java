import view.Menu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuAbstrato menu = new Menu(new Scanner(System.in));
        menu.executar();
    }
}
