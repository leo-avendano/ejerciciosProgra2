package implementacionDinamica;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	NodoValorClave origen;

	public void inicializarDiccionario() {
		this.origen = null;
	}

	public void agregar(int clave, int valor) {
		boolean existeClave = false;
		NodoValorClave actual = this.origen;
		if (actual != null) {			
			while (actual.sig != null && existeClave == false) {
				if (actual.clave == clave) {
					actual.valor = valor;
					existeClave = true;
				}
				actual = actual.sig;
			}
		} 
		if (actual == null || !existeClave) {
			NodoValorClave origenViejo = this.origen;
			this.origen = new NodoValorClave(clave, valor);
			this.origen.sig = origenViejo;
		}
	}

	public void eliminar(int clave) {
		boolean eliminado = false;
		NodoValorClave anterior = null;
		NodoValorClave actual = this.origen;
		if (actual != null) {		
			while (actual.sig != null && eliminado == false) {
				if (actual.clave == clave) {
					if (anterior != null) {
						anterior.sig = actual.sig;
					} else {
						this.origen = null;
					}
					eliminado = true;
				}
				anterior = actual;
				actual = actual.sig;
			}
		} 
	}

	public int recuperar(int clave) {
		Integer result = null;
		NodoValorClave actual = this.origen;
		if (actual != null) {			
			while (actual.sig != null && result == null) {
				if (actual.clave == clave) result = actual.valor;
				actual = actual.sig;
			}
		}
		return result;
	}

	public ConjuntoTDA<Integer> claves() {
		Conjunto claves = new Conjunto();
		NodoValorClave actual = this.origen;
		while (actual.sig != null) {
			claves.agregar(actual.clave);
			actual = actual.sig;
		}
		return claves;
	}
}
