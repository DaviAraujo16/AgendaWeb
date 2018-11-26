package br.senai.sp.cfp127.model;

public class Compromisso {
	
	private int codCompromisso;
	private Usuario usuario;
	private String tituloCompromisso;
	private String dataCompromisso;
	private String horaInicio;
	private String horaFim;
	private String descriçãoCompromisso;
	private String nivelPrioridade;
	private String status;
	public int getCodCompromisso() {
		return codCompromisso;
	}
	public void setCodCompromisso(int codCompromisso) {
		this.codCompromisso = codCompromisso;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTituloCompromisso() {
		return tituloCompromisso;
	}
	public void setTituloCompromisso(String tituloCompromisso) {
		this.tituloCompromisso = tituloCompromisso;
	}
	public String getDataCompromisso() {
		return dataCompromisso;
	}
	public void setDataCompromisso(String dataCompromisso) {
		this.dataCompromisso = dataCompromisso;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	public String getDescriçãoCompromisso() {
		return descriçãoCompromisso;
	}
	public void setDescriçãoCompromisso(String descriçãoCompromisso) {
		this.descriçãoCompromisso = descriçãoCompromisso;
	}
	public String getNivelPrioridade() {
		return nivelPrioridade;
	}
	public void setNivelPrioridade(String nivelPrioridade) {
		this.nivelPrioridade = nivelPrioridade;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
