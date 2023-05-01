package usoTP2;

import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;

public class TP2_EJClase_0411_ValoresDictSimpleAPila {

	public static void valoresDictSimpleAPila(DiccionarioSimpleTDA dict, PilaTDA pila) {
		ConjuntoTDA claves = dict.claves();
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			claves.sacar(clave);
			pila.apilar(dict.recuperar(clave));
		}
	}
}
