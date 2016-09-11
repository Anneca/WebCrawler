package br.com.ufs.webcrawler.dao;

import java.sql.SQLException;
import java.sql.Statement;
import br.com.ufs.webcrawler.util.Conexao;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */
public class FormularioHospitalDAO {

	Conexao con = new Conexao();
	
	public void criarFormularioHospital(int hospital, int formulario)
			throws SQLException {


		String sql = "Insert into formulario_hospital (id_formulario, id_hospital) values ("+ formulario + "," + hospital + ")";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		System.out.println("Executar consulta:" + sql);
		comando.execute(sql);
		comando.close();
		con.conexao.close();

	}

}
