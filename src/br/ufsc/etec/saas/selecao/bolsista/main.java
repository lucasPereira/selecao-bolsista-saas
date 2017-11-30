package br.ufsc.etec.saas.selecao.bolsista;

public class main {

	public static void main(String[] args) {
		caixaEletronico ce = new caixaEletronico();
		ce.registraDeposito(100, "10");
		ce.registraDeposito(5, "100");
		ce.registraDeposito(5, "50");
		ce.registraDeposito(4, "20");
		ce.Saque(130);
		ce.Saque(150);
		ce.Saque(160);
		ce.Saque(200);
		ce.Saque(500);
		ce.Saque(50);
	}

}
