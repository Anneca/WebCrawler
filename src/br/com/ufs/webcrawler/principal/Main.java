package br.com.ufs.webcrawler.principal;

import java.util.ArrayList;
import br.com.ufs.webcrawler.model.URLs;

public class Main {

	public static void main(String[] args) {

		ExtratorTecnologias extratorTecnologias = new ExtratorTecnologias();
		ExtratorInformacoesHospital extratorInformacoesHospital = new ExtratorInformacoesHospital();

		//Temporario Essas informações deverão vim de uma tabela
		ArrayList<URLs> urlsHospitais = new ArrayList<URLs>();

		URLs endereco1 = new URLs();
		URLs endereco2 = new URLs();
		URLs endereco3 = new URLs();


		endereco1.setDescricao("http://www.redeprimavera.com.br/hospital/");
		endereco2.setDescricao("http://www.unimedse.com.br/v2/index.php");
		endereco3.setDescricao("http://www.hobr.com.br/");
		
		// Preenchendo vetor com as URLs
		urlsHospitais.add(endereco1);
		urlsHospitais.add(endereco2);
		urlsHospitais.add(endereco3);


		for (int i = 0; i < urlsHospitais.size(); i++) {
			
			extratorInformacoesHospital.extrairInformacoesHospital(urlsHospitais.get(i).getDescricao());				
			System.out.println("Tecnologias:");
			String url = urlsHospitais.get(i).getDescricao();
			extratorTecnologias.extrairTecnologias(url.replaceAll("http://", ""));

		}
	}

}
