package br.ufsc.etec.saas.selecao.bolsista;

import javax.swing.JOptionPane;

public class Metodos {

	Nota nota = new Nota();

	public void depositar()
	{

		int opcao = 0;

		while (opcao != 5) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(("Qual nota você deseja depositar: \n 1 - Para depositar nota de 10 \n 2 - Para depositar nota de 20 \n 3 - Para depositar nota de 50 \n "
					+ "4 - Para depositar nota de 100 \n 5 - Para sair")));
			switch (opcao) {
				case 1:
					nota.setQuantidade10(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser depositada:")));
					System.out.println("Valor depositado " + 10 * nota.getQuantidade10());
					break;

				case 2:
					nota.setQuantidade20(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser depositada:")));
					System.out.println("Valor depositado " + 20 * nota.getQuantidade20());
					break;

				case 3:
					nota.setQuantidade50(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser depositada:")));
					System.out.println("Valor depositado " + 50 * nota.getQuantidade50());
					break;
				case 4:
					nota.setQuantidade100(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser depositada:")));
					System.out.println("Valor depositado " + 100 * nota.getQuantidade100());
					break;
				case 5:
					break;

				default:
					System.out.println("Opção inválida");
			}
		}
		int total = 10 * nota.getQuantidade10() + 100 * nota.getQuantidade100() + 20 * nota.getQuantidade20() + 50 * nota.getQuantidade50();
		System.out.println("Total depositado: " + total);
	}

	public void sacar() {
		int qtd100 = 0;
		int qtd50 = 0;
		int qtd20 = 0;
		int qtd10 = 0;
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Qual o valor que você gostaria de sacar?"));
		int v = valor;
		int total = 10 * nota.getQuantidade10() + 100 * nota.getQuantidade100() + 20 * nota.getQuantidade20() + 50 * nota.getQuantidade50();
		System.out.println(total);
		if (valor > total) {
			System.out.println("Valor acima do permetido");
		}
		while (valor >= 10) {
			if (nota.getQuantidade100() != 0 && valor >= 100) {
				qtd100 = cem(valor);
				valor = valor - qtd100 * 100;
				System.out.println("100");
			}
			if (nota.getQuantidade50() != 0 && valor >= 50) {
				qtd50 = cinquenta(valor);
				valor = valor - qtd50 * 50;
				System.out.println("V50");
			}
			if (nota.getQuantidade20() != 0 && valor >= 20) {
				qtd20 = vinte(valor);
				valor = valor - qtd20 * 20;
				System.out.println("V20");
			}
			if (nota.getQuantidade10() != 0 && valor >= 10) {
				qtd10 = dez(valor);
				valor = valor - qtd10 * 10;
				System.out.println("10");
			}
		}
		if (valor != 0) {
			System.out.println("Valor não permetido");
		} else {
			nota.setQuantidade10(nota.getQuantidade10() - qtd10);
			nota.setQuantidade20(nota.getQuantidade20() - qtd20);
			nota.setQuantidade50(nota.getQuantidade50() - qtd50);
			nota.setQuantidade100(nota.getQuantidade100() - qtd100);
			System.out.println("Valor retirado: " + total + " Quantidade notas:" + " 10: " + qtd10 + " 20: " + qtd20 + " 50: " + qtd50 + " 100: " + qtd100);
		}
	}

	public int cem(int valor) {
		int qtd100 = 0;
		int temp100 = nota.getQuantidade100();
		while (valor >= 100) {
			while (temp100 != 0) {
				valor = valor - 100;
				qtd100++;
				temp100--;
			}
		}
		return qtd100;
	}

	public int cinquenta(int valor) {
		int qtd50 = 0;
		int temp50 = nota.getQuantidade50();
		while (valor >= 50) {
			while (temp50 != 0) {
				valor = valor - 50;
				qtd50++;
				temp50--;
			}
		}
		return qtd50;
	}

	public int vinte(int valor) {
		int qtd20 = 0;
		int temp20 = nota.getQuantidade20();
		while (valor >= 20) {
			while (temp20 != 0) {
				valor = valor - 20;
				qtd20++;
				temp20--;
			}
		}
		return qtd20;
	}

	public int dez(int valor) {
		int qtd10 = 0;
		int temp10 = nota.getQuantidade10();
		while (valor >= 10) {
			while (temp10 != 0) {
				valor = valor - 10;
				qtd10++;
				temp10--;
			}
		}
		return qtd10;
	}
}
