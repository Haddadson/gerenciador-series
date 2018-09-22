package model;

public class Celula {
	private Serie elemento;
	public Celula prox;
	public Celula ant;

	public Celula() {
		this.elemento = null;
		this.prox = null;
		this.ant = null;
	}
	
	public Celula(Serie x) {
		this.elemento = x;
		this.prox = null;
	}

	public Serie getElemento() {
		return elemento;
	}

	public void setElemento(Serie elemento) {
		this.elemento = elemento;
	}

	public Celula getProx() {
		return prox;
	}

	public void setProx(Celula prox) {
		this.prox = prox;
	}

	public Celula getAnt() {
		return ant;
	}

	public void setAnt(Celula ant) {
		this.ant = ant;
	}
	
}
