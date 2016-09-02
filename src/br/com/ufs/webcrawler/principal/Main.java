package br.com.ufs.webcrawler.principal;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.ufs.webcrawler.enumeration.Tags;
import br.com.ufs.webcrawler.model.Tecnologia;
import br.com.ufs.webcrawler.model.URLs;

public class Main {

	public static void main(String[] args) {

		Document doc;
		boolean servicos;
		boolean informacoesInstitucionais;
		boolean redesSociais;
		// boolean acessibilidade;
		boolean tecnologia;
		boolean comentarios;
		ExtratorTecnologias extrator = new ExtratorTecnologias();

		ArrayList<URLs> urlsHospitais = new ArrayList<URLs>();

		URLs endereco1 = new URLs();
		URLs endereco2 = new URLs();

		endereco1.setDescricao("http://www.redeprimavera.com.br/hospital/");
		endereco2.setDescricao("http://www.unimedse.com.br/v2/index.php");

		// Preenchendo vetor com as URLs
		urlsHospitais.add(endereco1);
		urlsHospitais.add(endereco2);

		for (int i = 0; i < urlsHospitais.size(); i++) {

			try {
				doc = Jsoup.connect(urlsHospitais.get(i).getDescricao()).get();
				servicos = false;
				informacoesInstitucionais = false;
				redesSociais = false;
				comentarios = false;
				tecnologia = false;

				for (Tags tag : Tags.values()) {

					Elements elemento_a = doc.select(tag.nome);

					for (Element element_a : elemento_a) {

						if (element_a.outerHtml().matches(".*(?i)servico.*")
								|| element_a.outerHtml().matches(".*(?i)procedimento.*")
								|| element_a.outerHtml().matches(".*(?i)exame.*")
								|| element_a.outerHtml().matches(".*(?i)especialidade.*")) {

							servicos = true;
						}

						if (element_a.outerHtml().matches(".*(?i)sobre.*")
								|| element_a.outerHtml().matches(".*(?i)institucional.*")
								|| element_a.outerHtml().matches(".*(?i)valor.*")
								|| element_a.outerHtml().matches(".*(?i)missao.*")
								|| element_a.outerHtml().matches(".*(?i)visao.*")
								|| element_a.outerHtml().matches(".*(?i)missão.*")
								|| element_a.outerHtml().matches(".*(?i)visão.*")
								|| element_a.outerHtml().matches(".*(?i)institucionais.*")
								|| element_a.outerHtml().matches(".*(?i)informaç.*")
								|| element_a.outerHtml().matches(".*(?i)informac.*")) {

							informacoesInstitucionais = true;
						}

						if (element_a.outerHtml().matches(".*(?i)facebook.*")
								|| element_a.outerHtml().matches(".*(?i)twitter.*")
								|| element_a.outerHtml().matches(".*(?i)youtube.*")
								|| element_a.outerHtml().matches(".*(?i)redes-sociais.*")
								|| element_a.outerHtml().matches(".*(?i)Redes Sociais.*")
								|| element_a.outerHtml().matches(".*(?i)linkedin.*")
								|| element_a.outerHtml().matches(".*(?i)instagram.*")
								|| element_a.outerHtml().matches(".*(?i)blogger.*")
								|| element_a.outerHtml().matches(".*(?i)snapchat.*")) {

							redesSociais = true;
						}

						if (element_a.outerHtml().matches(".*(?i)fale-conosco.*")
								|| element_a.outerHtml().matches(".*(?i)Fale Conosco.*")
								|| element_a.outerHtml().matches(".*(?i)email.*")
								|| element_a.outerHtml().matches(".*(?i)e-mail.*")
								|| element_a.outerHtml().matches(".*(?i)contato.*")) {

							comentarios = true;
						}

					}

				}

				System.out.println();
				System.out.println("Hospital na posição " + i);

				// Verificando se o site disponibiliza informações referentes
				// aos serviços
				if (servicos) {
					System.out.println("Informações sobre serviços: SIM");
				}

				// Verificando se o site disponibiliza informações
				// institucionais
				if (informacoesInstitucionais) {
					System.out.println("Informações Institucionais: SIM");
				}

				// Verificando se o site disponibiliza informações referentes
				// as redes sociais
				if (redesSociais) {
					System.out.println("Redes Sociais: SIM");
				}

				// Verificando se o site disponibiliza endereço eletrônico para
				// feedback
				if (comentarios) {
					System.out.println(
							"Endereço eletrônico para realização de comentários, sugestões e reclamações: SIM ");
				}
				
				System.out.println("Tecnologias:");
				String url = urlsHospitais.get(i).getDescricao();
				extrator.extrairTecnologias(url.replaceAll("http://", ""));


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
