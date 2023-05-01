package implementacion;

import tdas.PilaTDA;

public class Pila implements PilaTDA {
	
	int[] arr;
	int indice;

	@Override
	public void inicializarPila() {
		arr = new int[10];
		indice = 0;
	}

	@Override
	public void apilar(int x) {
		arr[indice] = x;
		indice++;
	}

	@Override
	public void desapilar() {
		indice--;
	}

	@Override
	public int tope() {
		return arr[indice-1];
	}

	@Override
	public boolean pilaVacia() {
		return indice == 0;
	}

}
