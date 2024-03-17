package view.veiculo.util;

import model.veiculo.Veiculo;
import view.components.tabela.TabelaView;

import java.util.List;

public class MostrarTodosVeiculos {
    private final String[] cabecalhos;
    private final String[][] linhas;
    private final List<Veiculo> veiculos;


    public MostrarTodosVeiculos(String[] cabecalhos, List<Veiculo> veiculos) {
        this.cabecalhos = cabecalhos;
        this.veiculos = veiculos;
        this.linhas = new String[veiculos.size()][cabecalhos.length];
    }

    public void execute() {
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            linhas[i][0] = veiculo.getNomeVeiculo();
            linhas[i][1] = veiculo.getTipoVeiculo();
            linhas[i][2] = veiculo.getValorDiaria().toString();
        }

        TabelaView tabelaView = new TabelaView(cabecalhos, linhas);
        tabelaView.executar();
    }
}
