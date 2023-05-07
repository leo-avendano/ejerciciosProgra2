package practicaParcial1;

import implementacionDinamica.DiccionarioMultiple;
import implementacionDinamica.Pila;
import implementacionDinamica.ColaPrioridad;
import implementacionDinamica.Conjunto;

public class ejemplo1 {
	/*
	 * Realizar el metodo externo clavesOrdenadas que muestre en forma ordenada las claves
	 * de un diccionario multiple que recibe por parametro
	 */

	public static void main(String[] args) {
		DiccionarioMultiple dm = new DiccionarioMultiple();
	    dm.inicializarDiccionario();
	    dm.agregar(10, 100);
	    dm.agregar(40, 400);
	    dm.agregar(30, 300);
	    dm.agregar(20, 200);
	    dm.agregar(50, 500);
	    
	    int[] clavesOrdenadas = clavesOrdenadas(dm);
	    
	    // Debería imprimir "10 20 30 40 50"
	    for (int i = 0; i < clavesOrdenadas.length; i++) {
	        System.out.print(clavesOrdenadas[i] + " ");
	    }
	}
	
	public static int[] clavesOrdenadas(DiccionarioMultiple dm) {
		Conjunto claves = dm.claves();
		Pila clavesMenorAMayor = new Pila();
		clavesMenorAMayor.inicializarPila();
		ColaPrioridad clavesMayorAMenor = new ColaPrioridad();
		clavesMayorAMenor.inicializarCola();
		int length = 0;
		
		while (!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			claves.sacar(clave);
			clavesMayorAMenor.acolarPrioridad(clave, clave);
			length++;
		}
		
		clavesMayorAMenor.print();
		
		int[] res = new int[length];
		
		while (!clavesMayorAMenor.colaVacia()) {
			int clave = clavesMayorAMenor.primero();
			clavesMayorAMenor.desacolar();
			clavesMenorAMayor.apilar(clave);
		}
		
		for (int i = 0; i < length; i++) {
			res[i] = clavesMenorAMayor.tope();
			clavesMenorAMayor.desapilar();
		}
		
		return res;
	}
}
