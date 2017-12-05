package br.ufsc.etec.saas.selecao.bolsista.aplicacao;

public class NaoHaNotasSuficientes extends Exception {

	private static final long serialVersionUID = -7936408496219417457L;

	public NaoHaNotasSuficientes(ContabilizacaoDeNotas contabilizacaoDeNotas, Integer valorDoSaque)
	{
		super("Este caixa eletronico não possui notas suficientes para a quantia requerida de "
				+ valorDoSaque + " reais");
	}

	public NaoHaNotasSuficientes(ContabilizacaoDeNotas contabilizacaoDeNotas, Integer valorDoSaque, Integer valorRetirado) {
		super("Este caixa eletronico não possui notas suficientes para a quantia requerida de "
				+ valorDoSaque + ", somente foi encontrado " + valorRetirado + " reais.");
	}
}
