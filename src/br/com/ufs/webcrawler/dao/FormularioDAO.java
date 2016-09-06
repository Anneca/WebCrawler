package br.com.ufs.webcrawler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.ufs.webcrawler.model.Cidade;
import br.com.ufs.webcrawler.model.Formulario;
import br.com.ufs.webcrawler.model.Hospital;
import br.com.ufs.webcrawler.util.Conexao;

public class FormularioDAO {

	Conexao con = new Conexao();

	public Formulario criarFormulario(String servico, String informacoesInstitucionais, String comentarios,
			String corpoClinico) throws SQLException {

		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String format = formatter.format(data);
		System.out.println(format);

		String sql = "Insert into formulario (dt_formulario, cv_informacoes_institucionais,"
				+ "cv_servicos, cv_comentarios, cv_corpo_clinico) values ('" + format + "','"
				+ informacoesInstitucionais + "','" + servico + "','" + comentarios + "','" + corpoClinico + "')";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		System.out.println("Executar consulta:" + sql);
		comando.execute(sql);
		Formulario form = consultarFormularioByData(format);
		comando.close();
		return form;

	}

	public Formulario consultarFormularioByData(String data) throws SQLException {
		String sql = "select * from formulario form where form.dt_formulario ='" + data + "'";

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		// System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		Formulario form = new Formulario();

		while (resultado.next()) {

			form.setCodigo(resultado.getInt("id_formulario"));
			form.setComentarios(resultado.getString("cv_comentarios"));
			form.setCorpoClinico(resultado.getString("cv_corpo_clinico"));
			form.setData(resultado.getString("dt_formulario"));
			form.setInformacoesInstitucionais(resultado.getString("cv_informacoes_institucionais"));
			form.setServicos(resultado.getString("cv_servicos"));
		}

		comando.close();
		return form;
	}

	public Formulario getFormularioById(int id) throws SQLException {

		String sql = "select * from formulario formulario " + "where formulario.id_formulario =" + id;

		con.setConnection();
		Statement comando = con.conexao.createStatement();
		// System.out.println("Executar consulta:" + sql);
		ResultSet resultado = comando.executeQuery(sql);

		Formulario formulario = new Formulario();

		while (resultado.next()) {

			formulario.setCodigo(resultado.getInt("id_formulario"));
			formulario.setComentarios(resultado.getString("cv_comentarios"));
			formulario.setCorpoClinico(resultado.getString("cv_corpo_clinico"));
			formulario.setData(resultado.getString("dt_formulario"));
			formulario.setInformacoesInstitucionais(resultado.getString("cv_informacoes_institucionais"));
			formulario.setServicos(resultado.getString("cv_servicos"));
		}

		comando.close();
		return formulario;

	}

}
