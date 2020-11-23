package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Tribunal;
import com.adaming.repositories.TribunalRepository;
import com.adaming.services.TribunalService;
import com.adaming.services.TribunalServiceImpl;

@SpringBootTest
public class TribunalServiceMockTest {

	@Autowired
	TribunalService tribunalService;

	@Test
	@Sql(statements = "DELETE FROM Tribunal")
	public void createValidTribunal_ShouldReturnTribunalObject() {
		Tribunal tribunal = new Tribunal();
		tribunal.setAdresse("test adresse");
		tribunal.setEmail("test email");
		tribunal.setTel(123456);
		tribunal.setRegion("test region");
		tribunal.setNomTribunal("test nom");

		Tribunal retour = tribunalService.save(tribunal);
		assertNotNull(retour);
		assertEquals(retour.getEmail(), "valid@gmail.com");
		assertFalse(retour.isArchive());
	}

	@Test
	@Sql(statements = { "DELETE FROM tribunal",
			"Insert INTO tribunal (idTribunal, adresse, email, tel, region, nomTribunal, archive)"
					+ "VALUES(2,'adressetest', 'valid@gmail.com',123456,'region test', 'nom tribunal test', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readValidTribunalById_shouldReturnThisTribunal() {
		Tribunal tribunal = tribunalService.findById(2l).get();
		assertEquals("adressetest", tribunal.getAdresse());
		assertEquals("valid@gmail.com", tribunal.getEmail());
		assertEquals(132456, tribunal.getTel());
		assertEquals("region test", tribunal.getRegion());
		assertEquals("nom tribunal test", tribunal.getNomTribunal());
		assertFalse(tribunal.isArchive());
	}

	@Test
	@Sql(statements = { "DELETE FROM tribunal",
			"Insert INTO tribunal (idTribunal, adresse, email, tel, region, nomTribunal, archive)"
					+ "VALUES(2,'adressetest', 'valid@gmail.com',123456,'region test', 'nom tribunal test', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readUnknownTribunalById_shouldReturnFalse() {
		assertFalse(tribunalService.findById(3l).isPresent());
	}

	@Test
	@Sql(statements = "DELETE FROM tribunal")
	public void readAllTribunalEmptyList_shouldReturnEmptyList() {
		List<Tribunal> listAll = tribunalService.findAll();
		assertTrue(listAll.isEmpty());
	}

	@Test
	@Sql(statements = { "DELETE FROM tribunal",
			"Insert INTO tribunal (idTribunal, adresse, email, tel, region, nomTribunal, archive)"
					+ "VALUES(2,'adressetest', 'valid@gmail.com',123456,'region test', 'nom tribunal test', 0)",
			"Insert INTO tribunal (idTribunal, adresse, email, tel, region, nomTribunal, archive)"
					+ "VALUES(2,'adressetest2', 'second@gmail.com',741852,'deuxieme region test', 'deuxieme nom tribunal test', 0)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readAllTribunalWithData_shouldReturnSize() {
		List<Tribunal> listAll = tribunalService.findAll();
		assertEquals(2, listAll.size());
	}

}
