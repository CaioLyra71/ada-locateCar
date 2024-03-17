package view.components.tabela;

public class TabelaView {
    private Integer tamanho = 20;
    private final String[] cabecalhos;
    private final String[][] linhas;

    public TabelaView(String[] cabecalhos, String[][] linhas) {
        this.cabecalhos = cabecalhos;
        this.linhas = linhas;
    }

    public void executar() {
        mostrarCabecalho();
        mostrarLinhas();
    }

    private void mostrarCabecalho() {
        for (String cabecalho : cabecalhos) {
            System.out.printf("| %-" + tamanho + "s", cabecalho);
        }
        System.out.println(" |");
    }

    private void mostrarLinhas() {
        for (String[] linha : linhas) {
            for (String coluna : linha) {
                System.out.printf("| %-" + tamanho + "s", coluna);
            }
            System.out.println(" |");
        }
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public String[] getCabecalhos() {
        return cabecalhos;
    }

    public String[][] getLinhas() {
        return linhas;
    }
}
