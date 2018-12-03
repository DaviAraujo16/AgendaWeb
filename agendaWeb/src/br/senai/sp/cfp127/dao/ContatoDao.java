package br.senai.sp.cfp127.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

public class ContatoDao {
	
	//Pega pojo contato
	private Contato contato;
	private PreparedStatement stm;
	private ResultSet rs;

	//Metodo que recebe o codigo do usuario pega todos os contatos do usuario e coloca-os em um array
	public ArrayList<Contato> getContatos( int codUsuario){
		ArrayList<Contato> contatos = new ArrayList<>();
		
		String sql = "SELECT * FROM tbl_contato WHERE cod_usuario = ? ORDER BY nome";
		
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
		}finally{
			Conexao.fecharConexao();
		}
		
		return contatos;
		
	}
	
	public boolean gravar(Contato contato) {
		
		String sql = "INSERT INTO tbl_contato (cod_usuario,nome,email,telefone,endereco) VALUES (?,?,?,?,?)";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1,contato.getUsuario().getCod());
			stm.setString(2,contato.getNome());
			stm.setString(3,contato.getEmail());
			stm.setString(4,contato.getTelefone());
			stm.setString(5,contato.getEndereco());
			stm.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			Conexao.fecharConexao();
		}
	}
	
	
	public boolean atualizar(Contato contato) {
		
		String sql = "UPDATE tbl_contato SET nome = ?, email = ?, telefone = ?, endereco = ? WHERE cod_contato = ?";

		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			
			stm.setString(1,contato.getNome());
			stm.setString(2,contato.getEmail());
			stm.setString(3,contato.getTelefone());
			stm.setString(4,contato.getEndereco());
			stm.setInt(5,contato.getCodContato());
			stm.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			Conexao.fecharConexao();
		}
	}
	
	public boolean deletar(int codigo) {
		
		String sql = "DELETE FROM tbl_contato WHERE cod_contato = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1,codigo);
			stm.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			Conexao.fecharConexao();
		}
		
	}
	
	public Contato getContato( int codContato){
				
		String sql = "SELECT * FROM tbl_contato WHERE cod_contato = ?";
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setInt(1, codContato);
			rs = stm.executeQuery();
			
			//Enquanto tiver uma procima linha no resultado da consulta ao banco criar um contato
			if(rs.next()) {
				contato = new Contato();
				contato.setCodContato(rs.getInt("cod_contato"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEndereco(rs.getString("endereco"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Conexao.fecharConexao();
		}
		return contato;
		
	}
	
	
}
