package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TesteSaque {

	@Test
	public void aprovarSaque() throws Exception {
		Caixa caixa = new Caixa();
		Nota dez = new Nota(10);
		caixa.depositar(dez, 1);
		assertTrue(caixa.sacar(10));
	}

}
