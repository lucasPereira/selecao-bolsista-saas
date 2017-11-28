package br.ufsc.etec.saas.selecao.bolsista.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.br.etec.saas.selecao.bolsista.modelo.Modelo;

public class OperacaoCaixaEletronico {

	private Modelo modelo;

	@Before
	public void setup() {
		modelo = new Modelo();
		modelo.criarNotas("20");
	}

	@Test
	public void registrarDeposito() throws Exception {
		modelo.criarNotas("50");
		modelo.registrarDepositoNota("20", 5);

		assertEquals(5, modelo.getQuantidadeNotas("20"));
	}

	@Test(expected = Exception.class)
	public void registrarDepositoInvalido() throws Exception {
		modelo.registrarDepositoNota("2", 5);

		assertEquals(5, modelo.getQuantidadeNotas("20"));
	}

	@Test
	public void aprovarSaque() throws Exception {
		modelo.registrarDepositoNota("20", 5);

		assertTrue(modelo.aprovarSaque("20"));
	}

	@Test
	public void reprovarSaque() throws Exception {
		modelo.registrarDepositoNota("20", 5);

		assertFalse(modelo.aprovarSaque("70"));
	}

	@Test
	public void notasLiberadas() throws Exception {
		modelo.registrarDepositoNota("20", 5);
		modelo.aprovarSaque("20");

		assertEquals("20 1", modelo.getNotasLiberadas());
	}
}
