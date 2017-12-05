package br.ufsc.etec.saas.selecao.bolsista.testes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.etec.saas.selecao.bolsista.aplicacao.ContabilizacaoDeNotas;
import br.ufsc.etec.saas.selecao.bolsista.aplicacao.NaoHaNotasSuficientes;
import br.ufsc.etec.saas.selecao.bolsista.aplicacao.Nota;
import br.ufsc.etec.saas.selecao.bolsista.aplicacao.TipoDeNota;

public class ContabilizacaoDeNotasTestes {

	private ContabilizacaoDeNotas contabilizacaoDeNotas;

	@Before
	public void setUp() throws Exception
	{
		this.contabilizacaoDeNotas = new ContabilizacaoDeNotas();
	}

	@Test
	public void registarODepositoDe5NotasDe20Reais() throws Exception
	{
		this.depositar5NotasDe20();
		assertEquals(5, contabilizacaoDeNotas.getNotasContabilizadas().size());
		this.veficarNotasDeTipo20();
	}

	@Test(expected = NaoHaNotasSuficientes.class)
	public void sacar20ReaisQuandoExisteSomenteUmaNotaDe10Reais() throws Exception
	{
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_10));
		contabilizacaoDeNotas.informarNotasParaSaque(new Integer(20));
	}

	@Test
	public void verficar20ReaisQuandoExisteUmaNotaDe20Reais() throws Exception
	{
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
		ArrayList<Nota> notasRetiradas = contabilizacaoDeNotas.informarNotasParaSaque(new Integer(20));
		assertEquals(1, notasRetiradas.size());
	}
	
	@Test
	public void verficar180ReaisQuandoExisteNotasDe10De20De50De100Reais() throws Exception
	{
		assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_10)));
		assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20)));
		assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_50)));
		assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_100)));
		
		Integer resultadoEsperado = new Integer(180);
		ArrayList<Nota> notasRetiradas = contabilizacaoDeNotas.informarNotasParaSaque(resultadoEsperado);
		
		assertEquals(4, notasRetiradas.size());
		assertEquals(resultadoEsperado, this.verificarSeAsNotasSomamOValorRequerido(notasRetiradas));
	}

	@Test
	public void aprovaSaqueQuandoNaoHaNotas() throws Exception {
		assertFalse(contabilizacaoDeNotas.aprovarSaque(new Integer(20)));
	}

	@Test(expected = NaoHaNotasSuficientes.class)
	public void sacar20ReaisDepoisDeJaTerSacado20ReaisQuandoSomenteExiste20Reias() throws Exception
	{
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
		contabilizacaoDeNotas.realizarSaque(new Integer(20));
		contabilizacaoDeNotas.realizarSaque(new Integer(20));
	}

	@Test
	public void verficarInformeDeNotasQuandoExistemMuitasNotas() throws Exception
	{
		this.registarEVerificarAsNotas(new Integer(300));
		this.registarEVerificarAsNotas(new Integer(30));
		this.registarEVerificarAsNotas(new Integer(210));
		this.registarEVerificarAsNotas(new Integer(30000));
	}

	@Test(expected = NaoHaNotasSuficientes.class)
	public void verficarRetiradaInvalidaDe1RealQuandoExistemMuitasNotas() throws Exception
	{
		this.registarEVerificarAsNotas(new Integer(1));
	}

	@Test(expected = NaoHaNotasSuficientes.class)
	public void verficarRetiradaInvalidaDe11ReaisQuandoExistemMuitasNotas() throws Exception
	{
		this.registarEVerificarAsNotas(new Integer(11));
	}

	private void registarEVerificarAsNotas(Integer valorRequerido) throws Exception {
		this.criarMuitasNotas();
		ArrayList<Nota> notasRetiradas = contabilizacaoDeNotas.informarNotasParaSaque(valorRequerido);

		Integer valorRetirado = this.verificarSeAsNotasSomamOValorRequerido(notasRetiradas);
		assertEquals(valorRequerido, valorRetirado);
	}

	private Integer verificarSeAsNotasSomamOValorRequerido(ArrayList<Nota> notasRetiradas)
	{
		Integer valorRetirado = new Integer(0);

		for (Nota notaRetirada : notasRetiradas)
		{
			valorRetirado += notaRetirada.obterValor();
		}

		return valorRetirado;
	}

	private void criarMuitasNotas() throws Exception
	{
		for (int i = 0; i < 1000; i++)
		{
			assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_10)));
			assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20)));
			assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_50)));
			assertTrue(contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_100)));
		}
	}

	private void depositar5NotasDe20() throws Exception
	{
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
		contabilizacaoDeNotas.depositarNota(new Nota(TipoDeNota.NOTA_DE_20));
	}

	private void veficarNotasDeTipo20()
	{
		assertEquals(TipoDeNota.NOTA_DE_20, contabilizacaoDeNotas.getNotasContabilizadas().get(0).obterNota());
		assertEquals(TipoDeNota.NOTA_DE_20, contabilizacaoDeNotas.getNotasContabilizadas().get(1).obterNota());
		assertEquals(TipoDeNota.NOTA_DE_20, contabilizacaoDeNotas.getNotasContabilizadas().get(2).obterNota());
		assertEquals(TipoDeNota.NOTA_DE_20, contabilizacaoDeNotas.getNotasContabilizadas().get(3).obterNota());
		assertEquals(TipoDeNota.NOTA_DE_20, contabilizacaoDeNotas.getNotasContabilizadas().get(4).obterNota());
	}
}
