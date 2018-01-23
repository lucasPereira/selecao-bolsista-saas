package br.ufsc.etec.saas.selecao.bolsista;

public class Caixa {

	private Integer quantidadeDeNotas;
	private Integer quantidadeTotal;

	public Caixa() {
		quantidadeDeNotas = 0;
		quantidadeTotal = 0;
	}

	public Integer obterQuantidadeDeNotas() {
		return quantidadeDeNotas;
	}

	public Integer calcularQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void depositarNotaDez(int quantidadeDepositada) {
		quantidadeDeNotas += quantidadeDepositada;
		quantidadeTotal += quantidadeDepositada * 10;
	}

}
