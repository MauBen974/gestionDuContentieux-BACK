package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.adaming.entities.Tache;
import com.adaming.repositories.ITacheRepository;
import com.adaming.services.ITacheService;
import com.adaming.services.TacheServiceImpl;

@SpringBootTest
public class TacheServiceMockTest {
	Tache tache;
	Long idTache = 1L;
	
	@Mock
	private ITacheRepository tacheRepository;
	
	@InjectMocks
	private ITacheService tacheService = new TacheServiceImpl();
	
	//TEST FIND BY ID--------------------------------------
	@BeforeEach
	void setMockOutPut() {
		when(tacheRepository.findById(idTache).get()).thenReturn(tache);
	}
	
	@Test
	public void testFindOneById() {
		Tache result = tacheService.findOne(idTache);
		assertEquals(Tache.class, result.getClass());
	}
	
	//TEST FIND ALL--------------------------------------
	@Test
	public void testFindAll() {
		assertEquals(Collection.class, tacheService.getAll());
	}
	
	//TEST SAVE--------------------------------------------
	@Test
	public void testSave() {
		Tache tache = new Tache();
		assertEquals(Tache.class, tacheService.save(tache));
	}
	
	//TEST DELETE------------------------------------------
	@Test
	public void testDelete() {
		Tache tache = new Tache();
		//phaseService.delete(phase.getIdPhase());
		//assertEquals(null,tacheService.findOne(phase.getIdTache()).isEmpty());
	}
}
