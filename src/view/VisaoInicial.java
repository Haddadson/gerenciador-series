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
			// Se não encontrar o Look And Feel Nimbus, usar o nativo:
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Não foi possivel carregar o look and feel Nimbus: " + e.getMessage());
		}
	}

	public int menuInicial() {
		int operacao = 0;
		try {
			operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"1-Visualizar séries\n2-Buscar série por ID" + "\n3-Favoritar série\n4-Remover favorito"
							+ "\n5-Listar favoritos\n6-Sugestões\n7-Gerar novas sugestões\n8-Sair" + "\nEscolha uma opção:",
					"Gerenciador de Séries", JOptionPane.INFORMATION_MESSAGE));
			switch (operacao) {
			case 1:
				JanelaTexto.imprimirComScroll(op.buscarTodasSeries(), "Todas séries");
				break;
			case 2:
				Serie serieObtida;
				String valorPesquisa = JOptionPane.showInputDialog(null, "Digite o id da série a ser buscada:",
						"Busca de séries por ID", JOptionPane.QUESTION_MESSAGE);
				serieObtida = op.buscarSeriePorId(Integer.parseInt(valorPesquisa));
				if(serieObtida != null) {
					JanelaTexto.imprimirComScroll("\n" + serieObtida.toString(), "Série encontrada",3, 100);
				} else {
					JOptionPane.showMessageDialog(null, "A série com este ID não foi encontrada!", "Falha", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case 3:
				String serieFavoritada = JOptionPane.showInputDialog(null, "Digite o id da série a ser favoritada:",
						"Favoritar série por ID", JOptionPane.QUESTION_MESSAGE);
				serieObtida = op.buscarSeriePorId(Integer.parseInt(serieFavoritada));
				if(serieObtida != null) {
					if(op.favoritarSerie(serieObtida)) {
						JanelaTexto.imprimirComScroll("\nA série abaixo foi marcada como favorita! \n" 
								   + serieObtida.toString(), "Série favoritada", 5, 60);	
					}
					else {
						JOptionPane.showMessageDialog(null, "Erro!\nEssa série já está marcada como favorita!", "ERRO", JOptionPane.ERROR_MESSAGE);
					}	
				} else {
					JOptionPane.showMessageDialog(null, "A série com este ID não foi encontrada!", "Falha", JOptionPane.WARNING_MESSAGE);
				}
								
				break;
			case 4:
				String removerSerie = JOptionPane.showInputDialog(null, "Digite o id da série a ser removida dos favoritos:",
						"Remover série dos favoritos por ID", JOptionPane.QUESTION_MESSAGE);
				Serie serieRemovida = op.removerFavoritoPorId(Integer.parseInt(removerSerie));
				if(serieRemovida != null) {
					JanelaTexto.imprimirComScroll("\nA série abaixo foi removida dos favoritos! \n" 
							   + serieRemovida.toString(), "Série removida",5, 60);	
				}
				else {
					JOptionPane.showMessageDialog(null, "Erro!\nNão foi possível remover essa série!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 5:
				String seriesFavoritas = op.buscarTodasSeriesFavoritas();
				if(seriesFavoritas.isEmpty()) {
					seriesFavoritas += "Nenhuma série está marcada como favorita até o momento.";
				}
				JanelaTexto.imprimirComScroll(seriesFavoritas, "Todas séries favoritas");
				break;
			case 6:
				Lista sugestoesAleatorias = op.obterSugestoesAleatorias();
				String sugestoes = "";
				sugestoes += "Outras séries que talvez você goste\n=============================\n\n" 
							+ sugestoesAleatorias.preencherString();
				JanelaTexto.imprimirComScroll(sugestoes, "Algumas sugestões");
				break;
			case 7: 
				op.gerarSugestoesAleatorias();
				JOptionPane.showMessageDialog(null, "Novas sugestões foram geradas!", "Novas sugestões", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 8:
				JOptionPane.showMessageDialog(null, "Encerrando o programa...", "Encerrando", JOptionPane.PLAIN_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "A opção inserida é inválida!", "Falha", JOptionPane.WARNING_MESSAGE);
				break;
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "O caractere inserido é inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return operacao;
	}
}
