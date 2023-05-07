package practicaParcial1;
import tdas.ColaPrioridadTDA;
import implementacionDinamica.NodoPrioridad;


public class ejemplo2 {
	
	/*
	 * Modificar la implementacion de Cola con prioridad, agregando el metodo interno sumarPrioridades().
	 * El mismo debe devolver la suma de todas las prioridades que esten en la cola. Se pide entregar el 
	 * nuevo metodo y nuevas variables si existiesen, y cualquier otro metodo que se vea modificado.
	 */
	
	public static void main(String[] args) {
		ColaPrioridad cola = new ColaPrioridad();
	    cola.inicializarCola();
	    cola.acolarPrioridad(2, 5);
	    cola.acolarPrioridad(4, 2);
	    cola.acolarPrioridad(6, 8);
	    
	    System.out.print("Suma de prioridades: ");
	    System.out.println(cola.sumarPrioridades());
	}
}

class ColaPrioridad implements ColaPrioridadTDA {
	NodoPrioridad origen;
	
	public int sumarPrioridades() {
		int result = 0;
		NodoPrioridad actualNodo = this.origen;
		while (actualNodo != null) {
			result += actualNodo.getPrioridad();
			actualNodo = actualNodo.getSiguiente();
		}
		return result;
	}
	
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
