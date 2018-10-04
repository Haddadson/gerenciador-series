package business;

import java.io.*;
import java.util.Random;
import model.Lista;
import model.Serie;

public class OperacoesLista {
	private static final String CAMINHO_ARQUIVO_SERIES = "src/util/Series.txt";
	private static final String CAMINHO_ARQUIVO_FAVORITOS = "src/util/Favoritos.txt";
	private static final String CAMINHO_ARQUIVO_SUGESTOES = "src/util/Sugestoes.txt";
	private static int contadorSeries = 0;
	private Lista lista;
	private Lista listaFavoritos;
	private Lista listaSugestoesAleatorias;

	public OperacoesLista() {
		this.lista = new Lista();
		this.lista = lerArquivoSeries();
		this.listaFavoritos = new Lista();
		this.listaFavoritos = lerArquivoFavoritos();
		this.listaSugestoesAleatorias = new Lista();
		this.listaSugestoesAleatorias = lerArquivoSugestoes();
		
	}

	public Lista getLista() {
		return lista;
	}

	public Lista lerArquivoSeries() {

		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(CAMINHO_ARQUIVO_SERIES), "ISO-8859-1"));
			String linha = in.readLine();
			while (linha != null) {
				String atributos[] = linha.split(";");
				this.lista.inserirFim(preencherSerie(atributos));
				linha = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + CAMINHO_ARQUIVO_SERIES + "\"  não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + CAMINHO_ARQUIVO_SERIES + ".");
		}
		return lista;
	}
	
	public Lista lerArquivoFavoritos() {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(CAMINHO_ARQUIVO_FAVORITOS), "ISO-8859-1"));
			String linha = in.readLine();
			while (linha != null) {
				String atributos[] = linha.split(";");
				this.listaFavoritos.inserirFim(preencherFavorito(atributos));
				linha = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + CAMINHO_ARQUIVO_FAVORITOS + "\"  não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + CAMINHO_ARQUIVO_FAVORITOS + ".");
		}
		return listaFavoritos;
	}

	public void gravarFavoritos() {
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO_FAVORITOS));
			buffWrite.write(buscarTodasSeriesFavoritasFormatadas());
		    buffWrite.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + CAMINHO_ARQUIVO_FAVORITOS + "\"  não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + CAMINHO_ARQUIVO_FAVORITOS + ".");
		}
	}
	
	public Lista lerArquivoSugestoes() {
		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(CAMINHO_ARQUIVO_SUGESTOES), "ISO-8859-1"));
			String linha = in.readLine();
			while (linha != null) {
				String atributos[] = linha.split(";");
				this.listaSugestoesAleatorias.inserirFim(preencherFavorito(atributos));
				linha = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + CAMINHO_ARQUIVO_SUGESTOES + "\"  não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + CAMINHO_ARQUIVO_SUGESTOES + ".");
		}
		return listaSugestoesAleatorias;
	}

	public void gravarSugestoesAleatorias() {
		try {
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO_SUGESTOES));
			buffWrite.write(buscarTodasSeriesSugeridasFormatadas());
		    buffWrite.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + CAMINHO_ARQUIVO_SUGESTOES + "\"  não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + CAMINHO_ARQUIVO_SUGESTOES + ".");
		}
	}

	public Serie preencherSerie(String atributos[]) {
		Serie serie = new Serie();
		if (atributos.length == 9) {
			serie.setId(++contadorSeries);
			serie.setNome(atributos[0]);
			serie.setTipo(atributos[1]);
			serie.setDuracao(atributos[2]);
			serie.setPais(atributos[3]);
			serie.setIdioma(atributos[4]);
			serie.setEmissora(atributos[5]);
			serie.setTransmissao(atributos[6]);
			serie.setNumTemporadas(atributos[7]);
			serie.setNumEpisodios(atributos[8]);
		}
		return serie;
	}
	
	public Serie preencherFavorito(String atributos[]) {
		Serie serie = new Serie();
		if (atributos.length == 10) {
			serie.setId(Integer.parseInt(atributos[0]));
			serie.setNome(atributos[1]);
			serie.setTipo(atributos[2]);
			serie.setDuracao(atributos[3]);
			serie.setPais(atributos[4]);
			serie.setIdioma(atributos[5]);
			serie.setEmissora(atributos[6]);
			serie.setTransmissao(atributos[7]);
			serie.setNumTemporadas(atributos[8]);
			serie.setNumEpisodios(atributos[9]);
		}
		return serie;
	}

	public boolean favoritarSerie(Serie serie) {
		if (listaFavoritos.pesquisarPorIdSerie(serie.getId()) == null) {
			listaFavoritos.inserirFim(serie);
			gravarFavoritos();
			return true;
		}
		return false;
	}

	public Serie buscarSeriePorId(int id) {
		return lista.pesquisarPorIdSerie(id);
	}

	public Serie buscarSeriePorNome(String nome) {
		return lista.pesquisarPorNomeSerie(nome);
	}

	public String buscarTodasSeries() {
		return lista.preencherString();
	}

	public String buscarTodasSeriesFavoritas() {
		return listaFavoritos.preencherString();
	}
	
	public String buscarTodasSeriesSugeridasFormatadas() {
		return listaSugestoesAleatorias.formatarListaParaArquivo();
	}
	
	public String buscarTodasSeriesFavoritasFormatadas() {
		return listaFavoritos.formatarListaParaArquivo();
	}

	public Serie removerFavoritoPorId(int id) {
		try {
			Serie serie = listaFavoritos.removerPorIdSerie(id);
			gravarFavoritos();
			return serie;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void limparListaSugestoesAleatorias() {
		try {
			listaSugestoesAleatorias.limparLista();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Lista obterSugestoesAleatorias() {
		if (listaSugestoesAleatorias.isEmpty()) {
			gerarSugestoesAleatorias();
		} else {
			if(validarSeExisteElementoRepetido()) {
				gerarSugestoesAleatorias();
			}
		}
		return listaSugestoesAleatorias;
	}
	
	public boolean validarSeExisteElementoRepetido() {
		Serie aux;
		for(int i = 0; i < lista.getQtdItens(); i++) {
			aux = listaFavoritos.pesquisarPorIdSerie(i);
			if(aux != null) {
				if(listaSugestoesAleatorias.pesquisarPorIdSerie(aux.getId()) != null) {
					return true;
				}
			}
		}
		return false;		
	}

	public void gerarSugestoesAleatorias() {
		listaSugestoesAleatorias = new Lista();
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			int randomNum = rand.nextInt((60 - 1) + 1) + 1;
			Serie serieAleatoria = lista.pesquisarPorIdSerie(randomNum);
			if (listaSugestoesAleatorias.pesquisarPorIdSerie(randomNum) == null
					&& listaFavoritos.pesquisarPorIdSerie(randomNum) == null) {
				listaSugestoesAleatorias.inserirFim(serieAleatoria);
			} else {
				i--;
			}
		}
		gravarSugestoesAleatorias();
	}
}
