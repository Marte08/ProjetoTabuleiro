package Tabuleiro;

import java.util.Random;

public class Dado {
	
    private int numeroAtual;

	public int rolar() {
	    Random rand = new Random();
	    numeroAtual = rand.nextInt(6) + 1;
	    return numeroAtual;
	}
	
	public int getNumero() {
		return numeroAtual;
	}
}

	
