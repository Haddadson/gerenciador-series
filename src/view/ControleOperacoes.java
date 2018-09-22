package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import business.OperacoesLista;

public class ControleOperacoes extends JPanel {

	private OperacoesLista op;
	private static final long serialVersionUID = 1L;

	private static final int OPERACAO_BUSCAR_SERIE = 1;
	private static final int OPERACAO_ADICIONAR_FAVORITO = 2;
	private static final int OPERACAO_REMOVER_FAVORITO = 3;
	private static final int OPERACAO_VER_FAVORITOS = 4;
	private static final int OPERACAO_SUGESTOES_SERIES = 5;
	private static final int OPERACAO_SAIR = 6;

	public ControleOperacoes() {
		super();
		op = new OperacoesLista();
		setPreferredSize(new Dimension(100, 100));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		initComponents();
	}

	private void initInfoLabel() {
		// infoLabel = new JLabel();
		// add(infoLabel);
	}

	private void initComponents() {
		addButton("Buscar s�rie", OPERACAO_BUSCAR_SERIE, "Buscar s�rie");
		addButton("Adicionar favorito", OPERACAO_ADICIONAR_FAVORITO, "Adicionar favorito");
		addButton("Remover favorito", OPERACAO_REMOVER_FAVORITO, "Remover favorito");
		addButton("Ver favoritos", OPERACAO_VER_FAVORITOS, "Ver favoritos");
		addButton("Sugest�es de s�rie", OPERACAO_SUGESTOES_SERIES, "Sugest�es de s�rie");
		// initInfoLabel();
		add(Box.createVerticalGlue());
		addButton("Sair", OPERACAO_SAIR, "Sair do programa.");
	}

	private void addButton(String label, int operacao, String descricao) {
		JButton btn = new JButton(label);
		btn.setPreferredSize(new Dimension(100, 40));
		btn.setMaximumSize(new Dimension(100, 40));
		btn.addActionListener((ActionEvent) -> {
			fazerOperacao(operacao);
		});
		btn.setToolTipText(descricao);
		add(btn);
	}

	public void fazerOperacao(int operacao) {
		try {
			if (operacao == OPERACAO_BUSCAR_SERIE) {
				op.buscarSerie(obterNomeSerie());
			} else if (operacao == OPERACAO_ADICIONAR_FAVORITO) {
				fazerDeposito();
			} else if (operacao == OPERACAO_REMOVER_FAVORITO) {
				alterarSaldoMinimo();
			} else if (operacao == OPERACAO_VER_FAVORITOS) {

			} else if (operacao == OPERACAO_SUGESTOES_SERIES) {

			} else if (operacao == OPERACAO_SAIR) {
				System.exit(0);
			}
		} catch (Exception e) {
			if (e.getMessage() != null) {
				JOptionPane.showMessageDialog(null, "Erro ao processar opera��o: " + e.getMessage());
			}
		}
	}
	
	public String obterNomeSerie() {
		return JOptionPane.showInputDialog(null, "Digite o nome da s�rie a ser pesquisada: ");
	}
}
