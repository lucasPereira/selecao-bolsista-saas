package br.ufsc.etec.saas.selecao.bolsista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Caixa {

	private Map<Nota, Integer> notas;

	public Caixa() {
		notas = new HashMap<>();
	}

	public Integer obterQuantidadeDeNotas() {
		Integer quantidade = 0;
		for (Map.Entry<Nota, Integer> quantidadePorNota : notas.entrySet()) {
			Integer quantidadeDeNotas = quantidadePorNota.getValue();
			quantidade += quantidadeDeNotas;
		}
		return quantidade;
	}

	public Integer calcularQuantidadeTotal() {
		Integer quantidade = 0;
		for (Map.Entry<Nota, Integer> quantidadePorNota : notas.entrySet()) {
			Integer quantidadeDeNotas = quantidadePorNota.getValue();
			Integer valorDaNota = quantidadePorNota.getKey().obterValor();
			quantidade += quantidadeDeNotas * valorDaNota;
		}
		return quantidade;
	}

	public void depositar(Nota nota, Integer quantidade) {
		if (notas.containsKey(nota)) {
			notas.put(nota, notas.get(nota) + quantidade);
		} else {
			notas.put(nota, quantidade);
		}
	}

	public Integer contarNotas(Nota nota) {
		if (notas.containsKey(nota)) {
			return notas.get(nota);
		}
		return 0;
	}

	public Saque sacar(Integer valor) {
		Saque saque = new Saque();
		if (calcularQuantidadeTotal() < valor) {
			return saque;
		}
		List<NotaQuantidade> notasOrdenadas = obterNotasOrdenadas();
		Integer valorRestante = valor;
		for (NotaQuantidade notaQuantidade : notasOrdenadas) {
			Nota notaAtual = notaQuantidade.obterNota();
			Integer valorNotaAtual = notaAtual.obterValor();
			Integer quantidadeNotaAtual = notaQuantidade.obterQuantidade();
			if (valorNotaAtual <= valorRestante && quantidadeNotaAtual > 0) {
				Integer quantidade = valorRestante / valorNotaAtual;
				if (quantidade > quantidadeNotaAtual) {
					quantidade = quantidadeNotaAtual;
				}
				saque.adicionar(notaAtual, quantidade);
				valorRestante -= quantidade * valorNotaAtual;
			}
		}
		if (valorRestante == 0) {
			for (NotaQuantidade notaQuantidade : saque.obterNotasQuantidade()) {
				Nota notaAtual = notaQuantidade.obterNota();
				Integer quantidade = notaQuantidade.obterQuantidade();
				Integer quantidadeNotaAtual = notas.get(notaAtual);
				notas.put(notaAtual, quantidadeNotaAtual - quantidade);
			}
			return saque;
		}
		return new Saque();
	}

	private List<NotaQuantidade> obterNotasOrdenadas() {
		List<NotaQuantidade> notasOrdenadas = new LinkedList<>();
		for (Map.Entry<Nota, Integer> parNotaQuantidade : notas.entrySet()) {
			Nota nota = parNotaQuantidade.getKey();
			Integer quantidade = parNotaQuantidade.getValue();
			NotaQuantidade notaQuantidade = new NotaQuantidade(nota, quantidade);
			notasOrdenadas.add(notaQuantidade);
		}
		Comparator<NotaQuantidade> comparador = new ComparadorPorNota();
		Collections.sort(notasOrdenadas, comparador);
		return notasOrdenadas;
	}

}
