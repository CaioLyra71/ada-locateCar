package view.locacao.cadastro;

import infra.BancoDadosLocacao;
import infra.BancoDadosPessoaFisica;
import infra.BancoDadosVeiculo;
import repository.ClienteRepository;
import repository.LocacaoRepository;
import repository.VeiculoRepository;
import service.LocacaoService;
import service.PessoaFisicaService;
import service.VeiculoService;
import view.components.menu.ItemMenu;
import view.components.menu.MenuAbstrato;

import java.util.Scanner;

public class MenuLocacaoCadastro extends MenuAbstrato {
    public MenuLocacaoCadastro(Scanner scanner) {
        super(new ItemMenu[]{
                new ItemMenu(1, "Locação Pessoa Física"),
                new ItemMenu(2, "Locação Pessoa Jurídica"),
        }, scanner);
    }

    @Override
    protected void executarOpcao(Integer opcao) {
        switch (opcao) {
            case 1 -> new MenuLocacaoPessoaFisica(scanner,
                    new PessoaFisicaService(new ClienteRepository<>(new BancoDadosPessoaFisica())),
                    new VeiculoService(new VeiculoRepository(new BancoDadosVeiculo())),
                    new LocacaoService(new LocacaoRepository(new BancoDadosLocacao())))
                    .executar();
            case 2 -> System.out.println("locação pj");
            default -> System.out.println("Opção Inválida");
        }
    }
}
