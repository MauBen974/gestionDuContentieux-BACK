package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Affaire;
import com.adaming.services.IAffaireService;

@SpringBootTest
public class AffaireServiceMockTest {
	
	@Autowired
	IAffaireService affaireService;
	
	@Test
	public void saveAffaire() {
		Affaire affaire = new Affaire();
		affaire.setIdAffaire(1L);
		affaire.setReferenceAffaire("referenceTest");
		affaire.setTitreAffaire("titretest");
		affaire.setDescriptionAffaire("descriptionTest");
		affaire.setStatus("statusTest");
		
		Affaire retour = affaireService.save(affaire);

		assertNotNull(retour);
		assertEquals(1L, retour.getIdAffaire());
		assertEquals("referenceTest", retour.getReferenceAffaire());
		assertEquals("titreTest", retour.getTitreAffaire());
		assertEquals("descriptionTest",retour.getDescriptionAffaire());
		assertEquals("statusTest",retour.getStatus());
	}
	
	@Test
	@Transactional
	@Sql(statements = { "DELETE FROM affaire",
	"Insert INTO affaire (id_affaire,description_affaire,reference_affaire,status,titre_affaire) VALUES (2,'description2','reference2','status2','titre2')" },
	executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void findAffaire() {
		Affaire affaire = affaireService.findOne(2L).get();
		assertNotNull(affaire);
		assertEquals(2L, affaire.getIdAffaire());
		assertEquals("reference2", affaire.getReferenceAffaire());
		assertEquals("titre2", affaire.getTitreAffaire());
		assertEquals("description2",affaire.getDescriptionAffaire());
		assertEquals("status2",affaire.getStatus());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM affaire",
			"Insert INTO affaire (id_affaire, description_affaire, reference_affaire, status, titre_affaire) VALUES (3,'description3','reference3','status3','titre3')",
			"Insert INTO affaire (id_affaire, description_affaire, reference_affaire, status, titre_affaire) VALUES (4,'description4','reference4','status4','titre4')",
			"Insert INTO affaire (id_affaire, description_affaire, reference_affaire, status, titre_affaire) VALUES (5,'description5','reference5','status5','titre5')" }, 
	executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void findAffaires() {
		List<Affaire> listAll = affaireService.findAll();
		assertEquals(3, listAll.size());
	}
	
	@Test
	@Transactional
	@Sql(statements = { "DELETE FROM affaire",
	"Insert INTO affaire (id_affaire,description_affaire,reference_affaire,status,titre_affaire) VALUES (6,'description6','reference6','status6','titre6')" },
	executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteAffaire() {
		assertTrue(affaireService.delete(6L));
	}
	
}
