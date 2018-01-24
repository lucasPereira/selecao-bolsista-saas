package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteSaque {

	@Test
	public void vazio() throws Exception {
		Saque saque = new Saque();
		assertFalse(saque.aprovado());
		assertEquals(0, saque.obterNotasQuantidade().size());
	}

	@Test
	public void aprovado() throws Exception {
		Saque saque = new Saque();
		saque.adicionar(new Nota(10), 1);
		assertTrue(saque.aprovado());
		assertEquals(1, saque.obterNotasQuantidade().size());
		assertEquals(new Nota(10), saque.obterNotasQuantidade().get(0).obterNota());
		assertEquals(1, saque.obterNotasQuantidade().get(0).obterQuantidade().intValue());
	}

}
