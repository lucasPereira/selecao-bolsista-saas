package br.ufsc.etec.saas.selecao.bolsista;

import java.util.Random;

public class Caixa {

	private int quantiaEmCaixa;
	private int notas10, notas20, notas50, notas100;
	private Random rand = new Random();

	public void registrarNotas10(int i) {
		notas10 += i;
		quantiaEmCaixa += 10 * i;
	}

	public void registrarNotas20(int i) {
		notas20 += i;
		quantiaEmCaixa += 20 * i;
	}

	public void registrarNotas50(int i) {
		notas50 += i;
		quantiaEmCaixa += 50 * i;
	}

	public void registrarNota100(int i) {
		notas100 += i;
		quantiaEmCaixa += 100 * i;
	}

	public String fazerSaque(int quantia) {
		if (quantia <= quantiaEmCaixa) {
			return selecionarNotas(quantia);
		} else {
			return "Saldo em caixa insuficiente.";
		}
	}

	public String selecionarNotas(int quantia) {
		int quantiaAux = 0;
		int tentativas = 10000000;
		int qntNotas10 = 0;
		int qntNotas20 = 0;
		int qntNotas50 = 0;
		int qntNotas100 = 0;
		while (true) {
			qntNotas10 = rand.nextInt(notas10 + 1);
			qntNotas20 = rand.nextInt(notas20 + 1);
			qntNotas50 = rand.nextInt(notas50 + 1);
			qntNotas100 = rand.nextInt(notas100 + 1);
			quantiaAux = (qntNotas10 * 10) + (qntNotas20 * 20) + (qntNotas50 * 50) + (qntNotas100 * 100);
			tentativas--;
			if (tentativas <= 0 || quantiaAux == quantia)
				break;
		}
		if (tentativas <= 0) {
			return "Não é possível emitir o saque";
		} else {
			notas10 -= qntNotas10;
			notas20 -= qntNotas20;
			notas50 -= qntNotas50;
			notas100 -= qntNotas100;
			return "Notas de 10: " + qntNotas10 + "/ notas de 20: " + qntNotas20 + "/ notas de 50: " + qntNotas50 + "/ notas de 100: " + qntNotas100;
		}
	}
}
