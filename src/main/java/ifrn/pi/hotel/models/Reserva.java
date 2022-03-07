package ifrn.pi.hotel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String qtdPessoas;
	private String qtdQuartos;
	private String qtdDias;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

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
