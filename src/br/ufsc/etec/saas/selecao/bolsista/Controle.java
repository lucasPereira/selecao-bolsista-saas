package br.ufsc.etec.saas.selecao.bolsista;

public class Controle {

	public static void main(String[] args) {
		Caixa c = new Caixa();
		c.registrarNotas10(10);
		c.registrarNotas20(10);
		c.registrarNota100(10);
		c.registrarNotas50(10);

		System.out.println(c.fazerSaque(70));

	}
}
