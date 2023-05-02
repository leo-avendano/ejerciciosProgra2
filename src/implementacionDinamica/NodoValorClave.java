package implementacionDinamica;

public class NodoValorClave {
	int clave;
	int valor;
	NodoValorClave sig;
	
	NodoValorClave(int clave, int valor) {
		this.clave = clave;
		this.valor = valor;
	}
}
