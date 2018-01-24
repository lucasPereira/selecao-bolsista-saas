package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteSacar {

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
		Saque saque = caixa.sacar(10);
		assertTrue(saque.aprovado());
		assertEquals(1, saque.obterNotasQuantidade().size());
		assertEquals(1, saque.obterNotasQuantidade().get(0).obterQuantidade().intValue());
		assertEquals(new Nota(10), saque.obterNotasQuantidade().get(0).obterNota());
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void rejeitar() throws Exception {
		Saque saque = caixa.sacar(10);
		assertFalse(saque.aprovado());
		assertEquals(0, saque.obterNotasQuantidade().size());
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void aprovarPrimeiroRejeitarSegundo() throws Exception {
		caixa.depositar(dez, 1);
		caixa.sacar(10);
		Saque segundoSaque = caixa.sacar(10);
		assertFalse(segundoSaque.aprovado());
		assertEquals(0, segundoSaque.obterNotasQuantidade().size());
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void rejeitarSeTemValorMasNaoNota() throws Exception {
		Nota vinte = new Nota(20);
		caixa.depositar(dez, 1);
		caixa.depositar(vinte, 1);
		caixa.sacar(10);
		Saque segundoSaque = caixa.sacar(10);
		assertFalse(segundoSaque.aprovado());
		assertEquals(0, segundoSaque.obterNotasQuantidade().size());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());
	}
}
