package br.ufsc.etec.saas.selecao.bolsista;

import java.util.ArrayList;

public class Sistema {

	protected int notas10;
	protected int notas20;
	protected int notas50;
	protected int notas100;

	public int getNotas10() {
		return notas10;
	}

	public int getNotas20() {
		return notas20;
	}

	public int getNotas50() {
		return notas50;
	}

	public int getNotas100() {
		return notas100;
	}

	public Sistema() {

	}

	public void depositar(Nota nota, int quantidade) {
		int valor = nota.getValor();

		switch (valor) {
			case 10:
				notas10 += quantidade;
				break;

			case 20:
				notas20 += quantidade;
				break;

			case 50:
				notas50 += quantidade;
				break;

			case 100:
				notas100 += quantidade;
				break;
		}
		System.out.println("Foram depositadas " + quantidade + " notas de " + valor + " reais!");
		System.out.println("-----------------------------------------------");
	}

	public ArrayList<Saque> sacar(int valor) {

		ArrayList<Saque> saque = new ArrayList<>();

		if (valor > notas10 * 10 + notas20 * 20 + notas50 * 50 + notas100 * 100) {
			System.out.println("Não foi possivel realizar o saque: poucas cedulas na maquina");
			return null;
		}

		int resto = valor;
		if (valor / 100 < notas100) {
			saque.add(new Saque(new Nota(100), valor / 100));
			resto = resto - (valor / 100) * 100;
		} else {
			saque.add(new Saque(new Nota(100), notas100));
			resto = resto - notas100 * 100;
		}

		if (resto > 0) {
			if (resto / 50 < notas50) {
				saque.add(new Saque(new Nota(50), resto / 50));
				resto = resto - (resto / 50) * 50;
			} else {
				saque.add(new Saque(new Nota(50), notas50));
				resto = resto - notas50 * 50;
			}

			if (resto > 0) {
				if (resto / 20 < notas20) {
					saque.add(new Saque(new Nota(20), resto / 20));
					resto = resto - (resto / 20) * 20;
				} else {
					saque.add(new Saque(new Nota(20), notas20));
					resto = resto - notas20 * 20;
				}

				if (resto > 0) {

					if (resto / 10 < notas10) {
						saque.add(new Saque(new Nota(10), resto / 10));
						resto = resto - (resto / 10) * 10;
					} else {
						saque.add(new Saque(new Nota(10), notas10));
						resto = resto - notas10 * 10;

					}

					if (resto > 0) {
						System.out.println("Não foi possivel realizar o saque: não dispomos de cedulas " + "pequenas o bastante para suprir suas necessidades");
						return null;
					}

				}
			}
		}
		
		for(Saque s: saque){
			int qtd = s.getQuantidade();
			int nota = s.getNota().getValor();
			
			System.out.println("Você sacou " + qtd + " notas de " + nota + " reais.");
			System.out.println("-----------------------------------------------");
		}
		
		
		
		System.out.println("Retire seu dinheiro");
		return saque;

	}
}
