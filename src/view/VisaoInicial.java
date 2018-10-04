package view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import business.OperacoesLista;
import model.Lista;
import model.Serie;

public class VisaoInicial {
	public OperacoesLista op;

	public VisaoInicial() {
		setLookAndFeel();
		op = new OperacoesLista();
	}

	// Setar o layout como Look And Feel - Nimbus
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
		try {
			operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1-Visualizar s�ries\n2-Buscar s�rie por ID" + "\n3-Favoritar s�rie\n4-Remover favorito"
							+ "\n5-Listar favoritos\n6-Sugest�es\n7-Gerar novas sugest�es\n8-Sair" + "\nEscolha uma op��o:",
					"Gerenciador de S�ries", JOptionPane.INFORMATION_MESSAGE));
			switch (operacao) {
			case 1:
				JanelaTexto.imprimirComScroll(op.buscarTodasSeries(), "Todas s�ries");
				break;
			case 2:
				Serie serieObtida;
				String valorPesquisa = JOptionPane.showInputDialog(null, "Digite o id da s�rie a ser buscada:",
						"Busca de s�ries por ID", JOptionPane.QUESTION_MESSAGE);
				serieObtida = op.buscarSeriePorId(Integer.parseInt(valorPesquisa));
				if(serieObtida != null) {
					JanelaTexto.imprimirComScroll("\n" + serieObtida.toString(), "S�rie encontrada",3, 100);
				} else {
					JOptionPane.showMessageDialog(null, "A s�rie com este ID n�o foi encontrada!", "Falha", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case 3:
				String serieFavoritada = JOptionPane.showInputDialog(null, "Digite o id da s�rie a ser favoritada:",
						"Favoritar s�rie por ID", JOptionPane.QUESTION_MESSAGE);
				serieObtida = op.buscarSeriePorId(Integer.parseInt(serieFavoritada));
				if(serieObtida != null) {
					if(op.favoritarSerie(serieObtida)) {
						JanelaTexto.imprimirComScroll("\nA s�rie abaixo foi marcada como favorita! \n" 
								   + serieObtida.toString(), "S�rie favoritada", 5, 60);	
					}
					else {
						JOptionPane.showMessageDialog(null, "Erro!\nEssa s�rie j� est� marcada como favorita!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}	
				} else {
					JOptionPane.showMessageDialog(null, "A s�rie com este ID n�o foi encontrada!", "Falha", JOptionPane.WARNING_MESSAGE);
				}
								
				break;
			case 4:
				String removerSerie = JOptionPane.showInputDialog(null, "Digite o id da s�rie a ser removida dos favoritos:",
						"Remover s�rie dos favoritos por ID", JOptionPane.QUESTION_MESSAGE);
				Serie serieRemovida = op.removerFavoritoPorId(Integer.parseInt(removerSerie));
				if(serieRemovida != null) {
					JanelaTexto.imprimirComScroll("\nA s�rie abaixo foi removida dos favoritos! \n" 
							   + serieRemovida.toString(), "S�rie removida",5, 60);	
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
				JanelaTexto.imprimirComScroll(seriesFavoritas, "Todas s�ries favoritas");
				break;
			case 6:
				Lista sugestoesAleatorias = op.obterSugestoesAleatorias();
				String sugestoes = "";
				sugestoes += "Outras s�ries que talvez voc� goste\n=============================\n\n" 
							+ sugestoesAleatorias.preencherString();
				JanelaTexto.imprimirComScroll(sugestoes, "Algumas sugest�es");
				break;
			case 7: 
				op.gerarSugestoesAleatorias();
				JOptionPane.showMessageDialog(null, "Novas sugest�es foram geradas!", "Novas sugest�es", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Encerrando o programa...", "Encerrando", JOptionPane.PLAIN_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "A op��o inserida � inv�lida!", "Falha", JOptionPane.WARNING_MESSAGE);
				break;
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "O caractere inserido � inv�lido!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return operacao;
	}
}
