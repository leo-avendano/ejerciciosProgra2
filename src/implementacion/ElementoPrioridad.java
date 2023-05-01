package implementacion;

import tdas.ElementoPrioridadTDA;

public class ElementoPrioridad implements ElementoPrioridadTDA {
	private int prioridad;
	private int dato;
	
	public ElementoPrioridad(int dato, int prioridad) {
		this.prioridad = prioridad;
		this.dato = dato;
	}
	
	public int getPrioridad() {
		return this.prioridad;
	}
	
	public void setPrioridad(int nuevaPrioridad) {
		this.prioridad = nuevaPrioridad;
	}
	
	public int getDato() {
		return this.dato;
	}
	
	public void setDato(int nuevoDato) {
		this.dato = nuevoDato;
	}
}
