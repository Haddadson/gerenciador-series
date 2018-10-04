package model;

public class Lista {
	private Celula primeiro, ultimo;
	private int qtdItens;

	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
		this.qtdItens = 0;
	}

	public Lista(Serie serie) {
		this.primeiro = this.ultimo = new Celula(serie);
		this.qtdItens++;
	}

	public void inserirInicio(Serie x) {
		Celula tmp = new Celula(x);

		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {
			ultimo = tmp;
		} else {
			tmp.prox.ant = tmp;
		}
		tmp = null;
		this.qtdItens++;
	}

	public void inserirFim(Serie x) {
		ultimo.prox = new Celula(x);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
		this.qtdItens++;
	}

	public void inserir(Serie x, int pos) throws Exception {

		if (pos < 0 || pos > qtdItens) {
			throw new Exception("Erro!");
		} else if (pos == 0) {
			inserirInicio(x);
		} else if (pos == qtdItens) {
			inserirFim(x);
		} else {
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;
			Celula tmp = new Celula(x);
			tmp.ant = i;
			tmp.prox = i.prox;
			tmp.ant.prox = tmp.prox.ant = tmp;
			tmp = i = null;
		}

		this.qtdItens++;

	}

	public Serie removerInicio() throws Exception {
		if (primeiro == ultimo)
			throw new Exception("Erro!");
		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Serie elemento = primeiro.getElemento();
		tmp.prox = primeiro.ant = null;
		tmp = null;
		this.qtdItens--;

		return elemento;
	}

	public Serie removerFim() throws Exception {
		if (primeiro == ultimo)
			throw new Exception("Erro!");
		Serie elemento = ultimo.getElemento();
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;
		this.qtdItens--;
		return elemento;
	}

	public Serie remover(int pos) throws Exception {
		Serie elemento;
		if (primeiro == ultimo) {
			throw new Exception("Erro!");
		} else if (pos < 0 || pos >= qtdItens) {
			throw new Exception("Erro!");
		} else if (pos == 0) {
			elemento = removerInicio();
		} else if (pos == qtdItens - 1) {
			elemento = removerFim();
		} else {
			Celula i = primeiro.prox;
			for (int j = 0; j <= pos; j++, i = i.prox);
			i.ant.prox = i.prox;
			i.prox.ant = i.ant;
			elemento = i.getElemento();
			i.prox = i.ant = null;
			i = null;
		}
		return elemento;
	}
	
	public void limparLista() throws Exception {
		while(primeiro != ultimo) {
			removerFim();
		}
	}

	public Serie pesquisarPorPosicao(int pos) throws Exception {
		Celula aux;

		if (!posicaoExiste(pos)) {
			throw new Exception("A posição informada não existe !");
		}

		aux = primeiro;
		for (int i = pos; i > 0; i--) {
			aux = aux.prox;
		}
		return aux.getElemento();
	}

	public Serie pesquisarPorNomeSerie(String nome) {
		Celula aux = primeiro;

		while (aux != null && (!nome.equalsIgnoreCase(aux.getElemento().getNome()))) {
			aux = aux.prox;
		}

		if (aux != null) {
			return aux.getElemento();
		}
		return null;
	}
	
	public Lista pesquisarPorEmissora(String emissora) {
		Celula aux = primeiro;
		Lista seriesComEmissora = new Lista();
		while (aux != null) {
			if (emissora.equalsIgnoreCase(aux.getElemento().getEmissora())) {
				seriesComEmissora.inserirFim(aux.getElemento());
			}
			aux = aux.prox;
		}

		if (seriesComEmissora.isEmpty()) {
			return null;
		}
		return seriesComEmissora;
	}

	public Serie pesquisarPorIdSerie(int id) {
		Celula aux = primeiro.prox;

		while (aux != null && (id != aux.getElemento().getId())) {
			aux = aux.prox;
		}

		if (aux != null) {
			return aux.getElemento();
		}
		return null;
	}
	
	public Serie removerPorIdSerie(int id) throws Exception {
		Celula aux = primeiro.prox;
		Serie elemento;
		while (aux != null && (id != aux.getElemento().getId())) {
			aux = aux.prox;
		}

		if (aux != null) {
			if(aux.prox == null && aux.ant != null) {
				 elemento = removerFim();
			} else if(aux.ant == null && aux.prox != null) {
				elemento = removerInicio();
			} else {
				aux.ant.prox = aux.prox;
				aux.prox.ant = aux.ant;
				elemento = aux.getElemento();
				aux.prox = aux.ant = null;
				aux = null;	
			} 
			return elemento;
		}
		return null;
	}

	public void mostrar() {
		Celula i = primeiro;
		while (i != null) {
			if (i.getElemento() != null) {
				System.out.println(i.getElemento().toString());
			}
			i = i.prox;
		}
	}

	public String preencherString() {
		Celula i = primeiro;
		String stringPreenchido = "";
		while (i != null) {
			if (i.getElemento() != null) {
				stringPreenchido += i.getElemento().toString() + "\n";
			}
			i = i.prox;
		}
		return stringPreenchido;
	}
	
	public String formatarListaParaArquivo() {
		Celula i = primeiro;
		String stringPreenchido = "";
		while (i != null) {
			if (i.getElemento() != null) {
				stringPreenchido += i.getElemento().formatarParaArquivo();
			}
			i = i.prox;
		}
		return stringPreenchido;
	}
	
	public boolean isEmpty() {
		if (primeiro == ultimo)
			return true;
		return false;
	}

	private boolean posicaoExiste(int posicao) {
		return posicao >= 0 && posicao < qtdItens;
	}

	public int getQtdItens() {
		return qtdItens;
	}
}