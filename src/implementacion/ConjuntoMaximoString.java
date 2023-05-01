package implementacion;

import java.util.Random;
import tdas.ConjuntoTDA;

public class ConjuntoMaximoString implements ConjuntoTDA<String> {
	
	String[] valores;
	int indice;
	int tamaño;
	
	public ConjuntoMaximoString(int tamaño) {
		this.tamaño = tamaño;
	}
	
	public void inicializarConjunto() {
		this.valores = new String[this.tamaño];
		this.indice = 0;
	}

	public void agregar(String x) {
		if (this.buscarValor(x) == -1) {
			this.valores[indice] = x;
		}
	}

	public void sacar(String x) {
		int indiceSacar = this.buscarValor(x);
		if (indiceSacar > -1) {
			this.valores[indiceSacar] = this.valores[indice - 1];
			indice--;
		}
	}

	public String elegir() {
		Random random = new Random();
		int x = random.nextInt(this.indice);
		return this.valores[x];
	}

	public boolean pertenece(String x) {
		boolean pertenece = false;
		int indiceBuscado = buscarValor(x);
		if (indiceBuscado > -1) 
			pertenece = true;
		return pertenece;
	}

	public boolean conjuntoVacio() {
		return indice == 0;
	}
	
	private int buscarValor(String valor) {
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
