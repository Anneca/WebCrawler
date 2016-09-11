package br.com.ufs.webcrawler.principal;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ufs.webcrawler.dao.HospitalDAO;
import br.com.ufs.webcrawler.model.Formulario;
import br.com.ufs.webcrawler.model.Hospital;
/**
 * Universidade Federal de Sergipe
 * Trabalho de Conclusão de Curso II
 * Projeto WebCrawler - Observatória e-Health
 * @author Anne Caroline Melo Santos
 *
 */
public class Main {

	public static void main(String[] args) {

		ExtratorRedesSociais extratorRedesSociais = new ExtratorRedesSociais();
		ExtratorTecnologias extratorTecnologias = new ExtratorTecnologias();
		ExtratorInformacoesHospital extratorInformacoesHospital = new ExtratorInformacoesHospital();
		HospitalDAO hospitalDAO = new HospitalDAO();

		ArrayList<Hospital> hospitais = new ArrayList<Hospital>();

		try {
			hospitais = hospitalDAO.listarHospitais();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < hospitais.size(); i++) {
			String url = hospitais.get(i).getUrl();
			Formulario formulario = extratorInformacoesHospital.extrairInformacoesHospital(url);
			System.out.println("Tecnologias:");
			extratorTecnologias.extrairTecnologias(url.replaceAll("http://", ""), formulario);
			System.out.println("Redes Sociais:");
			extratorRedesSociais.extrairRedesSociais(url, formulario);
		}
	}

}
