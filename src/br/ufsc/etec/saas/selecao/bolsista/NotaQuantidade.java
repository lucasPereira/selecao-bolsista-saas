package br.ufsc.etec.saas.selecao.bolsista;

public class NotaQuantidade {

	private Nota nota;
	private Integer quantidade;

	public NotaQuantidade(Nota nota, Integer quantidade) {
		this.nota = nota;
		this.quantidade = quantidade;
	}

	public Integer obterQuantidade() {
		return quantidade;
	}

	public Nota obterNota() {
		return nota;
	}

}
