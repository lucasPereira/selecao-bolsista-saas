package br.ufsc.etec.saas.selecao.bolsista;

import java.util.Comparator;

public class ComparadorMaiorQuantidade implements Comparator<NotaQuantidade> {

	@Override
	public int compare(NotaQuantidade primeiro, NotaQuantidade segundo) {
		return segundo.obterQuantidade() - primeiro.obterQuantidade();
	}

}
