package br.ufsc.etec.saas.selecao.bolsista;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExemploDeTeste {

	@Test
	public void testar() throws Exception {
		Sistema s = new Sistema();
		s.depositar(new Nota(10), 10);
		s.depositar(new Nota(20), 10);
		s.depositar(new Nota(50), 5);
		s.depositar(new Nota(100), 4);
		
		System.out.println(s.sacar(880));
	}

}
