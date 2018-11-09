package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.cfp127.model.Contato;

public class ContatoDao {
	
	//Pegua pojo contato
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;
	
	//Metodo que recebe o codigo do usuario pega todos os contatos do usuario e coloca-os em um array
	public ArrayList<Contato> getContatos( int codUsuario){
		ArrayList<Contato> contatos = new ArrayList<>();
		contatos = null;
		
		String sql = "SELECT * FROM tbl_contato WHERE cod_usuario = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codUsuario);
			rs = stm.executeQuery();
			
			//Enquanto tiver uma procima linha no resultado da consulta ao banco criar um contato
			while(rs.next()) {
				this.contato = new Contato();
				this.contato.setCodContato(rs.getInt("cod_contato"));
				this.contato.setNome(rs.getString("nome"));
				this.contato.setEmail(rs.getString("email"));
				this.contato.setTelefone(rs.getString("telefone"));
				this.contato.setEndereco(rs.getString("endereco"));
				contatos.add(this.contato);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return contatos;
		
	}

}
