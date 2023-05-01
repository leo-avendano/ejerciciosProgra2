package usoTP2;

import tdas.ConjuntoTDA;

public class TP2_EJClase_0404_ConjuntoPertenece {

	public boolean incluye(ConjuntoTDA<Integer> conj1, ConjuntoTDA<Integer> conj2) {
		int aux;
		boolean incluye = true;
		while (!conj2.conjuntoVacio() && incluye) {
			aux = conj2.elegir();
			if (conj1.pertenece(aux)) {
				conj2.sacar(aux);
			} else {
				incluye = false;
			}
		}
		return incluye;
	}
}
