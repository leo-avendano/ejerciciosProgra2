package tdas;

public interface ConjuntoTDA<T> {
	void inicializarConjunto();
	void agregar(T x); //conjunto inicializado
	void sacar(T x); //conjunto inicializado
	T elegir(); //conjunto inicializado y no vacio
	boolean pertenece(T x); //conjunto inicializado
	boolean conjuntoVacio(); //conjunto inicializado
}
