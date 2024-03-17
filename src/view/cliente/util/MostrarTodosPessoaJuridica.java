package view.cliente.util;

import model.cliente.ClientePessoaJuridica;
import view.components.tabela.TabelaView;

import java.util.List;

public class MostrarTodosPessoaJuridica {
    private final String[] cabecalhos;
    private final String[][] linhas;
    private final List<ClientePessoaJuridica> clientes;

    public MostrarTodosPessoaJuridica(String[] cabecalhos, List<ClientePessoaJuridica> clientes) {
        this.cabecalhos = cabecalhos;
        this.clientes = clientes;
        this.linhas = new String[clientes.size()][cabecalhos.length];
    }

    public void executar() {
        for (int i = 0; i < clientes.size(); i++) {
            ClientePessoaJuridica cliente = clientes.get(i);
            linhas[i][0] = cliente.getNomeCliente();
            linhas[i][1] = cliente.getCnpj();
        }

        TabelaView tabelaView = new TabelaView(cabecalhos, linhas);
        tabelaView.executar();
    }
}
