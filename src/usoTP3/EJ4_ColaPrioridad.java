package usoTP3;

import implementacionDinamica.ColaPrioridad;
import implementacionDinamica.DiccionarioMultiple;

public class EJ4_ColaPrioridad {
	/* 
	 * Escribir un método externo que permita generar un Diccionario Múltiple que
	 * permita, para cada valor presente en la ColaPrioridad C recuperar todas las
	 * prioridades que tiene asociadas en C.
	 */
	
	public static void main(String[] args) {
		ColaPrioridad cp = new ColaPrioridad();
	    cp.inicializarCola();
	    
	    cp.acolarPrioridad(1, 3);
	    cp.acolarPrioridad(2, 1);
	    cp.acolarPrioridad(3, 2);
	    cp.acolarPrioridad(1, 2);
	    cp.acolarPrioridad(2, 3);
	    cp.acolarPrioridad(3, 1);
	    
	    cp.print();
	    DiccionarioMultiple dicc = prioridadesPorValor(cp);
	    
	    dicc.print();
	}
	
	public static DiccionarioMultiple prioridadesPorValor(ColaPrioridad cp) {
		DiccionarioMultiple res = new DiccionarioMultiple();
		res.inicializarDiccionario();
		
		while (!cp.colaVacia()) {
			res.agregar(cp.primero(), cp.prioridad());
			cp.desacolar();
		}
		
		return res;
	}
}
