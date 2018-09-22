package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class JanelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;

	//private Historico hist;
	//private MenuControle menu;
	//private PainelInfo info;
	//private BarraMenu barraMenu;
	//private Graficos graficos;

	public JanelaPrincipal() {
		super("Gerenciador de Séries");
		setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(600, 400));
		setResizable(true);
		initComponents();
		setLocationRelativeTo(null);
	}


	//public MenuControle getMenuControle() {
	//	return menu;
	//}

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

	private void initComponents() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));

		hist = new Historico();
		menu = new MenuControle(hist);
		info = new PainelInfo();
		graficos = new Graficos(hist);

		

		setContentPane(mainPanel);
		pack();
	}

}
