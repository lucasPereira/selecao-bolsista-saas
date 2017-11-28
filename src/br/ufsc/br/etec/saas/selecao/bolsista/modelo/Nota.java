package br.ufsc.br.etec.saas.selecao.bolsista.modelo;

public class Nota {

	private String valorNota;
	private int qtdNotasDisponiveis;

	public Nota(String valorNota) {
		this.valorNota = valorNota;
	}

	public void setQuantidadeNotas(int novaQuantidade) {
		qtdNotasDisponiveis = novaQuantidade;
	}

	public String getValorNota() {
		return valorNota;
	}

	public int getQuantidadeDisponivel() {
		return qtdNotasDisponiveis;
	}

}
