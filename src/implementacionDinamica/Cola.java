package implementacionDinamica;

import java.util.ArrayList;

import tdas.ColaTDA;

public class Cola implements ColaTDA {
	Nodo origen;
	Nodo ultimo;
	
	public void inicializarCola() {
		this.origen = null;
		this.ultimo = null;
	}

	public void acolar(int x) {
		Nodo nuevoNodo = new Nodo(x);
		if (this.origen == null) {
			this.origen = nuevoNodo;
			this.ultimo = this.origen;
		} else {
			this.ultimo.anexar(nuevoNodo);
			this.ultimo = nuevoNodo;
		}
	}

	public void desacolar() {
		this.origen = this.origen.getSiguiente();
		if (this.origen == null) {
			this.ultimo = null;
		}
	}

	public int primero() {
		return this.origen.getInfo();
	}

	public boolean colaVacia() {
		return this.origen == null;
	}
	
	public void print() {
		Nodo actual = this.origen;
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
