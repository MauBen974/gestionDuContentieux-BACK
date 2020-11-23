package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Phase;
import com.adaming.entities.Tache;
import com.adaming.services.IPhaseService;

@SpringBootTest
public class PhaseServiceMockTest {

	@Autowired
	private IPhaseService phaseService;

	@Test
	public void createValidPhase_shouldReturnPhaseObject() {
		Phase phase = new Phase();

		phase.setDateDebut(LocalDate.of(2018, 11, 26));
		phase.setDateFin(null);
		phase.setLibellePhase("En cours");
		phase.setTache(null);

		Phase retour = phaseService.save(phase);
		assertNotNull(retour);
		assertEquals(LocalDate.of(2018, 11, 26), retour.getDateDebut());
		assertNull(retour.getDateFin());
		assertEquals("En cours", retour.getLibellePhase());
		assertEquals(null, retour.getTache());
	}

	@Test
	@Transactional
	@Sql(statements = { "DELETE FROM phase",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(2, 20181124, 20181126, 'En cours')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readValidTacheById_shouldReturnThisTache() {
		Phase phase = phaseService.findOne(2L);
		assertEquals("En cours", phase.getLibellePhase());
		assertEquals(LocalDate.of(2018, 11, 24), phase.getDateDebut());
		assertEquals(LocalDate.of(2018, 11, 26), phase.getDateFin());
	}

	@Test
	@Sql(statements = { "DELETE FROM phase",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(2, 20181124, 20181126, 'En cours')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(3, 20181124, 20181126, 'Termine')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllPhaseWithData_shouldReturnListSize() {
		assertEquals(2, phaseService.getAll().size());

	}

	@Test
	@Sql(statements = { "DELETE FROM phase" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllEmptyList_shouldReturnEmptyList() {
		assertTrue(phaseService.getAll().isEmpty());

	}

	@Test
	@Sql(statements = { "DELETE FROM phase",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(2, 20181124, 20181126, 'En cours')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(4, 20181124, null, 'En cours')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(3, 20181124, null, 'cours')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllPhaseNotTerminedWithData_shouldReturnListSize() {
		assertEquals(1, phaseService.getAllNotTermined().size());

	}

	@Test
	@Sql(statements = { "DELETE FROM phase",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(2, 20181124, null, 'cours')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(3, 20181124, null, 'En attente')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllPhaseNotTerminedWithoutData_shouldReturnEmptyList() {
		assertTrue(phaseService.getAllNotTermined().isEmpty());

	}

	@Test
	@Sql(statements = { "DELETE FROM tache", "DELETE FROM phase",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(1, 20181124, 'MonTitre')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(2, 20181124, 20181126, 'Termine', 2)",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(3, 20181124, 20181126, 'Termine', 1)",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(4, 20181124, null, 'En attente', 1)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void findByTache_souldReturnListSize() {
		Tache tache = new Tache();
		tache.setIdTache(1L);
		List<Phase> listByTache = phaseService.findByTache(tache);

		assertEquals(2, listByTache.size());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM tache", "DELETE FROM phase",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(1, 20181124, 'MonTitre')",
			"Insert INTO tache (id_tache, date_creation, titre_tache)VALUES(2, 20181124, 'DeuxièmeTitre')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(2, 20181124, 20181126, 'Termine', 2)",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(3, 20181124, 20181126, 'Termine', 2)",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase, id_tache)VALUES(4, 20181124, null, 'En attente', 2)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void findByTache_souldReturnEmptyList() {
		Tache tache = new Tache();
		tache.setIdTache(1L);
		List<Phase> listByTache = phaseService.findByTache(tache);

		assertTrue(listByTache.isEmpty());
	}

}
