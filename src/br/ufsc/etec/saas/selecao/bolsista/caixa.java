package br.ufsc.etec.saas.selecao.bolsista;

class caixa {

	private int n10, n20, n50, n100;

	caixa() { // construtor
	}

	caixa(int nt10, int nt20, int nt50, int nt100) { // construtor
		this.setN10(nt10);
		this.setN20(nt20);
		this.setN50(nt50);
		this.setN100(nt100);
	}

	public void valoremcx() {
		int valortotal = (getN10() * 10) + (getN20() * 20) + (getN50() * 50) + (getN100() * 100);
		System.out.println("Notas de 100: " + getN100() + " Notas de 50: " + getN50() + " Notas de 20: " + getN20() + " Notas de 10: " + getN10());
		System.out.println("valor total: " + valortotal);
	}

	// setter
	public void setN10(int n) {
		this.n10 = n;
	}

	public void setN20(int n) {
		this.n20 = n;
	}

	public void setN50(int n) {
		this.n50 = n;
	}

	public void setN100(int n) {
		this.n100 = n;
	}

	public int getN10() {
		return this.n10;
	}

	public int getN20() {
		return this.n20;
	}

	public int getN50() {
		return this.n50;
	}

	public int getN100() {
		return this.n100;
	}

}
