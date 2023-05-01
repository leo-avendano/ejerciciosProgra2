package usoTP1;
import implementacion.Cola;
import tdas.ColaTDA;

public class EJ4_a_PasarCola {
	private static ColaTDA pasarCola(ColaTDA origen) {
		ColaTDA resultado = new Cola();
		resultado.inicializarCola();
		while (!origen.colaVacia()) {
			resultado.acolar(origen.primero());
			origen.desacolar();
		}
		return resultado;
	}
	public static void main(String[] args) {
		ColaTDA miPrimerCola = new Cola();
		miPrimerCola.inicializarCola();
		miPrimerCola.acolar(1);
		miPrimerCola.acolar(2);
		miPrimerCola.acolar(3);
		miPrimerCola.acolar(5);
		miPrimerCola.acolar(6);
		
		
		ColaTDA segundaCola = pasarCola(miPrimerCola);

		// Esto deberia imprimir 1,2,3,5,6
		while (!segundaCola.colaVacia()) {
			System.out.println(segundaCola.primero());
			segundaCola.desacolar();
		}
	}
}
