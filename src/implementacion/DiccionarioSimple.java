package implementacion;

import tdas.ConjuntoTDA;
import tdas.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	ElementoKeyValue[] valores;
	int tamaño = 10;
	
	public void inicializarDiccionario() {
		this.valores = new ElementoKeyValue[tamaño];
	}

	public void agregar(int clave, int valor) {
		
	}

	@Override
	public void eliminar(int clave) {
		// TODO Auto-generated method stub

	}

	@Override
	public int recuperar(int clave) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ConjuntoTDA claves() {
		String[] res = new String[tamaño];
		return res;
	}

}
