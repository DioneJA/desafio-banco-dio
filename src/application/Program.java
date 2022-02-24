package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Banco;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import entities.Contas;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Contas c;// Instanciando uma conta
		Banco b = new Banco();// Instanciando um banco
		char verificador;// Verificador para continuar ou interromper
		int contadorCorrente = 1;// Contador de contas correntes
		int ContadorPoupanca = 1;// Contador de contas poupancas
		do {
			// Menu de escolha
			System.out.print("Cadastro de conta: \n(1) - Conta Corrente\n(2) - Conta Poupanca\n>> ");
			int escolha = sc.nextInt();
			if (escolha == 1) {
				// Cadastro de conta corrente
				System.out.println("\nConta Corrente" + " #" + contadorCorrente++);
				System.out.print("Digite o cliente: ");
				sc.nextLine();
				String cliente = sc.nextLine();
				System.out.print("Digite a conta: ");
				int conta = sc.nextInt();
				System.out.print("Digite a agencia: ");
				int agencia = sc.nextInt();
				System.out.print("Digite o saldo: R$");
				double saldo = sc.nextDouble();
				c = new ContaCorrente(cliente, conta, saldo, agencia);// Polimorfismo
			} else {
				// Cadastro de conta Poupanca
				System.out.println("\nConta Poupanca" + " #" + ContadorPoupanca++);
				System.out.print("Digite o cliente: ");
				sc.nextLine();
				String cliente = sc.nextLine();
				System.out.print("Digite a conta: ");
				int conta = sc.nextInt();
				System.out.print("Digite a agencia: ");
				int agencia = sc.nextInt();
				System.out.print("Digite o saldo: R$");
				double saldo = sc.nextDouble();
				c = new ContaPoupanca(cliente, conta, saldo, agencia);// Polimorfismo
			}
			// Realizando a operacao de deposito
			System.out.print("\nDeseja realizar um deposito (s/n)?");
			char deposito = sc.next().charAt(0);
			if (deposito == 's') {
				System.out.println("\n\t------ Deposito ------");
				System.out.print("\tDigite a quantia a ser depositada: R$");
				double quantia = sc.nextDouble();
				c.deposito(quantia);
			}
			// Realizando a operacao de saque
			System.out.print("\nDeseja realizar um saque (s/n)?");
			char saque = sc.next().charAt(0);
			if (saque == 's') {
				System.out.println("\n\t------ Saque ------");
				System.out.print("\tDigite a quantia a ser sacada: R$");
				double quantia = sc.nextDouble();
				c.saque(quantia);
			}
			// Adicionando a conta na lista BANCO
			b.addConta(c);

			System.out.print("\nDeseja cadastrar outra conta (s/n)? ");
			verificador = sc.next().charAt(0);
			System.out.println();
		} while (verificador == 's');

		b.imprime();// Imprimindo a lista de contas dentro do banco
		// Realizando operacao de transferencia
		System.out.print("\nDeseja fazer transferencia entre contas (s/n)? ");
		char transferencia = sc.next().charAt(0);
		if (transferencia == 's') {
			System.out.println("\t------ Transferencia ------");
			System.out.print("\tDigite a conta de origem: ");
			int contaO = sc.nextInt();
			System.out.print("\tDigite a conta de destino: ");
			int contaD = sc.nextInt();
			System.out.print("\tDigite o valor: R$");
			double valor = sc.nextDouble();
			if (b.transferencia(contaO, contaD, valor) == 1) {//Funcao de transferencia
				System.out.println("UPDATE: ");
				b.imprime();
			}
		}
		System.out.println("\n\nFIM DO PROGRAMA!");
		sc.close();
	}

}
