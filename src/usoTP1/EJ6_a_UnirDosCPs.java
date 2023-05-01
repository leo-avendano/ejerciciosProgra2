package usoTP1;

import implementacion.ColaPrioridad;
import tdas.ColaPrioridadTDA;

public class EJ6_a_UnirDosCPs {
	/*
	 * Combinar dos colas con prioridades CP1 y CP2, generando una nueva
	 * cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
	 * son más prioritarios que los de la CP2.
	 */
	
	private static ColaPrioridadTDA unirDosCPs(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
		ColaPrioridadTDA resultado = new ColaPrioridad();
		resultado.inicializarCola();
		enum estados {
			AMBOS,
			CP1,
			CP2,
			FIN
		}
		
		while (!cp1.colaVacia() || !cp2.colaVacia()) {
			
			estados estado = estados.FIN;
			if (!cp1.colaVacia() && !cp2.colaVacia()) estado = estados.AMBOS;
			else if (!cp1.colaVacia()) estado = estados.CP1;
			else if (!cp2.colaVacia()) estado = estados.CP2;
			
			switch (estado) {
				case AMBOS:
					if (cp1.prioridad() < cp2.prioridad()) {
						resultado.acolarPrioridad(cp1.primero(), cp1.prioridad());
						cp1.desacolar();
					} else if (cp1.prioridad() >= cp2.prioridad()) {
						resultado.acolarPrioridad(cp2.primero(), cp2.prioridad());
						cp2.desacolar();
					}
					break;
				case CP1:
					resultado.acolarPrioridad(cp1.primero(), cp1.prioridad());
					cp1.desacolar();
					break;
				case CP2:
					resultado.acolarPrioridad(cp2.primero(), cp2.prioridad());
					cp2.desacolar();
					break;
				default:
					break;
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
	
		ColaPrioridadTDA cp1 = new ColaPrioridad();
		cp1.inicializarCola();
		cp1.acolarPrioridad(2, 9);
		cp1.acolarPrioridad(7, 2);
		cp1.acolarPrioridad(4, 5);
		cp1.acolarPrioridad(1, 10);
		
		ColaPrioridadTDA cp2 = new ColaPrioridad();
		cp2.inicializarCola();
		cp2.acolarPrioridad(6, 3);
		cp2.acolarPrioridad(5, 4);
		cp2.acolarPrioridad(3, 9);
		cp2.acolarPrioridad(8, 1);

		ColaPrioridadTDA res = unirDosCPs(cp1, cp2);
		
		System.out.println("Resultado");
		// Esto deberia imprimir valores 1,2,3,4,5,6,7,8
		while (!res.colaVacia()) {
			System.out.println("Valor: " + Integer.valueOf(res.primero()));
			System.out.println("Prioridad: " + Integer.valueOf(res.prioridad()));
			res.desacolar();
		}
	}
}
