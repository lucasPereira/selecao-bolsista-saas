package br.ufsc.etec.saas.selecao.bolsista;

public class cxVitor {

	// caixa cxeletronico;
	public void deposito(caixa cx, int valor, int notas) { // ideialmente usaria passagem por ponteiro
		// setar numero de notas
		switch (valor) {
			case 10:
				cx.setN10(cx.getN10() + notas);
				break;
			case 20:
				cx.setN20(cx.getN20() + notas);
				break;
			case 50:
				cx.setN50(cx.getN50() + notas);
				break;
			case 100:
				cx.setN100(cx.getN100() + notas);
				break;
			default:
				System.out.println("Entrada de valor incompativel");
				break;
		}

	}

	public void saque(caixa cx, int valor) { // ideialmente usaria passagem por ponteiro
		int aux10 = cx.getN10(), aux20 = cx.getN20(), aux50 = cx.getN50(), aux100 = cx.getN100();
		if (cx.getN100() > valor / 100) {
			aux100 = (cx.getN100() - (valor / 100));
			valor -= (valor / 100) * 100;
		}
		if (cx.getN50() > valor / 50) {
			aux50 = (cx.getN50() - (valor / 50));
			valor -= (valor / 50) * 50;
		}
		if (cx.getN20() > valor / 20) {
			aux20 = (cx.getN20() - (valor / 20));
			valor -= (valor / 20) * 20;
		}
		if (cx.getN10() > valor / 10) {
			aux10 = (cx.getN10() - (valor / 10));
			valor -= (valor / 10) * 10;
		}

		if (valor != 0) {
			System.out.println("Saque nao autorizado");
		}
		else {
			cx.setN10(aux10);
			cx.setN20(aux20);
			cx.setN50(aux50);
			cx.setN100(aux100);
		}
	}

	public static void main(String[] args) {
		cxVitor caixa1 = new cxVitor();
		caixa cxeletronico = new caixa(10, 10, 10, 10);
		int auxvalor, auxnumnotas, auxsaque;

		System.out.println("Entre com o valor da nota e numero de notas que deseja depositar");

		// Lê a entrada do sistema;
		auxvalor = 10; // VALOR DA NOTA DEPOSITADA
		auxnumnotas = 10; // QUANTIDADE DE NOTAS DEPOSITADAS
		System.out.println("notas de 10 antes do deposito: " + cxeletronico.getN10());
		caixa1.deposito(cxeletronico, auxvalor, auxnumnotas);
		System.out.println("notas de 10 depois do deposito: " + cxeletronico.getN10());

		System.out.println("Entre com o valor que deseja sacar");
		// Lê a entrada do sistema;
		auxsaque = 585; // ENTRE COM O VALOR A SER SACADO
		cxeletronico.valoremcx();
		caixa1.saque(cxeletronico, auxsaque);
		cxeletronico.valoremcx();
	}
}
