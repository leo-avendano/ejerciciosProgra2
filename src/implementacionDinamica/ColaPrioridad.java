package implementacionDinamica;

import tdas.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	NodoPrioridad origen;
	
	public void inicializarCola() {
		this.origen = null;
	}

	public void acolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevoNodo = new NodoPrioridad(x, prioridad);
		NodoPrioridad actualNodo = this.origen;
		if (actualNodo != null) {
			boolean nodoInsertado = false;
			while (actualNodo.getSiguiente() != null && !nodoInsertado) {
				int actualPrioridad = actualNodo.getPrioridad();
				int siguientePrioridad = actualNodo.getSiguiente().getPrioridad();
				if (actualPrioridad >= prioridad && siguientePrioridad < prioridad) {
					NodoPrioridad siguienteNodo = actualNodo.getSiguiente();
					nuevoNodo.anexar(siguienteNodo);
					actualNodo.anexar(nuevoNodo);
					nodoInsertado = true;
				}
				actualNodo = actualNodo.getSiguiente();
			}
			
			if (actualNodo.getSiguiente() == null && !nodoInsertado) {
				actualNodo.anexar(nuevoNodo);
			}
		} else {
			this.origen = nuevoNodo;
		}
	}

	public void desacolar() {
		this.origen = this.origen.getSiguiente();
	}

	public int primero() {
		return this.origen.getInfo();
	}

	public int prioridad() {
		return this.origen.getPrioridad();
	}

	public boolean colaVacia() {
		return this.origen == null;
	}

	public void print() {
		NodoPrioridad actual = this.origen;
		if (actual != null) {
			System.out.println("[");
			while (actual != null) {
				System.out.print("\t");
				actual.print();
				actual = actual.getSiguiente();
			}
			System.out.println("]");
		} else {
			System.out.println("[]");
		}
	}
}
