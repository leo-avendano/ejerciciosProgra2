package implementacion;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	ElementoKeyValue[] valores;
	int indice;
	int tamaño = 10;
	
	public void inicializarDiccionario() {
		this.valores = new ElementoKeyValue[tamaño];
		this.indice = 0;
	}

	public void agregar(int clave, int valor) {
		int i = this.clave2Indice(clave);
		if (i != -1) {
			this.valores[i].setValue(valor);
		} else {
			this.valores[indice].setValue(valor);
			this.valores[indice].setKey(clave);
			this.indice++;
		}
	}

	public void eliminar(int clave) {
		int i = this.clave2Indice(clave);
		if (i != -1) {
			this.valores[i] = this.valores[indice - 1];
			this.indice--;
		}
	}

	public int recuperar(int clave) {
		int i = this.clave2Indice(clave);
		return this.valores[i].getValue();
	}

	public ConjuntoTDA<Integer> claves() {
		ConjuntoTDA<Integer> claves = new ConjuntoMaximo(tamaño);
		claves.inicializarConjunto();
		for (int i = 0; i < indice; i++) {
			claves.agregar(this.valores[i].getKey());
		}
		return claves;
	}
	
	private int clave2Indice(int clave) {
		int i = 0;
		boolean claveExiste = false;
		while (i < indice && !claveExiste) {
			if (this.valores[i].getKey() == clave) {
				claveExiste = true;
			}
			i++;
		}
		if (!claveExiste) i = -1;
		return i;
	}

}
