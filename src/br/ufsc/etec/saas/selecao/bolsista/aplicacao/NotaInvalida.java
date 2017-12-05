package br.ufsc.etec.saas.selecao.bolsista.aplicacao;

public class NotaInvalida extends Exception {

	private static final long serialVersionUID = -7936408496219417457L;

	public NotaInvalida() {
		super("A nota fornecida não pode ser null");
	}
}
