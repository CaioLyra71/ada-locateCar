package repository;

import model.locacao.Locacao;
import repository.interfaces.Repositorio;
import repository.interfaces.RepositorioDeleta;

import java.util.List;

public class LocacaoRepository implements RepositorioDeleta<String, Locacao> {

    @Override
    public Locacao salvar(Locacao locacao) {
        return null;
    }

    @Override
    public Locacao atualizar(String s, Locacao locacao) {
        return null;
    }

    @Override
    public List<Locacao> listarTodos() {
        return null;
    }

    @Override
    public Locacao buscarPorId(String s) {
        return null;
    }

    @Override
    public String deletar(String s) {
        return null;
    }
}
