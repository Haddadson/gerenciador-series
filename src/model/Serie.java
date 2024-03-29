package model;

public class Serie {
	private int id;
	private String nome, tipo, duracao, pais, idioma, emissora;
	private String transmissao, numTemporadas, numEpisodios;

	public Serie(int id, String nome, String tipo, String duracao, String pais, String idioma, String emissora,
			String transmissao, String numTemporadas, String numEpisodios) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.duracao = duracao;
		this.pais = pais;
		this.idioma = idioma;
		this.emissora = emissora;
		this.transmissao = transmissao;
		this.numTemporadas = numTemporadas;
		this.numEpisodios = numEpisodios;
	}
	
	public Serie(){
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEmissora() {
		return emissora;
	}

	public void setEmissora(String emissora) {
		this.emissora = emissora;
	}

	public String getTransmissao() {
		return transmissao;
	}

	public void setTransmissao(String transmissao) {
		this.transmissao = transmissao;
	}

	public String getNumTemporadas() {
		return numTemporadas;
	}

	public void setNumTemporadas(String numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public String getNumEpisodios() {
		return numEpisodios;
	}

	public void setNumEpisodios(String numEpisodios) {
		this.numEpisodios = numEpisodios;
	}

	@Override
	public String toString() {
		return "S�rie [ ID = "+ id + ", nome = " + nome + ", tipo = " + tipo + ", dura��o = " + duracao + ", pa�s = " + pais + ", idioma = "
				+ idioma + ", emissora = " + emissora + ", transmissao = " + transmissao + ", n�mero de temporadas = "
				+ numTemporadas + ", n�mero de epis�dios = " + numEpisodios + " ]\n";
	}
	
	public String formatarParaArquivo() {
		return id+";"+nome+";"+tipo+";"+duracao+";"+pais+";"+idioma+";"+emissora+";"+transmissao+";"+numTemporadas+";"+numEpisodios + System.lineSeparator();
	}
}
