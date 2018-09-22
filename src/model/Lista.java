package model;

public class Lista {
	private Celula primeiro, ultimo;
	private int qtdItens;

	public Lista() {
		this.ultimo = this.primeiro = null;
		this.qtdItens = 0;
	}

	public Lista(Serie serie) {
		this.primeiro = this.ultimo = new Celula(serie);
		this.qtdItens++;
	}

	public void inserirInicio(Serie x) {
		Celula tmp = new Celula(x);
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {
			ultimo = tmp;
		}
		tmp = null;
		qtdItens++;
	}

	public void inserirFim(Serie x) {
		Celula aux = new Celula(x);

		if (isEmpty()) {
			this.primeiro = this.ultimo = aux;
		} else {
			aux.setAnt(this.ultimo);
			this.ultimo.setProx(aux);

			this.ultimo = aux;
		}

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
			tmp.prox = i.prox;
			i.prox = tmp;
			tmp = i = null;
		}
		qtdItens++;
	}

	public Serie removerInicio() throws Exception {
		if (isEmpty())
			throw new Exception("A lista está vazia !");

		Celula aux = this.primeiro;
		this.primeiro = this.primeiro.prox;

		aux.ant = null;
		aux.prox = null;

		if (this.primeiro == null) {
			this.primeiro = this.ultimo = null;
		} else
			this.primeiro.ant = null;

		this.qtdItens--;

		return aux.getElemento();
	}

	public Serie removerFim() throws Exception {
		if (primeiro == ultimo)
			throw new Exception("Erro!");
		Celula i;
		for (i = primeiro; i.prox != ultimo; i = i.prox)
			;
		Serie elemento = ultimo.getElemento();
		ultimo = i;
		i = ultimo.prox = null;
		qtdItens--;
		return elemento;
	}

	public Serie remover(int pos) throws Exception {
		Serie elemento;
		if (primeiro == ultimo || pos < 0 || pos >= qtdItens) {
			throw new Exception("Erro!");
		} else if (pos == 0) {
			elemento = removerInicio();
		} else if (pos == qtdItens - 1) {
			elemento = removerFim();
		} else {
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;
			Celula tmp = i.prox;
			elemento = tmp.getElemento();
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;
		}
		qtdItens--;
		return elemento;
	}

	public Serie pesquisarPorPosicao(int pos) throws Exception {
		Celula aux;
		
		if(!posicaoExiste(pos)) {
			throw new Exception("A posição informada não existe !");
		}
	
		aux = primeiro;
		for(int i = pos; i > 0; i--) {
			aux = aux.prox;
		}
		return aux.getElemento();
	}
	
	public Serie pesquisarPorNomeSerie(String nome) {
		Celula aux = primeiro;
		
		while(aux != null && (!nome.equalsIgnoreCase(aux.getElemento().getNome()))) {
			aux = aux.prox;
		}
		
		if(aux != null) {
			return aux.getElemento();
		}		
		return null; 
	}
	
	public Serie pesquisarPorIdSerie(int id) {
		Celula aux = primeiro;
		
		while(aux != null && (id != aux.getElemento().getId())) {
			aux = aux.prox;
		}
		
		if(aux != null) {
			return aux.getElemento();
		}		
		return null; 
	}

	public void mostrar() {
		Celula i = primeiro;
		while (i != null) {
			System.out.println(i.getElemento().toString());
			i = i.prox;
		}
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