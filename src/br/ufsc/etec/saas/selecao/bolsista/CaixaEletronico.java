package br.ufsc.etec.saas.selecao.bolsista;


public class CaixaEletronico {
	long notaDez, notaVinte, notaCinquenta, notaCem;
	long total;
		
	/**
	 * O contrutor da classe deve receber como argumento a quantidade inicial de notas
	 * 
	 * @param notaDez Notas de R$10,00
	 * @param notaVinte Notas de R$20,00
	 * @param notaCinquenta Notas de R$50,00
	 * @param notaCem Notas de R$100,00
	 */
	public CaixaEletronico(long notaDez, long notaVinte, long notaCinquenta, long notaCem){
		this.notaDez = notaDez;
		this.notaCem = notaCem;
		this.notaVinte = notaVinte;
		this.notaCinquenta = notaCinquenta;
		this.notaCem = notaCem;
		this.total = 10 * notaDez + 20 * notaVinte + 50 * notaCinquenta + 100 * notaCem;
	}
	/**
	 * O contrutor também pode não receber nenhum argumento para começarmos com um caixa vazio
	 */
	public CaixaEletronico(){
		this(0, 0, 0, 0);
	}
	/**
	 *  Deposita uma nota no caixa
	 *  
	 * @param tipo O tipo da nota entre DEZ, VINTE, CINQUENTA e CEM
	 * @param quantidade A quantidade de notas a serem depositadas
	 */
	void depositarNota(Nota tipo, long quantidade){
		switch(tipo){
			case DEZ:
				this.notaDez += quantidade;
				this.total += 10 * quantidade;
				break;
			case VINTE:
				this.notaVinte += quantidade;
				this.total += 20 * quantidade;
				break;
			case CINQUENTA:
				this.notaCinquenta += quantidade;
				this.total += 50 * quantidade;
				break;
			case CEM:
				this.notaCem += quantidade;
				this.total += 100 * quantidade;
				break;
		}
	}
	
	/**
	 * Esta classe representa uma tentativa de saque obtida quando temos um valor
	 * a ser sacado, mas queremos saber se é possível sacá-lo com as notas disponíveis. 
	 * Uma instância dela é contruída dado um valor que desejamos sacar. Seu vetor de 
	 * notas tem sempre quatro elementos e representa quantas notas de dez, vinte, cinquenta
	 *  e cem podemos sacar para formar o valor desejado. Se não for possível sacar o valor
	 * desejado, o montante de dinheiro no vetor de notas será o menor valor mais
	 * próximo possível e o valor no resto terá a diferença.
	 * <p>
	 * Por exemplo, se quisermos sacar 30 e o caixa só tiver duas notas de 20. o vetor
	 * de notas será [0, 1, 0, 0] e o resto será 10.
	 * </p>
	 */
	 class TentativaDeSaque{
		long[] notas;
		long resto;
		public TentativaDeSaque(long quantidade){
			this.notas = new long[4];
			this.notas[3] = Math.min(notaCem, quantidade / 100);
			quantidade -= this.notas[3] * 100;
			this.notas[2] = Math.min(notaCinquenta, quantidade / 50);
			quantidade -= this.notas[2] * 50;
			this.notas[1] = Math.min(notaVinte, quantidade / 20);
			quantidade -= this.notas[1] * 20;
			this.notas[0] = Math.min(notaDez, quantidade / 10);
			quantidade -= this.notas[0] * 10;
			this.resto = quantidade;
		}
	}
	/**
	 * Este método tenta realizar um saque. Para isso ele simula que notas
	 * precisariam ser sacadas para obter o montante necessário. Se for
	 * possível fazer o saque pedido, ele então é feito.
	 * 
	 * @param quantidade Quantos reais deseja-se sacar.
	 * @return Se a operação foi bem-sucedida e o dinheiro sacado.
	 */
	boolean realizarSaque(long quantidade){
		TentativaDeSaque tentativa = new TentativaDeSaque(quantidade);
		if(tentativa.resto != 0 || quantidade > this.total){
			return false;
		}
		this.notaCem -= tentativa.notas[3];
		this.total -= tentativa.notas[3] * 100;
		this.notaCinquenta -= tentativa.notas[2];
		this.total -= tentativa.notas[2] * 50;
		this.notaVinte -= tentativa.notas[1];
		this.total -= tentativa.notas[1] * 20;
		this.notaDez -= tentativa.notas[0];
		this.total -= tentativa.notas[0] * 10;
		return true;
	}
}
