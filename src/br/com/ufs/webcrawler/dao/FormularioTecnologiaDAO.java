package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ufs.webcrawler.model.Formulario;
import br.com.ufs.webcrawler.model.FormularioTecnologia;
import br.com.ufs.webcrawler.model.Tecnologia;
import br.com.ufs.webcrawler.util.Conexao;

public class FormularioTecnologiaDAO {

	Conexao con = new Conexao();
	FormularioDAO formularioDAO = new FormularioDAO();
	TecnologiaDAO tecnologiaDAO = new TecnologiaDAO();

	public void criarFormularioTecnologia(int tecnologia, int formulario) throws SQLException {

		boolean existe = verificarFormularioTecnologia(formulario, tecnologia);

		if (existe) {

			System.out.println("Esse registro já existe na tabela");
			
		} else {
			
			String sql = "Insert into formulario_tecnologia (id_formulario, id_tecnologia) values (" + formulario + ","
					+ tecnologia + ")";

			con.setConnection();
			Statement comando = con.conexao.createStatement();
			System.out.println("Executar consulta:" + sql);
			comando.execute(sql);
			comando.close();
			con.conexao.close();

		}

	}

	public boolean verificarFormularioTecnologia(int formulario, int tecnologia) throws SQLException {

		boolean existe = false;
		String sql = "select * from formulario_tecnologia obj where obj.id_tecnologia =" + tecnologia + " and "
				+ " obj.id_formulario=" + formulario;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		// System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		FormularioTecnologia formularioTecnologia = new FormularioTecnologia();

		while (resultado.next()) {

			formularioTecnologia.setCodigo(resultado.getInt("id_formulario_tecnologia"));
			formularioTecnologia.setFormulario(formularioDAO.getFormularioById(resultado.getInt("id_formulario")));
			formularioTecnologia.setTecnologia(tecnologiaDAO.getTecnologiaById(resultado.getInt("id_tecnologia")));
			existe = true;
		}
		comando.close();
		return existe;
	}

}
