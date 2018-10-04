package application;


import view.VisaoInicial;

public class App {

	public static void main(String[] args) {
		int operacao = 0;
		VisaoInicial vs = new VisaoInicial();
		while(operacao != 8) {
			operacao = vs.menuInicial();
		}
	}
}
