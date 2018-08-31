
public class Serie {
	private String nome, tipo, duracao, pais, idioma, emissora;
	private String transmissao, numTemporadas, numEpisodios;

	public Serie(String nome, String tipo, String duracao, String pais, String idioma, String emissora,
			String transmissao, String numTemporadas, String numEpisodios) {
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
	
	
	

}
