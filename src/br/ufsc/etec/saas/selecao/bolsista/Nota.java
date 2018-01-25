package br.ufsc.etec.saas.selecao.bolsista;

public class Nota {

	private Integer valor;

	public Nota(Integer valor) {
		this.valor = valor;
	}

	public Integer obterValor() {
		return valor;
	}

	@Override
	public boolean equals(Object objeto) {
		if (objeto instanceof Nota) {
			Nota outro = (Nota) objeto;
			return valor.equals(outro.valor);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return valor.hashCode();
	}

	@Override
	public String toString() {
		return "$" + valor.toString();
	}

}
