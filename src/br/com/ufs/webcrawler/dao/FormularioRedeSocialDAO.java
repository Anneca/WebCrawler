package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.ufs.webcrawler.model.FormularioRedesSociais;
import br.com.ufs.webcrawler.util.Conexao;

public class FormularioRedeSocialDAO {

	Conexao con = new Conexao();
	FormularioDAO formularioDAO = new FormularioDAO();
	RedeSocialDAO redeSocialDAO = new RedeSocialDAO();

	public void criarFormularioRedeSocial(int redeSocial, int formulario) throws SQLException {

		boolean existe = verificarFormularioRedeSocial(formulario, redeSocial);

		if (existe) {

			System.out.println("Esse registro já existe na tabela");

		} else {

			String sql = "Insert into formulario_redes_sociais (id_formulario, id_rede_social) values (" + formulario
					+ "," + redeSocial + ")";

			con.setConnection();
			Statement comando = con.conexao.createStatement();
			//System.out.println("Executar consulta:" + sql);
			comando.execute(sql);
			comando.close();
		}

	}

	public boolean verificarFormularioRedeSocial(int formulario, int redeSocial) throws SQLException {

		boolean existe = false;
		String sql = "select * from formulario_redes_sociais obj where obj.id_rede_social =" + redeSocial + " and "
				+ " obj.id_formulario=" + formulario;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		//System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		FormularioRedesSociais formularioRedesSociais = new FormularioRedesSociais();

		while (resultado.next()) {

			formularioRedesSociais.setCodigo(resultado.getInt("id_formulario_redes_sociais"));
			formularioRedesSociais.setFormulario(formularioDAO.getFormularioById(resultado.getInt("id_formulario")));
			formularioRedesSociais.setRedeSocial(redeSocialDAO.getRedeSocialById(resultado.getInt("id_rede_social")));
			existe = true;
		}
		comando.close();
		return existe;
	}

}
