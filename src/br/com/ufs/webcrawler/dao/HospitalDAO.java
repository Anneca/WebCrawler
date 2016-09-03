package br.com.ufs.webcrawler.dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.ufs.webcrawler.model.Hospital;
import br.com.ufs.webcrawler.util.Conexao;

public class HospitalDAO {

	Conexao con = new Conexao();
	CidadeDAO cidadeDAO = new CidadeDAO();
	PaisDAO paisDAO = new PaisDAO();

	public ArrayList<Hospital> listarHospitais() throws SQLException {

		ArrayList<Hospital> lista = new ArrayList<Hospital>();

		String sql = "select * from hospital";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		//System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		while (resultado.next()) {
			Hospital obj = new Hospital();
			obj.setCodigo(resultado.getInt("id_hospital"));
			obj.setCidade(cidadeDAO.getCidadeById(resultado.getInt("id_cidade")));
			obj.setPais(paisDAO.getPaisById(resultado.getInt("id_pais")));
			obj.setUrl(resultado.getString("cv_site"));
			lista.add(obj);
		}

		comando.close();
		return lista;

	}

}
