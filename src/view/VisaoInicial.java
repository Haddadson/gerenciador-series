package view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import business.OperacoesLista;
import model.Serie;
import util.MetodosUteis;

public class VisaoInicial {
	public OperacoesLista op;

	public VisaoInicial() {
		setLookAndFeel();
		op = new OperacoesLista();
	}

	// Setar o look and feel para "Nimbus"
	private void setLookAndFeel() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					return;
				}
			}
			// Se não encontrar o Look And Feel Nimbus, usar o nativo:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Não foi possivel carregar o look and feel Nimbus: " + e.getMessage());
		}
	}

	public int menuInicial() {
		int operacao = 0;
		operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1-Visualizar séries\n2-Buscar série por ID" + "\n3-Favoritar série\n4-Remover favorito"
						+ "\n5-Listar favoritos\n6-Sair" + "\nEscolha uma opção:",
				"Gerenciador de Séries", JOptionPane.INFORMATION_MESSAGE));
		switch (operacao) {
		case 1:
			JanelaTexto.imprimirComScroll(op.buscarTodasSeries());
			break;
		case 2:
			Serie serieObtida;
			String valorPesquisa = JOptionPane.showInputDialog(null, "Digite o id da série a ser buscada:",
					"Busca de séries por ID", JOptionPane.QUESTION_MESSAGE);
			serieObtida = op.buscarSeriePorId(Integer.parseInt(valorPesquisa));
			JanelaTexto.imprimirComScroll(serieObtida.toString());
			break;
		case 3:
			String serieFavoritada = JOptionPane.showInputDialog(null, "Digite o id da série a ser favoritada:",
					"Favoritar série por ID", JOptionPane.QUESTION_MESSAGE);
			serieObtida = op.buscarSeriePorId(Integer.parseInt(serieFavoritada));
			op.favoritarSerie(serieObtida);
			JanelaTexto.imprimirComScroll("A série abaixo foi marcada como favorita! \n" 
										   + serieObtida.toString(), 10, 60);
			break;
		case 4:

			break;
		case 5:
			break;
		case 6:
			break;
		}
		return operacao;
	}
}
