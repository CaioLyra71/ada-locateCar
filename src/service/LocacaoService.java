package service;

import model.cliente.Cliente;
import model.locacao.Locacao;
import model.veiculo.Veiculo;
import repository.exceptions.RepositorioException;
import repository.interfaces.RepositorioDeleta;
import service.exceptions.ModeloException;
import service.exceptions.ServicoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class LocacaoService {
    private final RepositorioDeleta<Cliente, Locacao> locacaoRepository;

    public LocacaoService(RepositorioDeleta<Cliente, Locacao> locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    private void validarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new ModeloException("O cliente não pode ser um campo nulo.");
        }
    }

    private void validarVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            throw new ModeloException("O veículo não pode ser um campo nulo.");
        }
    }

    private void validarDataReserva(LocalDateTime dataReserva) {
        if (dataReserva == null) {
            throw new ModeloException("Campo data da reserva não pode ser nulo");
        }
    }

    private void validarDataDevolucao(LocalDateTime dataDevolucao) {
        if (dataDevolucao == null) {
            throw new ModeloException("Campo data de devolução prevista não pode ser nulo.");
        }
    }

    private void validarLocalDevolucao(String localDevolucao) {
        if (localDevolucao == null || localDevolucao.trim().isEmpty()) {
            throw new ModeloException("Campo local de devolução não pode ser nulo.");
        }
    }

    public String devolverVeiculo(Locacao locacao, LocalDateTime dataEntega) {
        Long dias = calcularDiarias(locacao, dataEntega);
        BigDecimal valorAluguel = locacao
                .getVeiculo()
                .getValorDiaria()
                .multiply(new BigDecimal(dias));
        BigDecimal descontoPercentual = locacao
                .getDesconto()
                .divide(new BigDecimal("100.00"), RoundingMode.HALF_UP);
        if(dias >= 5) {
            valorAluguel = valorAluguel.multiply(descontoPercentual);
        }
        locacao.getVeiculo().setEstaDisponivel(true);
        deletarLocacao(locacao.getCliente());
        return "Veículo devolvido com sucesso\n" +
                "Total a pagar: R$" + valorAluguel;
    }

    private Long calcularDiarias(Locacao locacao, LocalDateTime dataDevolucao) {
        Long diasTranscorridos = ChronoUnit.DAYS.between(locacao.getDataReserva(), dataDevolucao);
        Long horasTranscorridas = ChronoUnit.HOURS.between(locacao.getDataReserva(), dataDevolucao);

        if (horasTranscorridas % 24 != 0) {
            diasTranscorridos++;
        }

        return diasTranscorridos;
    }


    public String salvarLocacao(Locacao locacao) {
        try {
            validarCliente(locacao.getCliente());
            validarVeiculo(locacao.getVeiculo());
            validarLocalDevolucao(locacao.getLocalDevolucao());
            validarDataReserva(locacao.getDataReserva());
            validarDataDevolucao(locacao.getDataDevolucaoPrevista());
            locacaoRepository.salvar(locacao);
            return "Locação realizada com sucesso";
        } catch (ModeloException e) {
            throw new ModeloException(e.getMessage());
        } catch (RepositorioException e) {
            throw new RuntimeException(e);
        }
    }

    public Locacao buscarLocacaoPorId(Cliente idLocacao) throws ServicoException {
        try {
            return locacaoRepository.buscarPorId(idLocacao);
        } catch (RepositorioException e) {
            throw new ServicoException(e.getMessage(), e);
        }
    }

    public String atualizarLocacao(Locacao locacao, String idLocacao) {
        return null;
    }

    private Locacao deletarLocacao(Cliente idLocacao) {
        return locacaoRepository.deletar(idLocacao);
    }

    public List<Locacao> listarTodos() {
        return locacaoRepository.listarTodos();
    }
}
