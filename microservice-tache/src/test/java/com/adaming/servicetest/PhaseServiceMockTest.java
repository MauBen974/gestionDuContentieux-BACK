package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Phase;
import com.adaming.services.IPhaseService;

@SpringBootTest
public class PhaseServiceMockTest {

	@Autowired
	private IPhaseService phaseService;

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
	@Transactional
	@Sql(statements = { "DELETE FROM phase",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(2, 20181124, 20181126, 'En cours')",
			"Insert INTO phase (id_phase, date_debut, date_fin, libelle_phase)VALUES(3, 20181124, 20181126, 'Termine')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAll_shouldReturnListSize() {
		assertEquals(2, phaseService.getAll().size());

	}

}
