package implementacionDinamica;

public class NodoConjuntoClave {
	int clave;
	Conjunto valores;
	NodoConjuntoClave sig;
	
	NodoConjuntoClave(int clave, int valor) {
		this.clave = clave;
		this.valores = new Conjunto();
		this.valores.inicializarConjunto();
		this.valores.agregar(valor);
	}
	
	public void print() {
		System.out.print("key: ");
		System.out.print(this.clave);
		System.out.print("; valores: ");
		this.valores.print();
	}
}
