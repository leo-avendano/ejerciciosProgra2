package implementacionDinamica;

import java.util.ArrayList;

import tdas.PilaTDA;

public class Pila implements PilaTDA {
	Nodo tope;

	public void inicializarPila() {
		this.tope = null;
	}

	public void apilar(int x) {
		Nodo nuevoNodo = new Nodo(x);
		Nodo topeAnterior = this.tope;
		this.tope = nuevoNodo;
		if (topeAnterior != null) {
			this.tope.anexar(topeAnterior);
		}
	}

	public void desapilar() {
		this.tope = this.tope.getSiguiente();
	}

	public int tope() {
		return this.tope.getInfo();
	}

	public boolean pilaVacia() {
		return this.tope == null;
	}
	
	public void print() {
		Nodo actual = this.tope;
		if (actual != null) {
			ArrayList<Integer> valores = new ArrayList<Integer>();
			while (actual != null) {
				valores.add(actual.getInfo());
				actual = actual.getSiguiente();
			}
			System.out.println(valores.toString());
		} else {
			System.out.println("[]");
		}
	}
}
