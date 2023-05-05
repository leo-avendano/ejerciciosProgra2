package implementacionDinamica;

public class NodoConjuntoClave {
	int clave;
	Conjunto valores;
	NodoConjuntoClave sig;
	
	NodoConjuntoClave(int clave, int valor) {
		this.clave = clave;
		this.valores.agregar(valor);
	}
	
	public void print() {
		System.out.print("key: ");
		System.out.println(this.clave);
		System.out.print("valores: ");
		this.valores.print();
	}
}
