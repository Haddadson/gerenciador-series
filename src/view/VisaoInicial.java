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
			// Se n�o encontrar o Look And Feel Nimbus, usar o nativo:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("N�o foi possivel carregar o look and feel Nimbus: " + e.getMessage());
		}
	}

	public int menuInicial() {
		int operacao = 0;
		operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"1-Visualizar s�ries\n2-Buscar s�rie por ID" + "\n3-Favoritar s�rie\n4-Remover favorito"
						+ "\n5-Listar favoritos\n6-Sair" + "\nEscolha uma op��o:",
				"Gerenciador de S�ries", JOptionPane.INFORMATION_MESSAGE));
		switch (operacao) {
		case 1:
			JanelaTexto.imprimirComScroll(op.buscarTodasSeries());
			break;
		case 2:
			Serie serieObtida;
			String valorPesquisa = JOptionPane.showInputDialog(null, "Digite o id da s�rie a ser buscada:",
					"Busca de s�ries por ID", JOptionPane.QUESTION_MESSAGE);
			serieObtida = op.buscarSeriePorId(Integer.parseInt(valorPesquisa));
			JanelaTexto.imprimirComScroll(serieObtida.toString());
			break;
		case 3:
			String serieFavoritada = JOptionPane.showInputDialog(null, "Digite o id da s�rie a ser favoritada:",
					"Favoritar s�rie por ID", JOptionPane.QUESTION_MESSAGE);
			serieObtida = op.buscarSeriePorId(Integer.parseInt(serieFavoritada));
			if(op.favoritarSerie(serieObtida)) {
				JanelaTexto.imprimirComScroll("A s�rie abaixo foi marcada como favorita! \n" 
						   + serieObtida.toString(), 10, 60);	
			}
			else {
				JOptionPane.showMessageDialog(null, "Erro!\nEssa s�rie j� est� marcada como favorita!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			
			break;
		case 4:
			String removerSerie = JOptionPane.showInputDialog(null, "Digite o id da s�rie a ser removida dos favoritos:",
					"Remover s�rie dos favoritos por ID", JOptionPane.QUESTION_MESSAGE);
			Serie serieRemovida = op.removerFavoritoPorId(Integer.parseInt(removerSerie));
			if(serieRemovida != null) {
				JanelaTexto.imprimirComScroll("A s�rie abaixo foi removida dos favoritos! \n" 
						   + serieRemovida.toString(), 10, 60);	
			}
			else {
				JOptionPane.showMessageDialog(null, "Erro!\nN�o foi poss�vel remover essa s�rie!", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case 5:
			String seriesFavoritas = op.buscarTodasSeriesFavoritas();
			if(seriesFavoritas.isEmpty()) {
				seriesFavoritas += "Nenhuma s�rie est� marcada como favorita at� o momento.";
			}
			JanelaTexto.imprimirComScroll(seriesFavoritas);
			break;
		case 6:
			break;
		default:
			JOptionPane.showMessageDialog(null, "Erro!\nA op��o inserida � inv�lida!", "ERRO", JOptionPane.ERROR_MESSAGE);
			break;
		}
		return operacao;
	}
}
