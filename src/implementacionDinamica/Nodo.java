package implementacionDinamica;

public class Nodo {
	private Nodo siguiente;
	private int info;
	
	public Nodo(int x) {
		this.siguiente = null;
		this.info = x;
	}
	
	public int getInfo() {
		return this.info;
	}
	
	public void setInfo(int x) {
		this.info = x;
	}
	
	public Nodo getSiguiente() {
		return this.siguiente;
	}
	
	public void anexar(Nodo n) {
		this.siguiente = n;
	}
}
