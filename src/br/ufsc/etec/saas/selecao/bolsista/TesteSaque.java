package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteSaque {

	private Caixa caixa;
	private Nota dez;

	@Before
	public void configurar() {
		caixa = new Caixa();
		dez = new Nota(10);
	}

	@Test
	public void aprovar() throws Exception {
		caixa.depositar(dez, 1);
		assertTrue(caixa.sacar(10));
	}

	@Test
	public void rejeitar() throws Exception {
		assertFalse(caixa.sacar(10));
	}

	@Test
	public void aprovarPrimeiroRejeitarSegundo() throws Exception {
		caixa.depositar(dez, 1);
		caixa.sacar(10);
		assertFalse(caixa.sacar(10));
	}

	@Test
	public void rejeitarSeTemValorMasNaoNota() throws Exception {
		Nota vinte = new Nota(20);
		caixa.depositar(dez, 1);
		caixa.depositar(vinte, 1);
		caixa.sacar(10);
		assertFalse(caixa.sacar(10));
	}
}
