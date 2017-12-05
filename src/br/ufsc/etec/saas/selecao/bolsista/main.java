package br.ufsc.etec.saas.selecao.bolsista;

import javax.swing.JOptionPane;

public class main {

	public static void main(String[] args) {
		Metodos met = new Metodos();
		int opcao = 0;
		while (opcao != 3) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(("1 - Depositar \n 2 -Sacar \n 3- Sair ")));
			switch (opcao) {
				case 1:
					met.depositar();
					break;

				case 2:
					met.sacar();
					break;
				case 3:
					break;

				default:
					System.out.println("Opção inválida");
			}
		}

	}
}
