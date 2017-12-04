package br.ufsc.etec.saas.selecao.bolsista;

import java.util.Scanner;

public class SaqueDinheiro {

	public static void main(String[] args) {
		// Valor a ser sacado
		Scanner entrada = new Scanner(System.in);
		int valorSaque;
		int valorTotalDepositado = EntradaDinheiro.getvalorTotalDepositado();

		System.out.println("Digite o valor a ser sacado, apenas valores inteiros:");
		valorSaque = entrada.nextInt();

		if (valorSaque <= valorTotalDepositado) {

		}
		else {
			System.out.println("Saque rejeitado! Valor não disponível para saque.");

		}

	}

}
