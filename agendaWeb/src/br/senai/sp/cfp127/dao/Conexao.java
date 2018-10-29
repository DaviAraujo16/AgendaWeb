package br.senai.sp.cfp127.dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static Connection con;
	
	public static Connection getConexao() {
		
		try {
			//Esse comando chama a classe driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Nessa String tem caminho para chegar no banco de dados
			String dbURL = "jdbc:mysql://10.107.134.23/db_inf2ta?useTimeZone=true&serverTimezone=UTC";
			
			//Nessas duas Strings temos o login e a senha do banco
			String user = "inf2ta";
			String pass = "123";
			
			// E aqui está a conexão com o banco que contém o caminho, o usuario e a senha.
			con = DriverManager.getConnection(dbURL,user,pass);
			System.out.println("Banco conectado com Sucesso!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Ocorreu um erro na conexão");
		}
		return con;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
