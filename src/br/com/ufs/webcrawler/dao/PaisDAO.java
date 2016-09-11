package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.ufs.webcrawler.model.Pais;
import br.com.ufs.webcrawler.util.Conexao;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */

public class PaisDAO {
	Conexao con = new Conexao();

	public Pais getPaisById(int id) throws SQLException {

		String sql = "select * from pais pais " + "where pais.id_pais =" + id;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		//System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);
		
		Pais pais = new Pais();

		while (resultado.next()) {

			pais.setCodigo(resultado.getInt("id_pais"));
			pais.setDescricao(resultado.getString("cv_descricao"));
		}

		comando.close();
		con.conexao.close();
		return pais;

	}
}
