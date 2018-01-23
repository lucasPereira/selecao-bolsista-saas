package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteDeposito {

	private Caixa caixa;

	@Before
	public void configurar() {
		caixa = new Caixa();
	}

	@Test
	public void semNenhumDeposito() throws Exception {
		assertEquals(0, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void depositarNotaDeDez() throws Exception {
		Nota dez = new Nota(10);
		caixa.depositar(dez, 1);
		assertEquals(1, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(10, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void depositarDuasNotasDeDez() throws Exception {
		Nota dez = new Nota(10);
		caixa.depositar(dez, 2);
		assertEquals(2, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());

	}

	@Test
	public void doisDepositosDeDez() throws Exception {
		Nota dez = new Nota(10);
		caixa.depositar(dez, 1);
		caixa.depositar(dez, 1);
		assertEquals(2, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());
	}

	@Test
	public void umDepositoDeVinte() throws Exception {
		Nota notaDeVinte = new Nota(20);
		caixa.depositar(notaDeVinte, 1);
		assertEquals(1, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());
	}

}
