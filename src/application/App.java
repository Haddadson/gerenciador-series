package application;


import view.VisaoInicial;

public class App {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		int operacao = 0;
		VisaoInicial vs = new VisaoInicial();
		while(operacao != 6) {
			operacao = vs.menuInicial();
		}
		
		
		
	}
	

}
