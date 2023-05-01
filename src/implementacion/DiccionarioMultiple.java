package implementacion;

import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	ElementoKeyConjunto[] conjuntos;
	int indice;
	int tamaño = 10;
	
	public void inicializarDiccionario() {
		this.conjuntos = new ElementoKeyConjunto[tamaño];
		this.indice = 0;
	}

	public void agregar(int clave, int valor) {
		int i = this.clave2Indice(clave);
		if (i != -1) {
			this.conjuntos[i].valores.agregar(valor);
		} else {
			this.conjuntos[indice].setKey(clave);
			this.conjuntos[indice].valores.agregar(valor);
			this.indice++;
		}
	}

	public void eliminar(int clave) {
		int i = this.clave2Indice(clave);
		if (i != -1) {
			this.conjuntos[i] = this.conjuntos[indice - 1];
			this.indice--;
		}
	}

	public void eliminarValor(int clave, int valor) {
		int i = this.clave2Indice(clave);
		if (i != -1) {
			this.conjuntos[i].valores.sacar(valor);
			if (this.conjuntos[i].valores.conjuntoVacio()) {
				this.conjuntos[i] = this.conjuntos[indice - 1];
				this.indice--;
			}
		}
	}

	public ConjuntoTDA<Integer> recuperar(int clave) {
		int i = this.clave2Indice(clave);
		return this.conjuntos[i].valores;
	}

	public ConjuntoTDA<Integer> claves() {
		ConjuntoTDA<Integer> claves = new ConjuntoMaximo(tamaño);
		claves.inicializarConjunto();
		for (int i = 0; i < indice; i++) {
			claves.agregar(this.conjuntos[i].getKey());
		}
		return claves;
	}
	
	private int clave2Indice(int clave) {
		int i = 0;
		boolean claveExiste = false;
		while (i < indice && !claveExiste) {
			if (this.conjuntos[i].getKey() == clave) {
				claveExiste = true;
			}
			i++;
		}
		if (!claveExiste) i = -1;
		return i;
	}
}
