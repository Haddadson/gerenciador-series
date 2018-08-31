public class Lista {
	Serie[] array;
	int n;
	int tamanho;

	Lista() {
		this(6);
	}

	Lista(int tamanho) {
		this.tamanho = tamanho;
		array = new Serie[tamanho];
		n = 0;
	}
	
	Serie[] getArray() {
		return array;
	}
	
	int getTamanhoArray() {
		return tamanho;
	}
	
	int getTamanhoLista() {
		return n;
	}
	
	void inserirInicio(Serie x) throws Exception {
		if (n >= array.length)
			throw new Exception("Erro!");
		for (int i = n; i > 0; i--) {
			array[i] = array[i - 1];
		}
		array[0] = x;
		n++;
	}

	void inserirFim(Serie x) throws Exception {
		if (n >= array.length)
			throw new Exception("Erro!");
		array[n] = x;
		n++;
	}

	void inserir(Serie x, int pos) throws Exception {
		if (n >= array.length || pos < 0 || pos > n)
			throw new Exception("Erro!");
		for (int i = n; i > pos; i--) {
			array[i] = array[i - 1];
		}
		array[pos] = x;
		n++;
	}

	Serie removerInicio() throws Exception {
		if (n == 0)
			throw new Exception("Erro!");
		Serie resp = array[0];
		n--;
		for (int i = 0; i < n; i++) {
			array[i] = array[i + 1];
		}
		return resp;
	}

	Serie removerFim() throws Exception {
		if (n == 0)
			throw new Exception("Erro!");
		return array[--n];
	}

	Serie remover(int pos) throws Exception {
		if (n == 0 || pos < 0 || pos >= n)
			throw new Exception("Erro! Lista vazia");
		Serie resp = array[pos];
		n--;
		for (int i = pos; i < n; i++) {
			array[i] = array[i + 1];
		}
		return resp;
	}
	
	Serie buscarItemNaPosicao(int pos) {
		return array[pos];
	}
	
	void mostrar() {
		System.out.print("[ ");
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("]");
	}
}