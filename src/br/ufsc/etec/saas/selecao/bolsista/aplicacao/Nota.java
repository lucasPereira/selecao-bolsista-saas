package br.ufsc.etec.saas.selecao.bolsista.aplicacao;


public class Nota {

	private TipoDeNota valor;
	private Nota() {}

	public Nota(TipoDeNota valor) throws Exception
	{
		if(valor != null)
		{			
			this.valor = valor;
		}
		else
		{
			throw new NotaInvalida();
		}
	}
	
	public TipoDeNota obterNota() {
		return this.valor;
	}

	public Integer obterValor() {
		
		if( this.valor == TipoDeNota.NOTA_DE_10 )
		{
			return new Integer(10);
		}
		
		if( this.valor == TipoDeNota.NOTA_DE_20 )
		{
			return new Integer(20);
		}
		
		if( this.valor == TipoDeNota.NOTA_DE_50 )
		{
			return new Integer(50);
		}
		
		return new Integer(100);
	}
}
