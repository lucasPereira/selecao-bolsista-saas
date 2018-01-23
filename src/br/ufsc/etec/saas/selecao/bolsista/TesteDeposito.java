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
		assertEquals(0, caixa .obterQuantidadeDeNotas().intValue());
		assertEquals(0, caixa.calcularQuantidadeTotal().intValue());
	}
	
	@Test
	public void depositarNotaDeDez() throws Exception {
		caixa.depositarNotaDez(1);
		assertEquals(1, caixa.obterQuantidadeDeNotas().intValue());
		assertEquals(10, caixa.calcularQuantidadeTotal().intValue());
	}
}
