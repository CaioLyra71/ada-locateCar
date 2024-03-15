package repository;

import model.veiculo.Veiculo;

public class VeiculoRepository implements BuscaPorNome<Veiculo> {
    @Override
    public Boolean salvar(Veiculo veiculo) {
        return null;
    }

    @Override
    public Veiculo buscarPorNome(String nome) {
        return null;
    }

    @Override
    public Veiculo buscarPorId(String id) {
        return null;
    }

    @Override
    public Veiculo atualizar(String id, Veiculo veiculo) {
        return null;
    }

    @Override
    public Boolean deletar(String id) {
        return null;
    }
}
