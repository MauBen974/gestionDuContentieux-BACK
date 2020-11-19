package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.adaming.entities.Tribunal;
import com.adaming.repositories.TribunalRepository;
import com.adaming.services.TribunalService;
import com.adaming.services.TribunalServiceImpl;

@SpringBootTest
public class TribunalServiceMockTest {
	
	Tribunal tribunal;
	Long idTribunal = 1L;
	
	@Mock
	private TribunalRepository tribunalRepository;
	
	@InjectMocks
	private TribunalService tribunalService = new TribunalServiceImpl();
	
	//TEST FIND BY ID--------------------------------------
	@BeforeEach
	void setMockOutPut() {
		when(tribunalRepository.findById(idTribunal).get()).thenReturn(tribunal);
	}
	
	public void testFindOneById() {
		Tribunal result = tribunalService.findById(idTribunal).get();
		assertEquals(idTribunal,result.getIdTribunal());
	}
	
	//TEST FIND ALL----------------------------------------
	public void testFindAll() {
		assertEquals(Collection.class, tribunalService.findAll());
	}

	//TEST SAVE--------------------------------------------
	public void testSave() {
		Tribunal tribunal = new Tribunal();
		assertEquals(Tribunal.class, tribunalService.save(tribunal));
	}
	
	//TEST DELETE------------------------------------------
	public void testDelete() {
		Tribunal tribunal = new Tribunal();
		tribunalService.delete(tribunal.getIdTribunal());
		assertEquals(null,tribunalService.findById(idTribunal).isEmpty());
	}
	
}
