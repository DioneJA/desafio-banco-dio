package entities;

public class ContaPoupanca extends Contas {
	protected int agencia;
	public int taxa = 5;

	// Constructors
	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(String cliente, int conta, double saldo, int agencia) {
		super(cliente, conta, saldo);
		this.agencia = agencia;
	}

	// Getters and Setters
	public int getAgencia() {
		return agencia;
	}

	// Functions
	@Override
	public void saque(double quantia) {
		this.saldo -= quantia + taxa;
	}

	// toString
	@Override
	public String toString() {
		return "\tTipo de conta: Poupanca" + "\n\tNome: " + cliente + "\n\tAgencia: " + agencia + "\n\tConta: " + conta
				+ "\n\tSaldo: R$" + String.format("%.2f", saldo);
	}

}
