package br.ufsc.br.etec.saas.selecao.bolsista.modelo;

import java.util.ArrayList;
import java.util.List;

public class Modelo {

	private List<Nota> notasDisponiveis;
	private EstrategiaSaque estrategiaSaque;

	public Modelo() {
		notasDisponiveis = new ArrayList<Nota>();
		estrategiaSaque = new EstrategiaSaque(notasDisponiveis);
	}

	public void criarNotas(String valorNota) {
		Nota novaNota = new Nota(valorNota);
		notasDisponiveis.add(novaNota);
	}

	public void registrarDepositoNota(String valorNota, int novaQuantidade) throws Exception {
		for (Nota nota : notasDisponiveis)
			if (nota.getValorNota() == valorNota) {
				nota.setQuantidadeNotas(novaQuantidade);
				return;
			}
		throw new Exception();
	}

	public int getQuantidadeNotas(String string) throws Exception {
		for (Nota nota : notasDisponiveis)
			if (nota.getValorNota() == string)
				return nota.getQuantidadeDisponivel();
		throw new Exception();
	}

	public boolean aprovarSaque(String valorNota) {
		return estrategiaSaque.verificaDisponibilidadeNotas(valorNota);
	}

	public String getNotasLiberadas() {
		return estrategiaSaque.valoresLiberados();
	}
}
