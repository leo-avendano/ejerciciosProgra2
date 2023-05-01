package implementacion;

import tdas.ColaTDA;

public class Cola implements ColaTDA {
	int indiceAcolar;
	int indiceDesacolar;
	int[] cola;
	public void inicializarCola() {
		cola = new int[10];
		indiceAcolar = 0;
		indiceDesacolar = 0;
	}
	public void acolar(int x) {
		cola[indiceAcolar] = x;
		if (indiceAcolar == cola.length - 1) {
			indiceAcolar = 0;
		} else {			
			indiceAcolar++;
		}
	}
	public void desacolar() {
		if (indiceDesacolar == cola.length - 1) {
			indiceDesacolar = 0;
		} else {			
			indiceDesacolar++;
		}
	}
	public int primero() {
		return cola[indiceDesacolar];
	}
	public boolean colaVacia() {
		return indiceAcolar == indiceDesacolar;
	}
}
