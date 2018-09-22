package business;

import java.io.*;
import model.Lista;
import model.Serie;

public class OperacoesLista {
	private static final String CAMINHO_ARQUIVO = "src/util/Series.txt";
	private static int contadorSeries = 0;

	public OperacoesLista() {}

	public static Lista lerArquivo(Lista lista) {

		try {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(new FileInputStream(CAMINHO_ARQUIVO), "UTF-8"));
			String linha = in.readLine();
			while (linha != null) {
				String atributos[] = linha.split(";");
				lista.inserirFim(preencherSerie(atributos));
				linha = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo \"" + CAMINHO_ARQUIVO + "\"  não existe.");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo " + CAMINHO_ARQUIVO + ".");
		}
		return lista;
	}

	public static Serie preencherSerie(String atributos[]) {
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

}
