package infra;

import infra.interfaces.BancoDados;
import infra.interfaces.BancoDadosDeleta;
import model.cliente.Cliente;
import model.veiculo.Veiculo;

import java.util.Map;

public class BandoDadosLocacao implements BancoDadosDeleta<Cliente, Veiculo> {
    private Map<Cliente, Veiculo> locacao;

    public BandoDadosLocacao(Map<Cliente, Veiculo> locacao) {
        this.locacao = locacao;
    }

    @Override
    public Boolean salvar(Veiculo veiculo) {
        return null;
    }

    @Override
    public Boolean atualizar(Cliente cliente, Veiculo veiculo) {
        return null;
    }

    @Override
    public Boolean deletar(Cliente cliente) {
        return null;
    }
}
