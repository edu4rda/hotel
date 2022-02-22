package ifrn.pi.hotel.models;

public class Reserva {

	private String nome;
	private String qtdPessoas;
	private String qtdQuartos;
	private String qtdDias;

	public String getQtdDias() {
		return qtdDias;
	}

	public void setQtdDias(String qtdDias) {
		this.qtdDias = qtdDias;
	}

	private String pagamento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(String qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}

	public String getQtdQuartos() {
		return qtdQuartos;
	}

	public void setQtdQuartos(String qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

}
