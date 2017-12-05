package br.ufsc.etec.saas.selecao.bolsista.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.etec.saas.selecao.bolsista.aplicacao.NotaInvalida;
import br.ufsc.etec.saas.selecao.bolsista.aplicacao.Nota;
import br.ufsc.etec.saas.selecao.bolsista.aplicacao.TipoDeNota;

public class NotaTestes {

	private Nota nota;
	
	@Test
	public void criarNotaDe10Reais() throws Exception {
		nota = new Nota(TipoDeNota.NOTA_DE_10);
		assertEquals(TipoDeNota.NOTA_DE_10, nota.obterValor());
	}
	
	@Test
	public void criarNotaDe20Reais() throws Exception {
		nota = new Nota(TipoDeNota.NOTA_DE_20);
		assertEquals(TipoDeNota.NOTA_DE_20, nota.obterValor());
	}
	
	@Test
	public void criarNotaDe50Reais() throws Exception {
		nota = new Nota(TipoDeNota.NOTA_DE_50);
		assertEquals(TipoDeNota.NOTA_DE_50, nota.obterValor());
	}
	
	@Test
	public void criarNotaDe100Reais() throws Exception {
		nota = new Nota(TipoDeNota.NOTA_DE_100);
		assertEquals(TipoDeNota.NOTA_DE_100, nota.obterValor());
	}

	@Test(expected = NotaInvalida.class)
	public void notaInvalidaRegistrada() throws Exception {
		nota = new Nota(null);
	}

}
