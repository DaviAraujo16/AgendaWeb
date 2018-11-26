package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;

public class CompromissoDao {

	private Compromisso compromisso;
	private PreparedStatement stm;
	private ResultSet rs;
	
	public ArrayList<Compromisso> getCompromissos ( int codUsuario){
		ArrayList<Compromisso> compromissos = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_compromisso WHERE cod_usuario = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			rs = stm.executeQuery();
			
			//Enquanto tiver uma procima linha no resultado da consulta ao banco criar um contato
			while(rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTituloCompromisso(rs.getString("titulo"));
				this.compromisso.setDataCompromisso(rs.getString("data"));
				this.compromisso.setNivelPrioridade(rs.getInt("prioridade"));
				compromissos.add(this.compromisso);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return compromissos;
	}
	
	public Compromisso getCompromisso( int codContato){
		
		String sql = "SELECT * FROM tbl_compromisso WHERE cod_contato = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codContato);
			rs = stm.executeQuery();
			
			//Enquanto tiver uma procima linha no resultado da consulta ao banco criar um contato
			if(rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTituloCompromisso(rs.getString("titulo"));
				this.compromisso.setDataCompromisso(rs.getString("data"));
				this.compromisso.setHoraInicio(rs.getString("horaInicio"));;
				this.compromisso.setHoraFim(rs.getString("horaFim"));
				this.compromisso.setDescri��oCompromisso(rs.getString("descricao"));
				this.compromisso.setNivelPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return compromisso;
		
	}
	
	public boolean gravar(Compromisso compromisso) {
		
		String sql = "INSERT INTO tbl_compromisso (cod_usuario, titulo, data, status, horaInicio, horaFim, descricao, prioridade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1,compromisso.getUsuario().getCod());
			stm.setString(2,compromisso.getTituloCompromisso());
			stm.setString(3,compromisso.getTituloCompromisso());
			stm.setString(4,compromisso.getDataCompromisso());
			stm.setInt(5,compromisso.getStatus());
			stm.setString(6,compromisso.getHoraInicio());
			stm.setString(7,compromisso.getHoraFim());
			stm.setString(8,compromisso.getDescri��oCompromisso());
			stm.setInt(9,compromisso.getNivelPrioridade());
			stm.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
