package implementacionDinamica;

import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	NodoConjuntoClave origen;

	public void inicializarDiccionario() {
		this.origen = null;
	}

	public void agregar(int clave, int valor) {
		boolean existeClave = false;
		NodoConjuntoClave actual = this.origen;
		if (actual != null) {		
			while (actual.sig != null && existeClave == false) {
				if (actual.clave == clave) {
					actual.valores.agregar(valor);
					existeClave = true;
				}
				actual = actual.sig;
			}
		}
		if (this.origen == null || existeClave == false) {
			NodoConjuntoClave nuevoNodo = new NodoConjuntoClave(clave, valor);
			nuevoNodo.sig = this.origen;
			this.origen = nuevoNodo;
		}
	}

	public void eliminar(int clave) {
		boolean eliminado = false;
		NodoConjuntoClave anterior = null;
		NodoConjuntoClave actual = this.origen;
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

	public void eliminarValor(int clave, int valor) {
		boolean eliminado = false;
		NodoConjuntoClave actual = this.origen;
		if (actual != null) {		
			while (actual.sig != null && eliminado == false) {
				if (actual.clave == clave) {
					actual.valores.sacar(valor);
					eliminado = true;
				}
				actual = actual.sig;
			}
		} 
	}
	
	public void print() {
		NodoConjuntoClave actual = this.origen;
		if (actual != null) {
			System.out.println("{");
			while (actual != null) {
				System.out.print("\t");
				actual.print();
				actual = actual.sig;
			}
			System.out.println("}");
		} else {
			System.out.println("{}");
		}
	}
}
