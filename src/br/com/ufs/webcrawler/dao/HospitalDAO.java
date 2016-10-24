package br.com.ufs.webcrawler.dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ufs.webcrawler.model.Hospital;
import br.com.ufs.webcrawler.util.Conexao;
/**
 * 
 * @author Anne Caroline Melo Santos
 *
 */

public class HospitalDAO {

	Conexao con = new Conexao();
	CidadeDAO cidadeDAO = new CidadeDAO();
	PaisDAO paisDAO = new PaisDAO();

	public ArrayList<Hospital> listarHospitais() throws SQLException {

		ArrayList<Hospital> lista = new ArrayList<Hospital>();

		String sql = "select * from hospital where cv_tem_site='Sim'";

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
			obj.setTipoOrganizacao(resultado.getString("cv_tipo_organizacao"));
			lista.add(obj);
		}

		comando.close();
		con.conexao.close();
		return lista;

	}
	
	public Hospital getHospitalById(int id) throws SQLException {

		String sql = "select * from hospital hospital " + "where hospital.id_hospital =" + id;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		//System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		Hospital hospital = new Hospital();

		while (resultado.next()) {

			hospital.setCodigo(resultado.getInt("id_hospital"));
			hospital.setNome(resultado.getString("cv_nome"));
			hospital.setNome(resultado.getString("cv_site"));
			hospital.setCidade(cidadeDAO.getCidadeById(resultado.getInt("id_cidade")));
			hospital.setPais(paisDAO.getPaisById(resultado.getInt("id_pais")));
			hospital.setTipoOrganizacao(resultado.getString("cv_tipo_organizacao"));

		}

		comando.close();
		con.conexao.close();
		return hospital;

	}
	
	public Hospital getHospitalByURLs(String url) throws SQLException {

		String sql = "select * from hospital hospital " + "where hospital.cv_site ='" + url + "'";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		//System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		Hospital hospital = new Hospital();

		while (resultado.next()) {

			hospital.setCodigo(resultado.getInt("id_hospital"));
			hospital.setNome(resultado.getString("cv_nome"));
			hospital.setNome(resultado.getString("cv_site"));
			hospital.setCidade(cidadeDAO.getCidadeById(resultado.getInt("id_cidade")));
			hospital.setPais(paisDAO.getPaisById(resultado.getInt("id_pais")));
			hospital.setTipoOrganizacao(resultado.getString("cv_tipo_organizacao"));
		}

		comando.close();
		con.conexao.close();
		return hospital;

	}

}
