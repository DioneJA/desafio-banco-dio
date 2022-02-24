package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	Contas conta;
	public String banco = "Bradesco";
	List<Contas> contas = new ArrayList<>();

	// Constructors
	public Banco() {

	}

	public Banco(Contas conta) {
		this.conta = conta;
	}

	public void addConta(Contas conta) {
		contas.add(conta);
	}

	// Getters and Setters
	public Contas getConta() {
		return conta;
	}

	// Functions
	public int transferencia(int contaO, int contaD, double quantia) {
		int verificador = 0;
		for (Contas x : contas) {
			if (contaO == x.getConta()) {
				for (Contas y : contas) {
					if (contaD == y.getConta()) {
						y.deposito(quantia);
						verificador = 1;
					}
				}
				if (verificador == 1) {
					x.saque(quantia);
					return 1;
				} else {
					System.out.println("\n\nErro! Conta de destino inexistente");
					return 0;
				}
			}
		}
		System.out.println("\n\nErro! Conta de origem inexistente");
		return 0;
	}

	public void imprime() {
		for (Contas x : contas) {
			System.out.println("\n\t------ Banco " + banco + " ------\n" + x);
		}
	}
}
