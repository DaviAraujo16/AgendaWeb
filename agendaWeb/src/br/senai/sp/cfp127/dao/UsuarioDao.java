package br.senai.sp.cfp127.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.senai.sp.cfp127.model.Usuario;

public class UsuarioDao {
	
	private Usuario usuario;
	private PreparedStatement stm;
	//Resultado da consulta
	private ResultSet rs;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	//** METODO PARA GRAVAR(SALVAR) UM USUÁRIO NO BANCO
	public boolean gravar() {
		String sql = "INSERT INTO tbl_usuario (nome, email, senha, sexo, dtNascimento)"
				+"VALUES (?,?,?,?,?)";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1,usuario.getNome());
			stm.setString(2,usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			//substring(0,1) retira apenas o primeiro caracter de uma String	
			stm.setString(4, usuario.getSexo().substring(0,1));
			stm.setString(5, usuario.getDtNascimento());
			
			stm.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;	
		}finally{
			Conexao.fecharConexao();
		}
		
	}
	
	//** METODO PARA AtUALIZAR UM USUÁRIO NO BANCO
	public boolean atualizar() {
		String sql = "UPDATE tbl_usuario SET nome = ?, email = ?, senha = ?, sexo = ?, dtNascimento = ? WHERE cod = ?";
		
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1,usuario.getNome());
			stm.setString(2,usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setString(4, usuario.getSexo().substring(0,1));
			stm.setString(5, usuario.getDtNascimento());
			stm.setInt(6, usuario.getCod());
			stm.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;	
		}finally{
			Conexao.fecharConexao();
		}
		
	}
	
	//** METODO PARA AUTENTICAR O USUARIO (login)
	//Esse metodo consulta o banco e retorna apenas uma linha com o usuario
	public Usuario autenticar(String email, String senha){
		this.usuario = new Usuario();
				
		String sql ="SELECT * FROM tbl_usuario WHERE senha = ? AND email = ?";
		
		//busca o usuario no banco
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			stm.setString(1,senha);
			stm.setString(2, email);
			//Retorna uma linha do banco (a primeira linha é o cabeçalho e segunda um registro )
			rs = stm.executeQuery();
			
			//Passa o ponteiro para a proxima linha onde está as informações
			if(rs.next()) {
				//Popula o usuario com os dados do banco 
				this.usuario.setCod(rs.getInt("cod"));
				this.usuario.setNome(rs.getString("nome"));
				this.usuario.setEmail(rs.getString("email"));
				this.usuario.setSexo(rs.getString("sexo"));
				this.usuario.setDtNascimento(rs.getString("dtNascimento"));
			}
		//Mensagem de erro	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Conexao.fecharConexao();
		}
		
		//Retorna o usuario encontrado
		return this.usuario;
		
	}

	
	
}
