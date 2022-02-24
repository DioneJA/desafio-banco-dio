package entities;

public class Contas {
	public String cliente;
	protected int conta;
	protected double saldo;

	// Constructors
	public Contas() {
	}

	public Contas(String cliente, int conta, double saldo) {
		super();
		this.cliente = cliente;
		this.conta = conta;
		this.saldo = saldo;
	}

	// Getters and Setters
	public String getCliente() {
		return cliente;
	}

	public int getConta() {
		return conta;
	}

	public double getSaldo() {
		return saldo;
	}

	// Functions
	public void deposito(double quantia) {
		this.saldo += quantia;
	}

	public void saque(double quantia) {
		this.saldo -= quantia;
	}

	// ToString
	@Override
	public String toString() {
		return "------ Conta ------" + "\n\tNome: " + cliente + "\n\tConta: " + conta + "\n\tSaldo: R$"
				+ String.format("%.2f", saldo);
	}
}
