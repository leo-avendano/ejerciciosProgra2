package implementacionDinamica;

import java.util.Random;
import java.util.ArrayList;


import tdas.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA<Integer> {
	Nodo origen;
	int indice;

	public void inicializarConjunto() {
		this.origen = null;
		this.indice = 0;
	}

	public void agregar(Integer x) {
		Nodo nuevo = new Nodo(x);
		if (!this.pertenece(x)) {
			nuevo.anexar(this.origen);
			this.origen = nuevo;
			this.indice++;
		}
	}

	public void sacar(Integer x) {
		if (this.origen != null) {
			int idxSacar = indiceValor(x);
			if (idxSacar > 0) {
				int i = 0;
				Nodo actual = this.origen;
				while (i < idxSacar - 1) {
					actual = actual.getSiguiente();
					i++;
				}
				actual.anexar(actual.getSiguiente().getSiguiente());
			} else if (idxSacar == 0) {
				this.origen = this.origen.getSiguiente();
			}
			this.indice--;
		}
	}

	public Integer elegir() {
		Integer resultado = null;
		if (this.indice > 0) {			
			Random random = new Random();
			int x = random.nextInt(this.indice);
			int i = 0;
			Nodo actual = this.origen;
			while (i < x) {
				actual = actual.getSiguiente();
				i++;
			}
			resultado = actual.getInfo();
		}
		return resultado;
	}

	public boolean pertenece(Integer x) {
		return indiceValor(x) != -1;
	}

	public boolean conjuntoVacio() {
		return origen == null;
	}
	
	private int indiceValor(int x) {
		Nodo actual = this.origen;
		int resultado = -1;
		if (actual != null) {
			int i = 0;
			while (resultado == -1 && actual != null) {
				if (actual.getInfo() == x) {
					resultado = i;
				}
				actual = actual.getSiguiente();
				i++;
			}
		}
		return resultado;
	}
	
	
	public void print() {
		Nodo actual = this.origen;
		if (actual != null) {
			ArrayList<Integer> valores = new ArrayList<Integer>();
			while (actual != null) {
				valores.add(actual.getInfo());
				actual = actual.getSiguiente();
			}
			System.out.println(valores.toString());
		} else {
			System.out.println("[]");
		}
	}
}
