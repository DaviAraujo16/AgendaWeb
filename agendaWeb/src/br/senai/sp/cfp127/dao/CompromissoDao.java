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

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public ArrayList<Compromisso> getCompromissos(int codUsuario , int status) {
		ArrayList<Compromisso> compromissos = new ArrayList<>();

		String sql = "SELECT * FROM tbl_compromisso WHERE cod_usuario = ? AND status = ?";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			stm.setInt(2, status);
			rs = stm.executeQuery();

			// Enquanto tiver uma procima linha no resultado da consulta ao banco criar um
			// contato
			while (rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTituloCompromisso(rs.getString("titulo"));
				this.compromisso.setDataCompromisso(rs.getString("data"));
				this.compromisso.setNivelPrioridade(rs.getInt("prioridade"));
				compromissos.add(this.compromisso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fecharConexao();
		}

		return compromissos;
	}

	public ArrayList<Compromisso> getDescricao (int codUsuario , int status) {
		ArrayList<Compromisso> compromissos = new ArrayList<>();

		String sql = "SELECT * FROM tbl_compromisso  WHERE cod_usuario = ? AND status = ? ORDER BY data LIMIT 3";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			stm.setInt(2, status);
			rs = stm.executeQuery();

			// Enquanto tiver uma procima linha no resultado da consulta ao banco criar um
			// contato
			while (rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setTituloCompromisso(rs.getString("titulo"));
				this.compromisso.setDataCompromisso(rs.getString("data"));
				this.compromisso.setDescricaoCompromisso(rs.getString("descricao"));
				compromissos.add(this.compromisso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fecharConexao();
		}

		return compromissos;
	}
	public Compromisso getCompromisso(int codCompromisso) {

		String sql = "SELECT * FROM tbl_compromisso WHERE cod_compromisso = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codCompromisso);
			rs = stm.executeQuery();
			// Enquanto tiver uma procima linha no resultado da consulta ao banco criar um
			// contato
			if (rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCodCompromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTituloCompromisso(rs.getString("titulo"));
				this.compromisso.setDataCompromisso(rs.getString("data"));
				this.compromisso.setHoraInicio(rs.getString("horaInicio"));
				this.compromisso.setHoraFim(rs.getString("horaFim"));
				this.compromisso.setDescricaoCompromisso(rs.getString("descricao"));
				this.compromisso.setNivelPrioridade(rs.getInt("prioridade"));
				this.compromisso.setStatus(rs.getInt("status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Conexao.fecharConexao();
		}
		return compromisso;

	}
	
	
	public boolean gravar(Compromisso compromisso) {

		String sql = "INSERT INTO tbl_compromisso (cod_usuario, titulo, data, horaInicio, horaFim, descricao, prioridade, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, compromisso.getUsuario().getCod());
			stm.setString(2, compromisso.getTituloCompromisso());
			stm.setString(3, compromisso.getDataCompromisso());
			stm.setString(4, compromisso.getHoraInicio());
			stm.setString(5, compromisso.getHoraFim());
			stm.setString(6, compromisso.getDescricaoCompromisso());
			stm.setInt(7, compromisso.getNivelPrioridade());
			stm.setInt(8, compromisso.getStatus());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			Conexao.fecharConexao();
		}
	}

	public boolean atualizar(Compromisso compromisso) {

		String sql = "UPDATE tbl_compromisso SET titulo = ?, data = ?, horaInicio = ?, horaFim = ?, descricao = ?, prioridade = ?, status = ? WHERE cod_compromisso = ?";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, compromisso.getTituloCompromisso());
			stm.setString(2, compromisso.getDataCompromisso());
			stm.setString(3, compromisso.getHoraInicio());
			stm.setString(4, compromisso.getHoraFim());
			stm.setString(5, compromisso.getDescricaoCompromisso());
			stm.setInt(6, compromisso.getNivelPrioridade());
			stm.setInt(7, compromisso.getStatus());
			stm.setInt(8,compromisso.getCodCompromisso());
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			Conexao.fecharConexao();
		}
	}
	
	public boolean cancelarCompromisso(int status , int codCompromisso) {

		String sql = "UPDATE tbl_compromisso SET status = ?  WHERE cod_compromisso = ?";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, status);
			stm.setInt(2, codCompromisso);
			stm.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			Conexao.fecharConexao();
		}
	}
	
	

}
