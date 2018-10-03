package view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import business.OperacoesLista;
import model.Serie;
import util.MetodosUteis;

public class VisaoInicial {
	public OperacoesLista op;
	
	public VisaoInicial(){
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
	
	public int menuInicial(){
		int operacao = 0;
		operacao = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Visualizar s�ries\n2-Buscar s�rie"
										+"\n3-Favoritar s�rie\n5-Remover favorito"
										+"\n5-Listar favoritos\n6-Sair"
										+"\nEscolha uma op��o:", "Gerenciador de S�ries",JOptionPane.INFORMATION_MESSAGE));
		switch(operacao){
			case 1:
				JanelaTexto.imprimirComScroll(op.buscarTodasSeries());
				break;
			case 2: 
				Serie serieObtida;
				String valorPesquisa = JOptionPane.showInputDialog(null, "Digite o id ou o nome da s�rie a ser buscada:", 
																	"Busca de s�ries", JOptionPane.QUESTION_MESSAGE);
				//if(MetodosUteis.tryParseInt(valorPesquisa)) {
					serieObtida = op.buscarSeriePorId(Integer.parseInt(valorPesquisa));
				/*} else {
					serieObtida = op.buscarSeriePorNome(valorPesquisa);
				}*/
				JanelaTexto.imprimirComScroll(serieObtida.toString());
				break;
			case 3:
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
