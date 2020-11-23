package com.adaming;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adaming.entities.Affaire;
import com.adaming.entities.Document;

import com.adaming.services.IAffaireService;
import com.adaming.services.IDocumentService;

@SpringBootApplication
public class MicroserviceTacheApplication implements CommandLineRunner{
	@Autowired
	IDocumentService iDocumentService;
	
	@Autowired
	IAffaireService iAffaireService;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		
		Affaire affaire1=iAffaireService.save(new Affaire("referenceAffaire1","titreAffaire1","descriptionAffaire1","ouvert"));
		Affaire affaire2=iAffaireService.save(new Affaire("referenceAffaire2","titreAffaire2","descriptionAffaire2","en cours"));
		Affaire affaire3=iAffaireService.save(new Affaire("ello","aloa","vacances","ouvert"));
		Affaire affaire4=iAffaireService.save(new Affaire("holaquetal","bigmalion","vol","en cours"));
		
		Document doc1=iDocumentService.save(new Document((long)9,df.parse("12/01/1998"),"Nomdoc1","descriptiondoc1",true,affaire1));
		Document doc2=iDocumentService.save(new Document((long)2,df.parse("25/01/1998"),"Nomdoc2","descriptiondoc2",true,affaire1));
		Document doc3=iDocumentService.save(new Document((long)3,df.parse("12/01/1998"),"Nomdoc3","descriptiondoc2",false,affaire2));
		Document doc4=iDocumentService.save(new Document((long)9,df.parse("12/01/1998"),"whales","miroir",true,affaire1));
		Document doc5=iDocumentService.save(new Document((long)2,df.parse("25/01/1998"),"iguane","boisson",true,affaire1));
		Document doc6=iDocumentService.save(new Document((long)3,df.parse("12/01/1998"),"pants","etoile",false,affaire2));

		iAffaireService.findAll().forEach(c->{System.out.println(c.getReferenceAffaire());});
		iDocumentService.findAll().forEach(c->{System.out.println(c.getNom());});
	}

}
