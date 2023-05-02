package implementacionDinamica;

import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	NodoConjuntoClave origen;

	public void inicializarDiccionario() {
		this.origen = null;
	}

	public void agregar(int clave, int valor) {
	}

	public void eliminar(int clave) {
	}

	public ConjuntoTDA<Integer> recuperar(int clave) {
		ConjuntoTDA<Integer> result = null;
		NodoConjuntoClave actual = this.origen;
		if (actual != null) {			
			while (actual.sig != null && result == null) {
				if (actual.clave == clave) result = actual.valores;
				actual = actual.sig;
			}
		}
		return result;
	}

	public ConjuntoTDA<Integer> claves() {
		Conjunto claves = new Conjunto();
		NodoConjuntoClave actual = this.origen;
		while (actual.sig != null) {
			claves.agregar(actual.clave);
			actual = actual.sig;
		}
		return claves;
	}
}
