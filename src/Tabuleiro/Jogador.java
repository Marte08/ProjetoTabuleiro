package Tabuleiro;

public class Jogador {
	private int casaAtual;
    private int meuNumero;

    public Jogador(int numero) {
        this.meuNumero = numero;
        this.casaAtual = 0;
    }

    public void jogar(int valorDado, int numeroCasasTabuleiro) {
        casaAtual += valorDado;
        if (casaAtual > numeroCasasTabuleiro) {
            casaAtual = numeroCasasTabuleiro;
        }
        System.out.println("Jogador " + meuNumero + " rolou " + valorDado + " e agora está na casa " + casaAtual);
    }

    public int getCasaAtual() {
        return casaAtual;
    }

    public int getMeuNumero() {
        return meuNumero;
    }
    public void resetarPosicao() {
    	casaAtual = 0;
    }
}
