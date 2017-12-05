/**
 * 
 */
package br.ufsc.etec.saas.selecao.bolsista.aplicacao;

import br.ufsc.etec.saas.selecao.bolsista.aplicacao.TipoDeNota;

import java.util.ArrayList;

import javax.naming.NameAlreadyBoundException;

/**
 * @author shiva
 *
 */
public class ContabilizacaoDeNotas
{

	private Integer valorTotalArmazenado;
	private ArrayList<Nota> notasDe10;
	private ArrayList<Nota> notasDe20;
	private ArrayList<Nota> notasDe50;
	private ArrayList<Nota> notasDe100;

	public ContabilizacaoDeNotas()
	{
		this.valorTotalArmazenado = new Integer(0);

		this.notasDe10 = new ArrayList<Nota>();
		this.notasDe20 = new ArrayList<Nota>();
		this.notasDe50 = new ArrayList<Nota>();
		this.notasDe100 = new ArrayList<Nota>();
	}

	public ArrayList<Nota> getNotasContabilizadas()
	{
		return notasDe20;
	}

	public Boolean depositarNota(Nota nota)
	{
		TipoDeNota tipoDeNota = nota.obterNota();

		if (tipoDeNota == TipoDeNota.NOTA_DE_10)
		{
			this.valorTotalArmazenado += new Integer(10);
			return new Boolean(this.notasDe10.add(nota));
		}

		if (tipoDeNota == TipoDeNota.NOTA_DE_20)
		{
			this.valorTotalArmazenado += new Integer(20);
			return new Boolean(this.notasDe20.add(nota));
		}

		if (tipoDeNota == TipoDeNota.NOTA_DE_50)
		{
			this.valorTotalArmazenado += new Integer(50);
			return new Boolean(this.notasDe50.add(nota));
		}

		if (tipoDeNota == TipoDeNota.NOTA_DE_100)
		{
			this.valorTotalArmazenado += new Integer(100);
			return new Boolean(this.notasDe100.add(nota));
		}

		return new Boolean(false);
	}

	public ArrayList<Nota> informarNotasParaSaque(Integer valorDoSaque) throws NaoHaNotasSuficientes
	{
		if (valorDoSaque > this.valorTotalArmazenado)
		{
			throw new NaoHaNotasSuficientes(this, valorDoSaque, this.valorTotalArmazenado);
		}

		ArrayList<Nota> notasRetiradas = new ArrayList<Nota>();
		Integer valorRetirado = new Integer(0);

		ArrayList notasArmazenadas[] = new ArrayList[]{ notasDe100, notasDe50, notasDe20, notasDe10 };
		valorRetirado = buscarNotas(valorDoSaque, notasRetiradas, valorRetirado, notasArmazenadas);

		if (!valorRetirado.equals(valorDoSaque))
		{
			throw new NaoHaNotasSuficientes(this, valorDoSaque, valorRetirado);
		}

		return notasRetiradas;
	}

	public void realizarSaque(Integer valorDoSaque) throws NaoHaNotasSuficientes
	{
		ArrayList<Nota> notasRetiradas = informarNotasParaSaque(valorDoSaque);
		descontarNotasDoSistema(notasRetiradas);
	}

	public Boolean aprovarSaque(Integer valorDoSaque)
	{
		try
		{
			this.informarNotasParaSaque(valorDoSaque);
		} catch (NaoHaNotasSuficientes excecao)
		{
			return new Boolean(false);
		}

		return new Boolean(true);
	}

	private Integer buscarNotas(Integer valorDoSaque, ArrayList<Nota> notasRetiradas, Integer valorRetirado, ArrayList<Nota>[] notasArmazenadas)
	{
		Integer quantidadeDeNotas;
		Integer valorDaNota;

		for (ArrayList<Nota> armazemDeNota : notasArmazenadas)
		{
			quantidadeDeNotas = armazemDeNota.size();
			// System.out.println( "quantidadeDeNotas: " + quantidadeDeNotas );

			if (quantidadeDeNotas > 0)
			{
				for (Nota nota : armazemDeNota)
				{
					valorDaNota = nota.obterValor();
					// System.out.println( "valorDaNota:   " + valorDaNota );
					// System.out.println( "valorRetirado: " + valorRetirado );
					// System.out.println( "valorDoSaque:  " + valorDoSaque );

					if (valorRetirado + valorDaNota <= valorDoSaque)
					{
						notasRetiradas.add(nota);
						valorRetirado += valorDaNota;
					}
				}
			}
		}

		return valorRetirado;
	}

	private void descontarNotasDoSistema(ArrayList<Nota> notasRetiradas)
	{
		for (Nota notaRetirada : notasRetiradas)
		{
			TipoDeNota nota = notaRetirada.obterNota();
			
			if (nota == TipoDeNota.NOTA_DE_10)
			{
				this.notasDe10.remove(notaRetirada);
			}

			if (nota == TipoDeNota.NOTA_DE_20)
			{
				this.notasDe20.remove(notaRetirada);
			}

			if (nota == TipoDeNota.NOTA_DE_50)
			{
				this.notasDe50.remove(notaRetirada);
			}

			if (nota == TipoDeNota.NOTA_DE_100)
			{
				this.notasDe100.remove(notaRetirada);
			}
		}
	}
}
