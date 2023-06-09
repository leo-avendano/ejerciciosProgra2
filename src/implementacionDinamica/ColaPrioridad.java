package implementacionDinamica;

import tdas.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	NodoPrioridad origen;
	
	public void inicializarCola() {
		this.origen = null;
	}

	public void acolarPrioridad(int x, int prioridad) {
		NodoPrioridad nuevoNodo = new NodoPrioridad(x, prioridad);
	    if (this.origen != null && this.origen.getPrioridad() > prioridad) {
	        boolean nodoInsertado = false;
	        NodoPrioridad actualNodo = this.origen;
	        NodoPrioridad sigNodo = actualNodo.getSiguiente();
	        
	        while (sigNodo!= null && !nodoInsertado) {
	            int sigPrioridad = sigNodo.getPrioridad();
	            if (prioridad > sigPrioridad) {
	            	nuevoNodo.anexar(sigNodo);
	            	actualNodo.anexar(nuevoNodo);
	            	nodoInsertado = true;
	            }
	            actualNodo = sigNodo;
	            sigNodo = actualNodo.getSiguiente();
	        }
	        if (!nodoInsertado) {
	        	actualNodo.anexar(nuevoNodo);
	        }
	    } else {
	    	nuevoNodo.anexar(this.origen);
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
