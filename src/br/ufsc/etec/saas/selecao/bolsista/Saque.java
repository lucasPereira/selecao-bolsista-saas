package br.ufsc.etec.saas.selecao.bolsista;

import java.util.LinkedList;
import java.util.List;

public class Saque {

	private List<NotaQuantidade> notasQuantidade;

	public Saque() {
		notasQuantidade = new LinkedList<>();
	}

	public Boolean aprovado() {
		if (notasQuantidade.isEmpty()) {
			return false;
		}
		return true;
	}

	public List<NotaQuantidade> obterNotasQuantidade() {
		return notasQuantidade;
	}

	public void adicionar(Nota nota, Integer quantidade) {
		NotaQuantidade notaQuantidade = new NotaQuantidade(nota, quantidade);
		notasQuantidade.add(notaQuantidade);
	}
}