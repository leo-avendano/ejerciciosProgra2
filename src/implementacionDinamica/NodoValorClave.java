package implementacionDinamica;

public class NodoValorClave {
	int clave;
	int valor;
	NodoValorClave sig;
	
	NodoValorClave(int clave, int valor) {
		this.clave = clave;
		this.valor = valor;
	}
	
	public void print() {
		System.out.print("key: ");
		System.out.println(this.clave);
		System.out.print("valor: ");
		System.out.println(this.valor);
	}
}
