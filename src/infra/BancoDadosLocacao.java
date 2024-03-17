package infra;

import infra.exceptions.BancoDadosException;
import infra.interfaces.BancoDadosDeleta;
import model.cliente.Cliente;
import model.locacao.Locacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoDadosLocacao implements BancoDadosDeleta<Cliente, Locacao> {
    private final static Map<Cliente, Locacao> locacoes = new HashMap<>();

    @Override
    public Locacao salvar(Locacao locacao) throws BancoDadosException {
        Locacao locacaoExistente = buscarPorId(locacao.getCliente());
        if (locacaoExistente != null){
            throw new BancoDadosException("Este registro já existe");
        }
        return locacoes.put(locacao.getCliente(), locacao);
    }

    @Override
    public Locacao atualizar(Cliente idLocacao, Locacao locacao) {
        if(!idLocacao.equals(locacao.getCliente())) {
            deletar(idLocacao);
        }
        return locacoes.put(locacao.getCliente(), locacao);
    }

    @Override
    public List<Locacao> listarTodos() {
        List<Locacao> registros = new ArrayList<>();
        var entries = locacoes.entrySet();
        for (var entry : entries){
            registros.add(entry.getValue());
        }
        return registros;
    }

    @Override
    public Locacao buscarPorId(Cliente cliente) {
        return locacoes.get(cliente);
    }

    @Override
    public Locacao deletar(Cliente idLocacao) {
        return locacoes.remove(idLocacao);
    }
}
