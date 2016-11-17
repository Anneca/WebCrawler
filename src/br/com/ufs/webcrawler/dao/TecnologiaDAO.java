package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ufs.webcrawler.model.Cidade;
import br.com.ufs.webcrawler.model.Tecnologia;
import br.com.ufs.webcrawler.util.Conexao;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */

public class TecnologiaDAO {

	Conexao con = new Conexao();

	public Tecnologia criartecnologia(String nomeTecnologia) throws SQLException {

		Tecnologia tec;
		consultarTecnologiaByNome(nomeTecnologia);

		if (verificarTecnologiaByNome(nomeTecnologia)) {
			return null;
		} else {

			String sql = "Insert into tecnologia (cv_descricao) values ('" + nomeTecnologia + "')";

			con.setConnection();
			Statement comando = con.conexao.createStatement();
			comando.execute(sql);
			tec = consultarTecnologiaByNome(nomeTecnologia);
			comando.close();
			con.conexao.close();
			return null;
		}

	}

	public boolean verificarTecnologiaByNome(String nome) throws SQLException {

		boolean tecnologia = false;
		String sql = "select * from tecnologia t where t.cv_descricao ='" + nome + "'";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		ResultSet resultado = comando.executeQuery(sql);

		Tecnologia tec = new Tecnologia();

		while (resultado.next()) {

			tec.setCodigo(resultado.getInt("id_tecnologia"));
			tec.setDescricao(resultado.getString("cv_descricao"));
			tecnologia = true;
		}
		comando.close();
		return tecnologia;
	}

	public Tecnologia consultarTecnologiaByNome(String nome) throws SQLException {

		String sql = "select * from tecnologia t where t.cv_descricao ='" + nome + "'";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		ResultSet resultado = comando.executeQuery(sql);

		Tecnologia tec = new Tecnologia();

		while (resultado.next()) {

			tec.setCodigo(resultado.getInt("id_tecnologia"));
			tec.setDescricao(resultado.getString("cv_descricao"));
		}
		comando.close();
		con.conexao.close();
		return tec;
	}

	public Tecnologia getTecnologiaById(int id) throws SQLException {
		
		String sql = "select * from tecnologia tecnologia " + "where tecnologia.id_tecnologia =" + id;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		ResultSet resultado = comando.executeQuery(sql);

		Tecnologia tecnologia = new Tecnologia();

		while (resultado.next()) {

			tecnologia.setCodigo(resultado.getInt("id_tecnologia"));
			tecnologia.setDescricao(resultado.getString("cv_descricao"));
		}

		comando.close();
		con.conexao.close();
		return tecnologia;
	}

}
