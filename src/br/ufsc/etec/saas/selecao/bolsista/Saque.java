package br.ufsc.etec.saas.selecao.bolsista;


public class Saque {
	protected int quantidade;
	protected Nota nota;
	
	public Saque(Nota nota, int quant){
		this.nota = nota;
		this.quantidade = quant;
	}

	
	public int getQuantidade() {
		return quantidade;
	}

	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	public Nota getNota() {
		return nota;
	}

	
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
}
