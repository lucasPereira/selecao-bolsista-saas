package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import java.util.List;

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
		List<NotaQuantidade> notas = saque.obterNotasQuantidade();
		NotaQuantidade umaDeDez = new NotaQuantidade(dez, 1);
		assertTrue(saque.aprovado());
		assertEquals(1, notas.size());
		assertEquals(umaDeDez, notas.get(0));
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

	@Test
	public void duasNotasDeDez() throws Exception {
		caixa.depositar(dez, 2);
		Saque saque = caixa.sacar(20);
		NotaQuantidade duasDeDez = new NotaQuantidade(dez, 2);
		List<NotaQuantidade> notas = saque.obterNotasQuantidade();
		assertTrue(saque.aprovado());
		assertEquals(1, notas.size());
		assertEquals(duasDeDez, notas.get(0));
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void umaDeDezUmaDeVinte() throws Exception {
		Nota vinte = new Nota(20);
		NotaQuantidade umaDeDez = new NotaQuantidade(dez, 1);
		NotaQuantidade umaDeVinte = new NotaQuantidade(vinte, 1);
		caixa.depositar(dez, 1);
		caixa.depositar(vinte, 1);
		Saque saque = caixa.sacar(30);
		List<NotaQuantidade> notas = saque.obterNotasQuantidade();
		assertTrue(saque.aprovado());
		assertEquals(2, notas.size());
		assertEquals(umaDeVinte, notas.get(0));
		assertEquals(umaDeDez, notas.get(1));
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());

	}

	@Test
	public void rejeitarSeNaoTemNotasSuficientes() throws Exception {
		Nota seis = new Nota(6);
		caixa.depositar(seis, 2);
		caixa.depositar(dez, 1);
		Saque saque = caixa.sacar(20);
		assertFalse(saque.aprovado());
		assertEquals(0, saque.obterNotasQuantidade().size());
		assertEquals(22, caixa.calcularQuantidadeTotal().intValue());
	}
}
