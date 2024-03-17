package service;

import model.cliente.ClientePessoaFisica;
import repository.exceptions.RepositorioException;
import repository.interfaces.Repositorio;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.util.List;

public class PessoaFisicaService {
    private final Repositorio<String, ClientePessoaFisica> clienteRepository;

    public PessoaFisicaService(Repositorio<String,ClientePessoaFisica> clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    private void validarNome(String nomeCliente) {
        if(nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw new ModeloException("O nome não pode ser vazio.");
        }
    }

    private void validarCpf(String cpfCliente) {
        if (cpfCliente == null || cpfCliente.trim().isEmpty()){
            throw new ModeloException("O CPF não pode ficar vazio.");
        }
        if (!cpfCliente.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")) {
            throw new ModeloException("Informe o CPF conforme o exemplo a seguir.\nEx.:123.456.789-12");
        }
    }
    public String salvarCliente(ClientePessoaFisica clientePessoaFisica) throws ServicoException {
        try {
            validarNome(clientePessoaFisica.getNomeCliente());
            validarCpf(clientePessoaFisica.getCpf());
            clienteRepository.salvar(clientePessoaFisica);
            return "Cliente salvo com sucesso";
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
    }

    public String atualizarCliente(String idCliente, ClientePessoaFisica clientePessoaFisica) {
        try {
            validarNome(clientePessoaFisica.getNomeCliente());
            validarCpf(clientePessoaFisica.getCpf());
            clienteRepository.atualizar(idCliente, clientePessoaFisica);
            return "Cliente atualizado com sucesso!";
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        }
    }

    public ClientePessoaFisica buscarClientePorId(String idCliente) throws ServicoException {
        try {
            validarCpf(idCliente);
            return clienteRepository.buscarPorId(idCliente);
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
    }

    public List<ClientePessoaFisica> listarTodos() {
        return clienteRepository.listarTodos();
    }
}
