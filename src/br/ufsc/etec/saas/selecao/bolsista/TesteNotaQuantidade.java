package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteNotaQuantidade {

	@Test
	public void umaNotaDeDez() throws Exception {
		NotaQuantidade umaNotaDeDez = new NotaQuantidade(new Nota(10),1);
		assertEquals(1, umaNotaDeDez.obterQuantidade().intValue());
		assertEquals(new Nota(10), umaNotaDeDez.obterNota());
	}

}
