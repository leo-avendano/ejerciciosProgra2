package implementacion;

import java.util.Random;

import tdas.ConjuntoTDA;

public class ConjuntoValorAcotado implements ConjuntoTDA {
	
	int[] valores;
	int indice;
	int maxValor;
	
	public ConjuntoValorAcotado(int maxValor) {
		this.maxValor = maxValor;
	}

	public void inicializarConjunto() {
		this.valores = new int[10];
		this.indice = 0;
	}

	public void agregar(int x) {
		if (this.buscarValor(x) == -1 && this.maxValor >= x && x >= 0) {
			this.valores[indice] = x;
		}
	}

	public void sacar(int x) {
		int indiceSacar = this.buscarValor(x);
		if (indiceSacar > -1) {
			this.valores[indiceSacar] = this.valores[indice - 1];
			indice--;
		}
	}

	public int elegir() {
		Random random = new Random();
		int x = random.nextInt(this.indice);
		return this.valores[x];
	}

	public boolean pertenece(int x) {
		boolean pertenece = false;
		int indiceBuscado = buscarValor(x);
		if (indiceBuscado > -1) 
			pertenece = true;
		return pertenece;
	}

	public boolean conjuntoVacio() {
		return indice == 0;
	}
	
	private int buscarValor(int valor) {
		boolean existe = false;
		int i = 0;
		while (i < indice && !existe) {
			if (this.valores[i] == valor)
				existe = true;
			i++;
		}
		
		if (!existe) {
			i = -1;
		}
		return i;		
	}

}
