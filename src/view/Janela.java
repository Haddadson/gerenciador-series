package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Janela extends JFrame {
	public Janela(){
		super("Gerenciador de Séries");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		setVisible(true);
	}
	
	private void initComponents(){
		JPanel panel = new JPanel(new BorderLayout());
		
		panel.add(new JLabel("teste"), BorderLayout.CENTER);
		
		setContentPane(panel);
		pack();
	}
}
