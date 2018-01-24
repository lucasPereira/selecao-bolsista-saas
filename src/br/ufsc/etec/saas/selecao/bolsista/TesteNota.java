package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteNota {

	@Test
	public void dez() throws Exception {
		Nota dez = new Nota(10);
		assertEquals(10, dez.obterValor().intValue());
	}

	@Test
	public void vinte() throws Exception {
		Nota vinte = new Nota(20);
		assertEquals(20, vinte.obterValor().intValue());
	}

	@Test
	public void igualdade() throws Exception {
		assertEquals(new Nota(10), new Nota(10));
	}
	
	@Test
	public void hash() throws Exception {
		assertEquals(new Nota(10).hashCode(), new Integer(10).hashCode());
	}
}
