package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ufs.webcrawler.model.Cidade;
import br.com.ufs.webcrawler.util.Conexao;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class CidadeDAO {

	Conexao con = new Conexao();

	public Cidade getCidadeById(int id) throws SQLException {

		String sql = "select * from cidade cidade " + "where cidade.id_cidade =" + id;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		//System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		Cidade cidade = new Cidade();

		while (resultado.next()) {

			cidade.setCodigo(resultado.getInt("id_cidade"));
			cidade.setDescricao(resultado.getString("cv_descricao"));
		}

		comando.close();
		con.conexao.close();
		return cidade;

	}
}
