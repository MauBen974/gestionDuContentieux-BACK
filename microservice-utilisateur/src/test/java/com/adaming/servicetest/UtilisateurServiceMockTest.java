package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Utilisateur;
import com.adaming.services.IUtilisateurService;

@SpringBootTest
public class UtilisateurServiceMockTest {


	@Autowired
	IUtilisateurService utilisateurService;

	@Test
	@Sql(statements = "DELETE FROM Utilisateur")
	public void createValidUtilisateur_ShouldReturnUtilisateurObject() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("nomtest");
		utilisateur.setPrenom("prenomTest");
		utilisateur.setEmail("valid@gmail.com");
		utilisateur.setPassword("validPassword");

		Utilisateur retour = utilisateurService.saveUtilisateur(utilisateur);
		assertNotNull(retour);
		assertEquals("valid@gmail.com", retour.getEmail());
	}

	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readValidUtilisateurById_shouldReturnThisUtilisateur() {
		Utilisateur utilisateur = utilisateurService.findOne(2L).get();
		assertEquals("nomUser", utilisateur.getNom());
		assertEquals("valid@gmail.com", utilisateur.getEmail());
		assertEquals(false, utilisateur.isArchive());
	}

	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readUnknownUtilisateurById_shouldReturnFalse() {
		assertFalse(utilisateurService.findOne(3L).isPresent());
	}

//	@Test
//	@Sql(statements = { "DELETE FROM utilisateur",
//			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void readUtilisateurByIdWithIdNull_shouldThrowException() throws InvalidDataAccessApiUsageException {
//		Long id = null;
//		Utilisateur utilisateur = utilisateurService.findOne(id).get();
//		assertNull(utilisateur);
//
//	}

	@Test
	@Sql(statements = "DELETE FROM utilisateur")
	public void readAllUtilisateurEmptyList_shouldReturnEmptyList() {
		List<Utilisateur> listAll = utilisateurService.findAll();
		assertTrue(listAll.isEmpty());
	}

	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 0)",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(3, 'validbis@gmail.com', 'deuxièmeNom', 1)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllUtilisateurWithData_shouldReturnSize() {
		List<Utilisateur> listAll = utilisateurService.findAll();
		assertEquals(2, listAll.size());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 0)",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(3, 'validbis@gmail.com', 'deuxièmeNom', 1)",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(4, 'validter@gmail.com', 'troisièmeNom', 1)"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllUtilisateurWithArchiveFalseWithData_shouldReturnSize() {
		List<Utilisateur> listAll = utilisateurService.findAllIfArchiveFalse();
		assertEquals(1, listAll.size());
	}

	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, password, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 'passwordtest', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void authentificationTestWithValidUtilisateur_shouldReturnThisUtilisateur() {
		Utilisateur utilisateur = utilisateurService.authentification("valid@gmail.com", "passwordtest").get();
		assertEquals("nomUser", utilisateur.getNom());
		assertEquals("valid@gmail.com", utilisateur.getEmail());
		assertEquals(false, utilisateur.isArchive());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, password, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 'passwordtest', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void authentificationTestWithUnknownUtilisateur_shouldReturnFalse() {
		assertFalse(utilisateurService.authentification("aa@aa.fr", "passwordtest").isPresent());
	}

	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, password, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 'passwordtest', 0)",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(3, 'validbis@gmail.com', 'deuxièmeNom', 1)"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void archiveUtilisateurWithNotArchivedOne_shouldReturnUtilisateurArchive() {
		Utilisateur utilisateur = utilisateurService.archiveUtilisateur(2L);
		assertEquals(true, utilisateur.isArchive());
		assertEquals("nomUser", utilisateur.getNom());
	}
	
	@Test
	@Sql(statements = { "DELETE FROM utilisateur",
			"Insert INTO utilisateur (id_utilisateur, email, nom, password, archive)VALUES(2, 'valid@gmail.com', 'nomUser', 'passwordtest', 0)",
			"Insert INTO utilisateur (id_utilisateur, email, nom, archive)VALUES(3, 'validbis@gmail.com', 'deuxièmeNom', 1)"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void archiveUtilisateurWithArchivedOne_shouldReturnThisUtilisateur() {
		Utilisateur utilisateur = utilisateurService.archiveUtilisateur(3L);
		assertEquals(true, utilisateur.isArchive());
		assertEquals("deuxièmeNom", utilisateur.getNom());
	}
	
}
