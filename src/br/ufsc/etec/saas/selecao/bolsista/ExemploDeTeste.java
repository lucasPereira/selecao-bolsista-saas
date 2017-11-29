package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExemploDeTeste {

	@Test
	public void testar() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(10, 20, 40, 5);
		long somaTotal = 10 * caixa.notaDez + 20 * caixa.notaVinte + 50 * caixa.notaCinquenta + 100 * caixa.notaCem;
		assertEquals(somaTotal, caixa.total);
	}
	
	@Test
	public void testarDeposito() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(10, 20, 40, 5);
		long total_inicial = caixa.total;
		caixa.depositarNota(Nota.DEZ, 2);
		caixa.depositarNota(Nota.VINTE, 1);
		caixa.depositarNota(Nota.CINQUENTA,  3);
		caixa.depositarNota(Nota.CEM, 2);
		assertEquals(total_inicial + 2 * 10 + 20 + 3 * 50 + 2 * 100, caixa.total);
	}

	@Test
	public void testarSaque() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(10, 20, 40, 5);
		long total_inicial = caixa.total;
		caixa.realizarSaque(180);
		assertEquals(caixa.total, total_inicial - 180);
	}
	
	@Test
	public void testarSaque2() throws Exception {
		CaixaEletronico caixa = new CaixaEletronico(0, 2, 0, 5);
		boolean resultado = caixa.realizarSaque(30);
		assertEquals(resultado, false);
	}
}
