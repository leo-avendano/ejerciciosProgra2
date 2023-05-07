package usoTP3;

import implementacionDinamica.DiccionarioMultiple;
import implementacionDinamica.DiccionarioSimple;
import implementacionDinamica.Conjunto;

public class EJ5_b_DiccionarioSimple {
	/* 
	 * Dado un Diccionario Simple D, que representa el concepto clásico de diccionario: la
	 * clave representa una palabra y el valor su significado. Generar un Diccionario Múltiple DS
	 * que a partir de un significado s, vincule todas las palabras que tienen dicho significado, 
	 * es decir que son sinónimos. Cada clave s será un significado y los valores asociados
	 * (sinónimos) aquellas claves de D que tenían asociado el valor s.
	 * 
	 */
	
	public static void main(String[] args) {
		// Crear un diccionario con claves aleatorias y valores aleatorios
        DiccionarioSimple d = new DiccionarioSimple();
        d.agregar(1, 10);
        d.agregar(2, 20);
        d.agregar(3, 10);
        d.agregar(4, 30);
        d.agregar(5, 20);
        
        // Imprimir el diccionario original
        System.out.println("Diccionario original:");
        d.print();
        
        // Generar un diccionario múltiple a partir del diccionario original
        DiccionarioMultiple dm = valoresAClaves(d);
        
        // Imprimir el diccionario múltiple generado
        System.out.println("Diccionario múltiple generado:");
        dm.print();
	}

	public static DiccionarioMultiple valoresAClaves(DiccionarioSimple ds) {
		DiccionarioMultiple res = new DiccionarioMultiple();
		res.inicializarDiccionario();
		
		Conjunto clavesDS = ds.claves();
				
		while (!clavesDS.conjuntoVacio()) {
			int clave = clavesDS.elegir();
			clavesDS.sacar(clave);
			int valor = ds.recuperar(clave);
			res.agregar(valor, clave);
		}
		
		return res;
	}
}
