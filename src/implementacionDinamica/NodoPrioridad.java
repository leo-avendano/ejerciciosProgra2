package implementacionDinamica;

public class NodoPrioridad {
	private NodoPrioridad siguiente;
	private int info;
	private int prioridad;

	
	public NodoPrioridad(int x, int p) {
		this.siguiente = null;
		this.info = x;
		this.prioridad = p;
	}
	
	public void setPrioridad(int p) {
		this.prioridad = p;
	}
	
	public int getPrioridad() {
		return this.prioridad;
	}
	
	public int getInfo() {
		return this.info;
	}
	
	public void setInfo(int x) {
		this.info = x;
	}
	
	public NodoPrioridad getSiguiente() {
		return this.siguiente;
	}
	
	public void anexar(NodoPrioridad n) {
		this.siguiente = n;
	}
}
