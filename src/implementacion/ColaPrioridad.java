package implementacion;

import tdas.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	int indice;
	ElementoPrioridad[] datos;
	
	public void inicializarCola() {
		this.indice = 0;
		this.datos = new ElementoPrioridad[10];
	}
	public void acolarPrioridad(int x, int prioridad) {
		ElementoPrioridad nuevoElem = new ElementoPrioridad(x, prioridad);
		boolean reordenarCola = false;
		int indiceInsertar = 0;
		// Buscar donde insertar nuevo elem
		while (indiceInsertar < this.indice && !reordenarCola) {
			ElementoPrioridad curr = this.datos[indiceInsertar];
			if (curr.getPrioridad() > prioridad) {
				reordenarCola = true;
			} else {				
				indiceInsertar++;
			}
		}
		
		if (reordenarCola) {
			// Mover todo a la derecha
			int i = indice - 1;
			while (i >= indiceInsertar) {
				this.datos[i+1] = this.datos[i];
				i--;
			}
			this.datos[indiceInsertar] = nuevoElem;
		} else {
			this.datos[indice] = nuevoElem;
		}
		indice++;
	}
	public void desacolar() {
		this.indice--;
	}
	public int primero() {
		return this.datos[indice - 1].getDato();
	}
	public int prioridad() {
		return this.datos[indice - 1].getPrioridad();
	}
	public boolean colaVacia() {
		return this.indice == 0;
	}
}
