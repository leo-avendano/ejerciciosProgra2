package implementacion;

import tdas.ConjuntoTDA;

public class ElementoKeyConjunto {
	int key;
	public ConjuntoTDA<Integer> valores;
	int tamaño = 10;
	
	public ElementoKeyConjunto() {
		this.valores = new ConjuntoMaximo(tamaño);
		this.valores.inicializarConjunto();
	}
	
	public int getKey() {
		return this.key;
	}
	
	public void setKey(int k) {
		this.key = k;
	}
}
