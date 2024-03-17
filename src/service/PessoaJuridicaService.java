package service;

import model.cliente.ClientePessoaJuridica;
import repository.exceptions.RepositorioException;
import repository.interfaces.Repositorio;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.util.List;

public class PessoaJuridicaService {
    private final Repositorio<String, ClientePessoaJuridica> clienteRepository;

    public PessoaJuridicaService(Repositorio<String,ClientePessoaJuridica> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private void validarNome(String nomeCliente) {
        if(nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw new ModeloException("O nome não pode ser vazio.");
        }
    }

    private void validarCnpj(String cnpjCliente) {
        if (cnpjCliente == null || cnpjCliente.trim().isEmpty()){
            throw new ModeloException("O CPF não pode ficar vazio.");
        }
        if (!cnpjCliente.matches("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")) {
            throw new ModeloException("Informe o CNPJ conforme o exemplo a seguir.\nEx.:12.345.678/0001-00");
        }
    }

    public String salvarCliente(ClientePessoaJuridica clientePessoaJuridica) throws ServicoException {
        try {
            validarNome(clientePessoaJuridica.getNomeCliente());
            validarCnpj(clientePessoaJuridica.getCnpj());
            clienteRepository.salvar(clientePessoaJuridica);
            return "Cliente salvo com sucesso";
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
    }

    public String atualizarCliente(String idCliente, ClientePessoaJuridica clientePessoaJuridica) {
        try {
            validarNome(clientePessoaJuridica.getNomeCliente());
            validarCnpj(clientePessoaJuridica.getCnpj());
            clienteRepository.atualizar(idCliente, clientePessoaJuridica);
            return "Cliente atualizado com sucesso";
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        }
    }

    public ClientePessoaJuridica buscarClientePorId(String idCliente) throws ServicoException {
        try {
            return clienteRepository.buscarPorId(idCliente);
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(),e);
        }
    }

    public List<ClientePessoaJuridica> listarTodos() {
        return clienteRepository.listarTodos();
    }
}
