package implementacionDinamica;

import tdas.ConjuntoTDA;

public class NodoConjuntoClave {
	int clave;
	ConjuntoTDA<Integer> valores;
	NodoConjuntoClave sig;
	
	NodoConjuntoClave(int clave, int valor) {
		this.clave = clave;
		this.valores.agregar(valor);
	}
}
