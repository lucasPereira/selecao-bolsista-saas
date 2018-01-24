package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSaque {

	@Test
	public void aprovar() throws Exception {
		Caixa caixa = new Caixa();
		Nota dez = new Nota(10);
		caixa.depositar(dez, 1);
		assertTrue(caixa.sacar(10));
	}

	@Test
	public void rejeitar() throws Exception {
		Caixa caixa = new Caixa();
		assertFalse(caixa.sacar(10));
	}

	@Test
	public void aprovarPrimeiroRejeitarSegundo() throws Exception {
		Caixa caixa = new Caixa();
		Nota dez = new Nota(10);
		caixa.depositar(dez, 1);
		caixa.sacar(10);
		assertFalse(caixa.sacar(10));
	}
}
