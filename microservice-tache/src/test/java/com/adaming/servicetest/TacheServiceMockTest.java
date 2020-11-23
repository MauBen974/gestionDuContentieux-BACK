package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Tache;
import com.adaming.services.ITacheService;

@SpringBootTest
public class TacheServiceMockTest {

	@Autowired
	ITacheService tacheService;

	@Test
	public void createValidTache_shouldReturnTacheObject() {
		Tache tache = new Tache();

		tache.setTitreTache("titreTest");
		tache.setDateCreation(LocalDate.of(2018, 11, 26));
		tache.setIdTribunal(1L);
		tache.setStatusAudience(false);

		Tache retour = tacheService.save(tache);

		assertNotNull(retour);
		assertEquals(LocalDate.of(2018, 11, 26), retour.getDateCreation());
		assertEquals("titreTest", retour.getTitreTache());
		assertEquals(1L, retour.getIdTribunal());
		assertEquals(false, retour.getStatusAudience());

	}

	@Test
	@Transactional
	@Sql(statements = { "DELETE FROM tache",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(2, 20181124, 'MonTitre')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readValidTacheById_shouldReturnThisTache() {
		Tache tache = tacheService.findOne(2L);
		assertEquals("MonTitre", tache.getTitreTache());
		assertEquals(LocalDate.of(2018, 11, 24), tache.getDateCreation());
	}

//	@Test
//	@Transactional
//	@Sql(statements = { "DELETE FROM tache",
//			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(2, 20181124, 'MonTitre')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void readUnknownTacheById_shouldReturnNull() {
//		Tache tache = tacheService.findOne(3L);
//		assertNull(tache);
//	}

	@Test
	@Sql(statements = "DELETE FROM tache")
	public void readAllTacheEmptyList_shouldReturnEmptyList() {
		List<Tache> listAll = tacheService.getAll();
		assertTrue(listAll.isEmpty());
	}

	@Test
	@Sql(statements = { "DELETE FROM tache",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(2, 20181124, 'MonTitre')",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(4, 20181121, 'AutreTitre')",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(25, 20160224, 'DernierTitre')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllTacheWithData_shouldReturnSize() {
		List<Tache> listAll = tacheService.getAll();
		assertEquals(3, listAll.size());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM tache",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(2, 20181124, 'MonTitre', 1)",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(4, 20181121, 'AutreTitre', 0)",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(25, 20160224, 'DernierTitre', 1)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readByStatusAudienceWithData_shouldReturnSize() {
		List<Tache> listStatusOn = tacheService.findByStatusAudience(true);
		assertEquals(2, listStatusOn.size());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM tache",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(2, 20181124, 'MonTitre', 1)",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(4, 20181121, 'AutreTitre', 1)",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(25, 20160224, 'DernierTitre', 1)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readByStatusAudienceWithoutData_shouldReturnEmpty() {
		List<Tache> listStatusOn = tacheService.findByStatusAudience(false);
		assertTrue(listStatusOn.isEmpty());
	}
	
	// FIND BY LIBELLE PHASE
	
	@Test
	@Sql(statements = { "DELETE FROM tache",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(2, 20181124, 'MonTitre', 1)",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(4, 20181121, 'AutreTitre', 1)",
			"Insert INTO tache (id_tache, date_creation, titre_tache, status_audience)VALUES(25, 20160224, 'DernierTitre', 1)",
			"DELETE FROM phase",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(2, 20181124, 20181126, 'En cours', 2)",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(3, 20181124, 20181126, 'Termine', 4)",
			}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void findByLibellePhase_shouldReturnSize() {
		List<Tache> listStatusEC = tacheService.findBylibellePhase("En cours");
		assertEquals(1, listStatusEC.size());
	}

}
