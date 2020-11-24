package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Document;
import com.adaming.services.IDocumentService;

@SpringBootTest
public class DocumentServiceMockTest {

	@Autowired
	IDocumentService documentService;

	@Test
	@Sql(statements = "DELETE FROM Document")
	public void createValidDocument_ShouldReturnDocumentObject() {
		Document document = new Document();
		LocalDate dateInstance = LocalDate.parse("2019-03-27");
		document.setDateCreation(dateInstance);
		document.setNom("nomTest");
		document.setDescription("descriptiontest");

		Document retour = documentService.save(document);
		assertNotNull(retour);
		assertEquals("nomTest", retour.getNom());
	}

	@Test
	@Sql(statements = { "DELETE FROM document", "Insert INTO document (id, date_creation, nom, description, archive)"
			+ "VALUES(2, '2019-03-27', 'nomtest', 'descrition test', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readValidDocumentById_shouldReturnThisDocument() {
		Document document = documentService.findOne(2L).get();
		assertEquals(LocalDate.of(2019, 03, 27), document.getDateCreation());
		assertEquals("nomtest", document.getNom());
		assertEquals("descrition test", document.getDescription());
		assertEquals(false, document.isArchive());
	}

	@Test
	@Sql(statements = { "DELETE FROM document", "Insert INTO document (id, date_creation, nom, description, archive)"
			+ "VALUES(2, '2019-03-27', 'nomtest', 'descrition test', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readUnknownUtilisateurById_shouldReturnFalse() {
		assertFalse(documentService.findOne(3L).isPresent());
	}

	@Test
	@Sql(statements = "DELETE FROM document")
	public void readAllDocumentEmptyList_shouldReturnEmptyList() {
		List<Document> listAll = documentService.findAll();
		assertTrue(listAll.isEmpty());
	}

	@Test
	@Sql(statements = { "DELETE FROM document",
			"Insert INTO document (id, date_creation, nom, description, archive)"
					+ "VALUES(1, '2020-11-23', 'nom test', 'descrition test', 0)",
			"Insert INTO document (id, date_creation, nom, description, archive)"
					+ "VALUES(2, '2020-01-01', 'deuxieme nomtest', 'deuxieme descrition test', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllDocumentWithData_shouldReturnSize() {
		List<Document> listAll = documentService.findAll();
		assertEquals(2, listAll.size());
	}

}
