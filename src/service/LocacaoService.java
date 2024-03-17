package service;

import model.cliente.Cliente;
import model.exceptions.VeiculoNaoEncontradoException;
import model.locacao.Locacao;
import model.veiculo.Veiculo;
import repository.interfaces.RepositorioDeleta;
import service.exceptions.ModeloException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocacaoService {
    private final RepositorioDeleta<String,Locacao> locacaoRepository;

    public LocacaoService(RepositorioDeleta<String,Locacao> locacaoRepository) {
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
        if (localDevolucao == null || localDevolucao.trim().isEmpty()){
            throw new ModeloException("Campo local de devolução não pode ser nulo.");
        }
    }

    private String locarVeiculo(Locacao locacao, Veiculo veiculo){
        veiculo.setEstaDisponivel(false);
        locacao.getVeiculos().add(veiculo);
        return "Locação realizada com sucesso!";
    }

    private String devolverVeiculo(Locacao locacao, Veiculo veiculo) {
        if (!locacao.getVeiculos().contains(veiculo)) {
            throw new VeiculoNaoEncontradoException("Veículos não está registrado neste contrato de locação.");
        }
        Long dias = calcularDiarias(locacao);

        BigDecimal valorAluguel = BigDecimal.valueOf(veiculo.getValorDiaria().doubleValue() * dias);
        BigDecimal descontoPercentual = locacao.getDesconto().divide(new BigDecimal("100.00"), RoundingMode.HALF_UP);
        if(dias >= 5) {
            valorAluguel = valorAluguel.multiply(descontoPercentual);
        }
        veiculo.setEstaDisponivel(true);
        return "Veículo devolvido com sucesso\n" +
                "Total a pagar: R$" + valorAluguel;
    }

    private Long calcularDiarias(Locacao locacao){
        Long diasTranscorridos = ChronoUnit.DAYS.between(locacao.getDataReserva(), locacao.getDataDevolucaoPrevista());
        Long horasTranscorridas = ChronoUnit.HOURS.between(locacao.getDataReserva(), locacao.getDataDevolucaoPrevista());

        if (horasTranscorridas % 24 != 0){
            diasTranscorridos++;
        }

        return diasTranscorridos;
    }


    public String salvarLocacao(Locacao locacao) {
        return null;
    }

    public Locacao buscarLocacaoPorId(String idLocacao) {
        return null;
    }

    public String atualizarLocacao(Locacao locacao, String idLocacao) {
        return null;
    }

    public String deletarLocacao(String idLocacao) {
        return null;
    }
}
