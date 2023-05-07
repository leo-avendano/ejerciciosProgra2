package usoTP3;

import implementacionDinamica.Conjunto;
import implementacionDinamica.DiccionarioMultiple;

public class EJ5_a_DiccionarioMultiple {
	
	/* Dados dos DiccionarioMultipleTDA D1 y D2, generar un DiccionarioMultipleTDA que
	 * 	contenga:
	 * a. las claves presentes en D1 y D2, con todos los elementos asociados a cada clave.
	 * b. las claves presentes en D1 y D2, con todos los elementos comunes a las claves
	 * 		coincidentes en ambos.
	 * c. las claves comunes de D1 y D2, con todos los elementos asociados a cada clave.
	 * d. las claves comunes de D1 y D2, con todos los elementos comunes a las claves
	 * 		coincidentes en ambos.
	 */

	public static void main(String[] args) {
		EJ5_a_DiccionarioMultiple.A();
		EJ5_a_DiccionarioMultiple.B();
		EJ5_a_DiccionarioMultiple.C();
		EJ5_a_DiccionarioMultiple.D();
	}
	
	public static void A() {
		// Testear union()
	}
	
	public static void B() {
		// Testear ...()
	}
	
	public static void C() {
		// Testear interseccionClave()
	}
	
	public static void D() {
		// Testear interseccionClaveValores()
	}
	
	public static DiccionarioMultiple union(DiccionarioMultiple d1, DiccionarioMultiple d2) {
		DiccionarioMultiple res = new DiccionarioMultiple();
		res.inicializarDiccionario();
		Conjunto clavesD1 = d1.claves(); 
		while (!clavesD1.conjuntoVacio()) {
			int clave = clavesD1.elegir();
			Conjunto valores = d1.recuperar(clave);
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				valores.sacar(valor);
				res.agregar(clave, valor);				
			}
			clavesD1.sacar(clave);
		}
		
		Conjunto clavesD2 = d2.claves();
		while (!clavesD2.conjuntoVacio()) {
			int clave = clavesD2.elegir();
			Conjunto valores = d2.recuperar(clave);
			while (!valores.conjuntoVacio()) {
				int valor = valores.elegir();
				valores.sacar(valor);
				res.agregar(clave, valor);				
			}
			clavesD1.sacar(clave);
		}
		return res;
	}
	
	public static DiccionarioMultiple interseccionValores(DiccionarioMultiple d1, DiccionarioMultiple d2) {
		DiccionarioMultiple res = new DiccionarioMultiple();
		res.inicializarDiccionario();
		
		
		
		return res;
	}
	
	public static DiccionarioMultiple interseccionClave(DiccionarioMultiple d1, DiccionarioMultiple d2) {
		DiccionarioMultiple res = new DiccionarioMultiple();
		res.inicializarDiccionario();
		
		Conjunto clavesD1 = d1.claves(); 
		Conjunto clavesD2 = d2.claves();
		
		Conjunto clavesComun = new Conjunto();
		clavesComun.inicializarConjunto();
		
		while (!clavesD1.conjuntoVacio()) {
			int clave = clavesD1.elegir();
			clavesD1.sacar(clave);
			if (clavesD2.pertenece(clave)) {
				clavesComun.agregar(clave);
			}
		}
		
		while (!clavesComun.conjuntoVacio()) {
			int clave = clavesComun.elegir();
			clavesComun.sacar(clave);
			Conjunto valoresD1 = d1.recuperar(clave);
			while (!valoresD1.conjuntoVacio()) {
				int valor = valoresD1.elegir();
				valoresD1.sacar(valor);
				res.agregar(clave, valor);
			}
			Conjunto valoresD2 = d2.recuperar(clave);
			while (!valoresD2.conjuntoVacio()) {
				int valor = valoresD2.elegir();
				valoresD2.sacar(valor);
				res.agregar(clave, valor);
			}
		}
		
		return res;
	}
	
	public static DiccionarioMultiple interseccionClaveValores(DiccionarioMultiple d1, DiccionarioMultiple d2) {
		DiccionarioMultiple res = new DiccionarioMultiple();
		res.inicializarDiccionario();
		
		Conjunto clavesD1 = d1.claves(); 
		Conjunto clavesD2 = d2.claves();
		
		Conjunto clavesComun = new Conjunto();
		clavesComun.inicializarConjunto();
		
		while (!clavesD1.conjuntoVacio()) {
			int clave = clavesD1.elegir();
			clavesD1.sacar(clave);
			if (clavesD2.pertenece(clave)) {
				clavesComun.agregar(clave);
			}
		}
		
		while (!clavesComun.conjuntoVacio()) {
			int clave = clavesComun.elegir();
			clavesComun.sacar(clave);
			Conjunto valoresD1 = d1.recuperar(clave);
			Conjunto valoresD2 = d2.recuperar(clave);
			while (!valoresD1.conjuntoVacio()) {
				int valor = valoresD1.elegir();
				valoresD1.sacar(valor);
				if (valoresD2.pertenece(valor)) {					
					res.agregar(clave, valor);
				}
			}
		}
		
		return res;
	}
}
