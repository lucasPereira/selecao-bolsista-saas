package br.ufsc.etec.saas.selecao.bolsista;

public class conta {

	int numnotas10;
	int numnotas20;
	int numnotas50;
	int numnotas100;
	double saldo;
	String notasdisponiveis;

	public void saca(double valorASersacado) {
			if (saldo < valorASersacado) {
			System.out.println("Saldo Insuficiente");
		}	
			else (saldo > valorASersacado) {
			this.saldo -= valorASersacado;
		}
			
	}

	void deposita(int nota) {
		this.saldo += nota;
	}
}
