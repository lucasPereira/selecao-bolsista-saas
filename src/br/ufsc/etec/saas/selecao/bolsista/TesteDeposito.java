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
		assertEquals(1, caixa.contarNotas(dez).intValue());
	}

	@Test
	public void depositarDuasNotasDeDez() throws Exception {
		Nota dez = new Nota(10);
		caixa.depositar(dez, 2);
		assertEquals(2, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());
		assertEquals(2, caixa.contarNotas(dez).intValue());
	}

	@Test
	public void doisDepositosDeDez() throws Exception {
		Nota dez = new Nota(10);
		caixa.depositar(dez, 1);
		caixa.depositar(dez, 1);
		assertEquals(2, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());
		assertEquals(2, caixa.contarNotas(dez).intValue());
	}
	
	@Test
	public void doisDepositosDeDezComQuantiasDiferentes() throws Exception {
		caixa.depositar(new Nota(10), 1);
		caixa.depositar(new Nota(10), 2);
		assertEquals(3, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(30, caixa.calcularQuantidadeTotal().intValue());
		assertEquals(3, caixa.contarNotas(new Nota(10)).intValue());
	}

	@Test
	public void umDepositoDeVinte() throws Exception {
		Nota vinte = new Nota(20);
		caixa.depositar(vinte, 1);
		assertEquals(1, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(20, caixa.calcularQuantidadeTotal().intValue());
		assertEquals(1, caixa.contarNotas(vinte).intValue());
	}

}
