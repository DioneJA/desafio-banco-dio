package entities;

public class ContaCorrente extends Contas {
	protected int agencia;
	public int taxa = 10;

	// Constructors
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(String cliente, int conta, double saldo, int agencia) {
		super(cliente, conta, saldo);
		this.agencia = agencia;
	}

	// Getters and Setters
	public int getAgencia() {
		return agencia;
	}

	// Function
	@Override
	public void saque(double quantia) {
		this.saldo -= quantia + taxa;
	}

	// toString
	@Override
	public String toString() {
		return "\tTipo de conta: Corrente" + "\n\tNome: " + cliente + "\n\tAgencia: " + agencia + "\n\tConta: " + conta
				+ "\n\tSaldo: R$" + String.format("%.2f", saldo);
	}

}
