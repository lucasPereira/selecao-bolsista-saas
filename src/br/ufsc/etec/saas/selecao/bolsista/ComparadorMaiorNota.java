package br.ufsc.etec.saas.selecao.bolsista;

import java.util.Comparator;

public class ComparadorMaiorNota implements Comparator<NotaQuantidade> {

	@Override
	public int compare(NotaQuantidade primeiro, NotaQuantidade segundo) {
		return segundo.obterNota().obterValor() - primeiro.obterNota().obterValor();
	}

}
