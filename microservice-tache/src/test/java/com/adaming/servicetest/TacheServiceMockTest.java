package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.PrepareTestInstance;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.adaming.entities.Tache;
import com.adaming.repositories.ITacheRepository;
import com.adaming.services.ITacheService;
import com.adaming.services.TacheServiceImpl;

@SpringBootTest
public class TacheServiceMockTest {
//	Tache tache;
//	Long idTache = 1L;
//	
//	@Mock
//	private ITacheRepository tacheRepository;
//	
//	@InjectMocks
//	private ITacheService tacheService = new TacheServiceImpl();
//	
//	//TEST FIND BY ID--------------------------------------
//	@BeforeEach
//	void setMockOutPut() {
//		when(tacheRepository.findById(idTache).get()).thenReturn(tache);
//	}
//	
//	@Test
//	public void testFindOneById() {
//		Tache result = tacheService.findOne(idTache);
//		assertEquals(Tache.class, result.getClass());
//	}
//	
//	//TEST FIND ALL--------------------------------------
//	@Test
//	public void testFindAll() {
//		assertEquals(Collection.class, tacheService.getAll());
//	}
//	
//	//TEST SAVE--------------------------------------------
//	@Test
//	public void testSave() {
//		Tache tache = new Tache();
//		assertEquals(Tache.class, tacheService.save(tache));
//	}
//	
//	//TEST DELETE------------------------------------------
//	@Test
//	public void testDelete() {
//		Tache tache = new Tache();
//		//phaseService.delete(phase.getIdPhase());
//		//assertEquals(null,tacheService.findOne(phase.getIdTache()).isEmpty());
//	}
	@Autowired
	ITacheService tacheService;

	
	@Test
	public void createValidTache_shouldReturnTacheObject() throws ParseException {
		Tache tache = new Tache();
		SimpleDateFormat formater = null;
		formater = new SimpleDateFormat("dd-MM-yyyy");
		Date d1 = formater.parse("10-12-2018");
		
		tache.setTitreTache("titreTest");
		tache.setDateCreation(d1);
		tache.setIdTribunal(1L);
		tache.setStatusAudience(false);
		
		Tache retour = tacheService.save(tache);
		
		assertNotNull(retour);
		assertEquals(d1, retour.getDateCreation());
		assertEquals("titreTest", retour.getTitreTache());
		assertEquals(1L, retour.getIdTribunal());
		assertEquals(false, retour.getStatusAudience());
		
	}
	
//	@Test
//	@Sql(statements = {"DELETE FROM tache", "Insert INTO tache (idTache, dateCreation, titreTache)VALUES(2, 20181124, 'MonTitre')"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void deleteValidTache_shouldReturnNull() throws ParseException {
//		SimpleDateFormat formater = null;
//		formater = new SimpleDateFormat("dd-MM-yyyy");
//		Date d1 = formater.parse("10-12-2018");
//		Tache tache = new Tache(1L, d1, "Titre", "Description", true, 1L, 1L, null);
//		tacheService.delete(1L);
//		
//		assertNull(tache);
//	}
	
	@Test
	@Sql(statements = {"DELETE FROM tache", "Insert INTO tache (idTache, dateCreation, titreTache)VALUES(2, 20181124, 'MonTitre')"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void readValidTacheById_shouldReturnThisTache() {
		Tache tache = tacheService.findOne(2L);
		assertEquals("MonTitre", tache.getTitreTache());
		assertEquals("24-11-2018", tache.getDateCreation());
	}
	
}
