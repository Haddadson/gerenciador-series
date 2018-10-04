package view;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JanelaTexto {
	public JanelaTexto() {

	}

	public static void imprimirComScroll(String texto, String titulo) {
		JTextArea textArea = new JTextArea(30, 50);
		textArea.setText(texto);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void imprimirComScroll(String texto, String titulo, int altura, int largura) {
		JTextArea textArea = new JTextArea(altura, largura);
		textArea.setText(texto);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);

		JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
}
