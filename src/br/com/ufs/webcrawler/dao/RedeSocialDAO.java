package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ufs.webcrawler.model.RedeSocial;
import br.com.ufs.webcrawler.model.Tecnologia;
import br.com.ufs.webcrawler.util.Conexao;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */

public class RedeSocialDAO {

	Conexao con = new Conexao();

	public RedeSocial consultarRedeSocialByNome(String nome) throws SQLException {

		String sql = "select * from rede_social redeSocial where redeSocial.cv_descricao ='" + nome + "'";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		// System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		RedeSocial redeSocial = new RedeSocial();

		while (resultado.next()) {

			redeSocial.setCodigo(resultado.getInt("id_rede_social"));
			redeSocial.setDescricao(resultado.getString("cv_descricao"));
		}
		comando.close();
		con.conexao.close();
		return redeSocial;
	}

	public RedeSocial getRedeSocialById(int id) throws SQLException {

		String sql = "select * from rede_social redeSocial " + "where redeSocial.id_rede_social =" + id;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		// System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		RedeSocial redeSocial = new RedeSocial();

		while (resultado.next()) {

			redeSocial.setCodigo(resultado.getInt("id_rede_social"));
			redeSocial.setDescricao(resultado.getString("cv_descricao"));
		}

		comando.close();
		con.conexao.close();
		return redeSocial;
	}

}
