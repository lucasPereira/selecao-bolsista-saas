package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TesteComparadorPorNota {

	@Test
	public void ordenarDoisElementos() throws Exception {
		NotaQuantidade duasDeDez = new NotaQuantidade(new Nota(10), 2);
		NotaQuantidade umaDeVinte = new NotaQuantidade(new Nota(20), 1);
		List<NotaQuantidade> listaOrdenada = new LinkedList<NotaQuantidade>();
		listaOrdenada.add(duasDeDez);
		listaOrdenada.add(umaDeVinte);
		Comparator<NotaQuantidade> comparador = new ComparadorPorNota();
		Collections.sort(listaOrdenada, comparador);
		assertEquals(umaDeVinte, listaOrdenada.get(0));
		assertEquals(duasDeDez, listaOrdenada.get(1));
	}
}
