package br.com.ufs.webcrawler.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection conexao = null;

	public Conexao() {

		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Carregou");

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Conexao teste = new Conexao();
		try {
			teste.setConnection();
			System.out.println("Conectado!!");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/*
	 * Settando conexão de acordo com o banco de dados utilizado.
	 */
	public void setConnection() throws SQLException {
		String host = "localhost:5433";
		String database = "WebCrawler";
		String url = "jdbc:postgresql://" + host + "/" + database;
		String user = "postgres";
		String password = "Enilorac28";
		conexao = DriverManager.getConnection(url, user, password);
		System.out.println("Conexão criada");

	}

	/*
	 * Métodos de consulta ao banco de dados
	 */

	public void remover() {
		try {
			conexao.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
