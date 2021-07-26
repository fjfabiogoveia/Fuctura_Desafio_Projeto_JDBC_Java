package Model;

public class Cliente {
	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String ano_Nascimento;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getAnoNasci() {
		return ano_Nascimento;
	}
	public void setAnoNasci(String anoNasci) {
		this.ano_Nascimento = anoNasci;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", anoNasci=" + ano_Nascimento
				+ "]";
	}
}
