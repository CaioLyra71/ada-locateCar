package repository;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDados;
import model.cliente.Cliente;
import repository.exceptions.RepositorioException;
import repository.interfaces.Repositorio;

import java.util.List;

public class ClienteRepository<K, V extends Cliente> implements Repositorio<K, V> {
    private final BancoDados<K, V> clienteBancoDados;

    public ClienteRepository(BancoDados<K, V> clienteBancoDados) {
        this.clienteBancoDados = clienteBancoDados;
    }

    @Override
    public V salvar(V t) throws RepositorioException {
        try {
            return clienteBancoDados.salvar(t);
        } catch (BancoDadosException e) {
            throw new RepositorioException(e.getMessage(), e);
        }
    }

    @Override
    public V atualizar(K k, V v) {
        return clienteBancoDados.atualizar(k, v);
    }

    @Override
    public List<V> listarTodos() {
        return clienteBancoDados.listarTodos();
    }

    @Override
    public V buscarPorId(K k) throws RepositorioException {
        V v = clienteBancoDados.buscarPorId(k);
        if (v == null) {
            throw new RepositorioException("Cliente não existe.");
        }
        return v;
    }
}
