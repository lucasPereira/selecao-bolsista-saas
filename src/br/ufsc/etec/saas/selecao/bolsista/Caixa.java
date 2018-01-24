package br.ufsc.etec.saas.selecao.bolsista;

import java.util.HashMap;
import java.util.Map;

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

	public Boolean sacar(Integer valor) {

		return true;
	}

}
