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

	@Override
	public String toString() {
		return quantidade + " de " + nota.toString();
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof NotaQuantidade) {
			NotaQuantidade outro = (NotaQuantidade) objeto;
			if(outro.quantidade.equals(quantidade) && outro.nota.equals(nota)) {
				return true;
			}
		}
		return super.equals(objeto);
	}
}
