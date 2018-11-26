package br.senai.sp.cfp127.model;

public class Compromisso {

	private int codCompromisso;
	private Usuario usuario;
	private String tituloCompromisso;
	private String dataCompromisso;
	private String horaInicio;
	private String horaFim;
	private String descri��oCompromisso;
	private int nivelPrioridade;
	private int status;

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

	public String getDescri��oCompromisso() {
		return descri��oCompromisso;
	}

	public void setDescri��oCompromisso(String descri��oCompromisso) {
		this.descri��oCompromisso = descri��oCompromisso;
	}

	public int getNivelPrioridade() {
		return nivelPrioridade;
	}

	public void setNivelPrioridade(int nivelPrioridade) {
		this.nivelPrioridade = nivelPrioridade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
