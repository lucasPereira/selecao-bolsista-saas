package br.ufsc.br.etec.saas.selecao.bolsista.modelo;

import java.util.List;

public class EstrategiaSaque {

	private List<Nota> notasDisponiveis;
	private String valoresLiberados;

	public EstrategiaSaque(List<Nota> notasDisponiveis) {
		this.notasDisponiveis = notasDisponiveis;
	}

	public boolean verificaDisponibilidadeNotas(String valorNota) {
		// Algumas estrategias para saque

		// 1ª Caso exista uma nota igual
		for (Nota nota : notasDisponiveis) {
			if (nota.getValorNota() == valorNota && nota.getQuantidadeDisponivel() != 0) {
				valoresLiberados = valorNota + " 1";
				return true;
			}
		}

		// 2ª Combinação de outras notas
		switch (valorNota) {
			case "70":
				for (Nota nota : notasDisponiveis) {
					if (nota.getValorNota() == "50" && nota.getQuantidadeDisponivel() == 0)
						return false;
					else
						valoresLiberados += nota.getValorNota() + " " + nota.getQuantidadeDisponivel();

					if (nota.getValorNota() == "20" && nota.getQuantidadeDisponivel() == 0)
						return false;
					else
						valoresLiberados += nota.getValorNota() + " " + nota.getQuantidadeDisponivel();
				}
			case "60":
				for (Nota nota : notasDisponiveis) {
					if (nota.getValorNota() == "20" && nota.getQuantidadeDisponivel() < 3)
						return false;
					else
						valoresLiberados = nota.getValorNota() + " " + nota.getQuantidadeDisponivel();
				}
			default:
				return false;
		}
	}

	public String valoresLiberados() {
		return valoresLiberados;
	}

}
