#include <stdio.h>
#include <string.h>
#include <math.h>

#define TRUE 1 

struct notas

{
	int nota10;
	int nota20;
	int nota50;
	int nota100;

	int saldo;
};

struct notas deposito(struct notas *Notas)

{
	Notas->nota10 = 0;
	Notas->nota20 = 0;
	Notas->nota50 = 0;
	Notas->nota100 = 0;
	
		printf("\nCedulas de 10: ");
		scanf("%d",&Notas->nota10);
		printf("\nCedulas de 20: ");
		scanf("%d",&Notas->nota20);
		printf("\nCedulas de 50: ");
		scanf("%d",&Notas->nota50);
		printf("\nCedulas de 100: ");
		scanf("%d",&Notas->nota100);
		
	//Calcula o valor atual na conta:
		Notas->saldo = ((Notas->nota10)*10)+((Notas->nota20)*20)+((Notas->nota50)*50)+((Notas->nota100)*100);

	return *Notas; 

}

struct notas saque(struct notas *Notas){

	int saque = 0;	
	int aux = 0;	
	
	printf("Valor a ser sacado: ");
	scanf("%d",&saque);
		

	int conta10 = 0;
	int conta20 = 0;
	int conta50 = 0;
	int conta100 = 0;
	int saldo = 0;

	int usado10 = 0;
	int usado20 = 0;
	int usado50 = 0;
	int usado100 = 0;

	conta10 = Notas->nota10;
	conta20 = Notas->nota20;
	conta50 = Notas->nota50;
	conta100 = Notas->nota100;
	saldo = Notas->saldo;	

		if (Notas->saldo < saque)
			{
			   printf("\nSaldo insuficiente para a operacao de saque!!!");
			   return;
			}	
		if (saldo >= saque)
			{
			  aux = saque;  
				while (aux > 0){
				
				if ( (aux >= 100) && (conta100 > 0))
					{
					  conta100--;
					  usado100++;
					  aux = aux - 100;
					}
				if ((aux>=100) && (conta50 > 0))
					{
					  conta50--;
					  usado50++;
					  aux = aux - 50;
					}
				if ((aux>=100) && (conta20 > 0))
					{
					  conta20--;
					  usado20++;
					  aux = aux - 20;
					}
				if ((aux>=100) && (conta10 > 0))
					{
					  conta10--;
					  usado10++;
					  aux = aux - 10;
					}
				
				if ( (aux < 100) && (conta100 > 0))
					{
					  conta100--;
					  usado100++;
					  aux = aux - 100;
					}
				if ((aux < 100) && (conta50 > 0))
					{
					  conta50--;
					  usado50++;
					  aux = aux - 50;
					}
				if ((aux < 100) && (conta20 > 0))
					{
					  conta20--;
					  usado20++;
					  aux = aux - 20;
					}
				if ((aux < 100) && (conta10 > 0))
					{
					  conta10--;
					  usado10++;
					  aux = aux - 10;
					}
				}
		Notas->saldo = Notas->saldo - saque;
		printf("\nNotas foram: ");
		printf("\nNotas de 10 sacadas: %d", usado10);
		printf("\nNotas de 20 sacadas: %d", usado20);
		printf("\nNotas de 50 sacadas: %d", usado50);
		printf("\nNotas de 100 sacadas: %d", usado100);		
	}

}

struct notas saldo(struct notas *Notas){	
	printf(" \nSaldo eh: %d ",Notas->saldo);
	return *Notas; 
}


int main(){
		struct notas Notas;
		struct notas *NotasPtr;
		NotasPtr = &Notas;
		
		int somaDinheiro = 0;
		int opcao = 0;

			Notas.nota10 = 0;
			Notas.nota20 = 0;
			Notas.nota50 = 0;
			Notas.nota100 = 0;
			Notas.saldo = 0;		
	  while(TRUE){
			printf("\nOperacao a ser executada(1 - deposito, 2 - saque,3 - mostra o saldo) ");
			scanf("%d",&opcao);
		
				if (opcao == 1){
				    deposito(NotasPtr);
				}
				if (opcao == 2){
				    saque(NotasPtr);
				}
				if (opcao == 3){
				    saldo(NotasPtr);
				}
			}	
		return 0;		
	}
