package usoTP2;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;
import tdas.PilaTDA;

public class TP2_EJClase_0411_ValoresDictSimpleAPila {

	public static void valoresDictSimpleAPila(DiccionarioSimpleTDA dict, PilaTDA pila) {
		ConjuntoTDA<Integer> claves = dict.claves();
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			claves.sacar(clave);
			pila.apilar(dict.recuperar(clave));
		}
	}
}
