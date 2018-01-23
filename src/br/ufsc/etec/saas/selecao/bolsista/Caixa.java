package br.ufsc.etec.saas.selecao.bolsista;

public class Caixa {
    
	private Integer quantidadeDeNotas;
	private Integer quantidadeTotal;
	
	public Caixa() {
		// TODO Auto-generated constructor stub
		quantidadeDeNotas = 0;
		quantidadeTotal = 0;
	}

	public Integer obterQuantidadeDeNotas() {
		// TODO Auto-generated method stub
		return quantidadeDeNotas;
	}

	public Integer calcularQuantidadeTotal() {
		// TODO Auto-generated method stub
		return quantidadeTotal;
	}

	public void depositarNotaDez(int i) {
		// TODO Auto-generated method stub
		quantidadeDeNotas = 1;
		quantidadeTotal = 10;
	}

}
