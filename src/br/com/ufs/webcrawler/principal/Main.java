package br.com.ufs.webcrawler.principal;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ufs.webcrawler.dao.HospitalDAO;
import br.com.ufs.webcrawler.model.Hospital;


public class Main {

	public static void main(String[] args) {

		ExtratorTecnologias extratorTecnologias = new ExtratorTecnologias();
		ExtratorInformacoesHospital extratorInformacoesHospital = new ExtratorInformacoesHospital();
		HospitalDAO hospitalDAO = new HospitalDAO();

		ArrayList<Hospital> hospitais = new ArrayList<Hospital>();

		try {
			// conexao.setConnection();
			hospitais = hospitalDAO.listarHospitais();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < hospitais.size(); i++) {			
			String url = hospitais.get(i).getUrl();
			//extratorInformacoesHospital.extrairInformacoesHospital(url);
			System.out.println("Tecnologias:");
			extratorTecnologias.extrairTecnologias(url.replaceAll("http://", ""));

		}
	}

}
