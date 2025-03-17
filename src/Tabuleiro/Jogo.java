package Tabuleiro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Jogo {
    private Tabuleiro meuTabuleiro;
    private List<Jogador> meusJogadores;
    private Dado meuDado;

    public Jogo(int numeroCasas, int quantidadeJogadores) {
        meuTabuleiro = new Tabuleiro(numeroCasas);
        meusJogadores = new ArrayList<>();
        meuDado = new Dado();

        for (int i = 1; i <= quantidadeJogadores; i++) {
            meusJogadores.add(new Jogador(i));
        }
    }

    public void iniciar() {
      
        String[] opcoesMenu = {
            "Iniciar nova partida",
            "Executar jogada",
            "Informar posições",
            "Sair"
        };

        boolean continuar = true;
        while (continuar) {
            int opcaoSelecionada = JOptionPane.showOptionDialog(
                null,
                "Selecione uma opção:",
                "Menu do Jogo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoesMenu,
                opcoesMenu[0]
            );

            if (opcaoSelecionada == JOptionPane.CLOSED_OPTION || opcaoSelecionada == 3) {
                // 
                continuar = false;
                JOptionPane.showMessageDialog(null, "Jogo encerrado.");
            } else {
                switch (opcaoSelecionada) {
                    case 0: 
                        novaPartida();
                        break;
                    case 1: 
                        executarJogada();
                        break;
                    case 2: 
                        informarPosicoes();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        break;
                }
            }
        }
    }

  
    private void novaPartida() {
        for (Jogador jogador : meusJogadores) {
            jogador.resetarPosicao();
        }
        JOptionPane.showMessageDialog(null, "Nova partida iniciada! As posições foram zeradas.");
    }

    private void executarJogada() {
        StringBuilder sb = new StringBuilder();
        for (Jogador jogador : meusJogadores) {
            int valorDado = meuDado.rolar();
            jogador.jogar(valorDado, meuTabuleiro.getNumeroCasas());
            sb.append("Jogador ")
              .append(jogador.getMeuNumero())
              .append(" rolou ")
              .append(valorDado)
              .append(" e foi para a casa ")
              .append(jogador.getCasaAtual())
              .append("\n");
        }
    }

    private void informarPosicoes() {
        StringBuilder sb = new StringBuilder();
        for (Jogador jogador : meusJogadores) {
            sb.append("Jogador ")
              .append(jogador.getMeuNumero())
              .append(" está na casa ")
              .append(jogador.getCasaAtual())
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Posições dos Jogadores", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
   
        Jogo jogo = new Jogo(20, 2);
        jogo.iniciar();
    }
}