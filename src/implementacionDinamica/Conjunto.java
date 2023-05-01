package implementacionDinamica;

import java.util.Random;

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
		int idxSacar = indiceValor(x);
		if (idxSacar > 1) {
			int idxAnterior = 0;
			Nodo anteriorAlSacar = this.origen;
			while (idxAnterior < idxSacar - 1) {
				anteriorAlSacar = anteriorAlSacar.getSiguiente();
				idxAnterior++;
			}
			Nodo sigAlSacar = anteriorAlSacar.getSiguiente().getSiguiente();
			anteriorAlSacar.anexar(sigAlSacar);
		} else if (idxSacar == 1) {
			this.origen.anexar(null);
		} else if (idxSacar == 0) {
			this.origen = null;
		}
	}

	public Integer elegir() {
		Random random = new Random();
		int x = random.nextInt(this.indice);
		int i = 0;
		Nodo actual = this.origen;
		while (i < x) {
			actual = actual.getSiguiente();
			i++;
		}
		return actual.getInfo();
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
	
}
