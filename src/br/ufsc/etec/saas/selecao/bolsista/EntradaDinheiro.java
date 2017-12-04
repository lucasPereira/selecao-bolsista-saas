package br.ufsc.etec.saas.selecao.bolsista;

import java.util.Scanner;

public class EntradaDinheiro {

	public static void main(String[] args) {
		// Quantidade de Notas
		Scanner entrada = new Scanner(System.in);
		int qtdNotasDez;
		int qtdNotasVinte;
		int qtdNotasCinquenta;
		int qtdNotasCem;
		int valorTotalDepositado;
		int valorSaque;
		int inteiro;

		System.out.println("Entre com a quantidade de notas de R$ 10,00:");
		qtdNotasDez = entrada.nextInt();

		System.out.println("Entre com a quantidade de notas de R$ 20,00:");
		qtdNotasVinte = entrada.nextInt();

		System.out.println("Entre com a quantidade de notas de R$ 50,00:");
		qtdNotasCinquenta = entrada.nextInt();

		System.out.println("Entre com a quantidade de notas de R$ 100,00:");
		qtdNotasCem = entrada.nextInt();

		System.out.println("Quantidade de notas de R$ 10,00 Depositadas: " + qtdNotasDez + "\n");
		System.out.println("Quantidade de notas de R$ 20,00 Depositadas: " + qtdNotasVinte + "\n");
		System.out.println("Quantidade de notas de R$ 50,00 Depositadas: " + qtdNotasCinquenta + "\n");
		System.out.println("Quantidade de notas de R$ 100,00 Depositadas: " + qtdNotasCem + "\n");

		valorTotalDepositado = 10 * qtdNotasDez + 20 * qtdNotasVinte + 50 * qtdNotasCinquenta + 100 * qtdNotasCem;

		System.out.println("Valor total depositado: " + valorTotalDepositado + "\n");

		System.out.println("Digite o valor a ser sacado, apenas valores inteiros:");
		valorSaque = entrada.nextInt();

		if (valorSaque <= valorTotalDepositado) {

		}
		else {
			System.out.println("Saque rejeitado! Valor não disponível para saque.");

		}

	}

}
