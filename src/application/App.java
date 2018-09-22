package application;

import business.OperacoesLista;
import model.Lista;

public class App {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		Lista lista = new Lista();
		lista = OperacoesLista.lerArquivo(lista);
		lista.mostrar();
		
	}

}
