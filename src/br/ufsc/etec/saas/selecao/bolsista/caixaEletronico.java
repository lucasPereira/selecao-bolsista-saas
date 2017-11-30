package br.ufsc.etec.saas.selecao.bolsista;

import java.util.HashMap;
import java.util.Map;

public class caixaEletronico {

	private Map<String, Integer> Notas;

	public caixaEletronico() {
		Notas = new HashMap<String, Integer>();
		Notas.put("10", 0);
		Notas.put("20", 0);
		Notas.put("50", 0);
		Notas.put("100", 0);
	}

	public void registraDeposito(int nNotas, String valor) {
		int numeroNotas = Notas.get(valor);
		Notas.remove(valor);
		Notas.put(valor, numeroNotas + nNotas);
	}

	public void Saque(int valor) {
		int Ini10 = Notas.get("10");
		int Ini20 = Notas.get("20");
		int Ini50 = Notas.get("50");
		int Ini100 = Notas.get("100");
		if (((Notas.get("10") * 10) + (Notas.get("20") * 20) + (Notas.get("50") * 50) + (Notas.get("100") * 100)) >= valor) {
			while (valor > 0) {
				if (valor < 10) {
					System.err.println("Saldo insuficiente");
					System.exit(1);
				}
				else if (valor >= 100 && Notas.get("100") > 0) {
					int N100 = Notas.get("100");
					Notas.remove(valor);
					Notas.put("100", N100 - 1);
					System.out.println("100");
					valor = valor - 100;
				}
				else if (valor >= 50 && Notas.get("50") > 0) {
					int N50 = Notas.get("50");
					Notas.remove(valor);
					Notas.put("50", N50 - 1);
					System.out.println("50");
					valor = valor - 50;
				}
				else if (valor >= 20 && Notas.get("20") > 0) {
					int N20 = Notas.get("20");
					Notas.remove(valor);
					Notas.put("20", N20 - 1);
					System.out.println("20");
					valor = valor - 20;
				}
				else if (valor >= 10 && Notas.get("10") > 0) {
					int N10 = Notas.get("10");
					Notas.remove(valor);
					Notas.put("10", N10 - 1);
					System.out.println("10");
					valor = valor - 10;
				}
				else {
					System.err.println("Saldo insuficiente");
					System.exit(1);
				}
			}
		}
		else {
			System.err.println("Saldo insuficiente");
			System.exit(1);
		}
		System.out.println("Notas retiradas de 10: " + (Ini10 - Notas.get("10")) + " 20: " + (Ini20 - Notas.get("20")) + " 50: " + (Ini50 - Notas.get("50")) + " 100: " + (Ini100 - Notas.get("100")));
		System.out.println("");
	}

}
