package usoTP1;

import implementacion.ColaPrioridad;
import tdas.ColaPrioridadTDA;


public class EJ6_b_CPsonIdenticas {
	/* 
	 * Determinar si dos Colas con prioridad son idénticas.
	 */
	private static boolean sonIdenticas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
		boolean sonIdenticas = true;
		
		while (!cp1.colaVacia() && !cp2.colaVacia() && sonIdenticas) {
			if (cp1.primero() != cp2.primero() || cp1.prioridad() != cp2.prioridad()) 
				sonIdenticas = false;
			cp1.desacolar();
			cp2.desacolar();
		}
		
		if ((!cp1.colaVacia() && cp2.colaVacia()) || (cp1.colaVacia() && !cp2.colaVacia()))
			sonIdenticas = false;
		
		return sonIdenticas;
	}
	
	public static void main(String[] args) {
		
		ColaPrioridadTDA cp1 = new ColaPrioridad();
		cp1.inicializarCola();
		cp1.acolarPrioridad(1, 1);
		cp1.acolarPrioridad(2, 2);
		cp1.acolarPrioridad(3, 3);
		cp1.acolarPrioridad(4, 4);
		
		ColaPrioridadTDA cp2 = new ColaPrioridad();
		cp2.inicializarCola();
		cp2.acolarPrioridad(1, 1);
		cp2.acolarPrioridad(2, 2);
		cp2.acolarPrioridad(3, 3);
		cp2.acolarPrioridad(5, 4);

		boolean res = sonIdenticas(cp1, cp2);
		
		// Debe imprimir false - tienen valores distintos
		System.out.print("Resultado 1: ");
		System.out.println(res);
		
		ColaPrioridadTDA cp3 = new ColaPrioridad();
		cp3.inicializarCola();
		cp3.acolarPrioridad(1, 1);
		cp3.acolarPrioridad(2, 2);
		cp3.acolarPrioridad(3, 3);
		cp3.acolarPrioridad(4, 4);
		
		ColaPrioridadTDA cp4 = new ColaPrioridad();
		cp4.inicializarCola();
		cp4.acolarPrioridad(1, 1);
		cp4.acolarPrioridad(2, 2);
		cp4.acolarPrioridad(3, 3);
		cp4.acolarPrioridad(4, 5);

		res = sonIdenticas(cp3, cp4);
		
		// Debe imprimir false - tienen prioridades distintas
		System.out.print("Resultado 2: ");
		System.out.println(res);
		
		ColaPrioridadTDA cp5 = new ColaPrioridad();
		cp5.inicializarCola();
		cp5.acolarPrioridad(1, 1);
		cp5.acolarPrioridad(2, 2);
		cp5.acolarPrioridad(3, 3);
		cp5.acolarPrioridad(4, 4);
		
		ColaPrioridadTDA cp6 = new ColaPrioridad();
		cp6.inicializarCola();
		cp6.acolarPrioridad(2, 2);
		cp6.acolarPrioridad(3, 3);
		cp6.acolarPrioridad(4, 4);

		res = sonIdenticas(cp5, cp6);
		
		// Debe imprimir false - no son de la misma longitud
		System.out.print("Resultado 3: ");
		System.out.println(res);
		
		ColaPrioridadTDA cp7 = new ColaPrioridad();
		cp7.inicializarCola();
		cp7.acolarPrioridad(1, 1);
		cp7.acolarPrioridad(2, 2);
		cp7.acolarPrioridad(3, 3);
		cp7.acolarPrioridad(4, 4);
		
		ColaPrioridadTDA cp8 = new ColaPrioridad();
		cp8.inicializarCola();
		cp8.acolarPrioridad(1, 1);
		cp8.acolarPrioridad(2, 2);
		cp8.acolarPrioridad(3, 3);
		cp8.acolarPrioridad(4, 4);

		res = sonIdenticas(cp7, cp8);
		
		// Debe imprimir true - son iguales
		System.out.print("Resultado 4: ");
		System.out.println(res);
	}
}
