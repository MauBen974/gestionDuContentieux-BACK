package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.adaming.entities.Phase;
import com.adaming.repositories.IPhaseRepository;
import com.adaming.services.IPhaseService;
import com.adaming.services.PhaseServiceImpl;


@SpringBootTest
public class PhaseServiceMockTest {
//	Phase phase;
//	Long idPhase = 1L;
//	
//	@Mock
//	private IPhaseRepository phaseRepository;
//	
//	@InjectMocks
//	private IPhaseService phaseService = new PhaseServiceImpl();
//	
//	//TEST FIND BY ID--------------------------------------
//	@BeforeEach
//	void setMockOutPut() {
//		when(phaseRepository.findById(idPhase).get()).thenReturn(phase);
//	}
//	
//	@Test
//	public void testFindOneById() {
//		Phase result = phaseService.findOne(idPhase);
//		assertEquals(Phase.class, result.getClass());
//	}
//	
//	//TEST FIND ALL--------------------------------------
//	@Test
//	public void testFindAll() {
//		assertEquals(Collection.class, phaseService.getAll());
//	}
//	
//	//TEST SAVE--------------------------------------------
//	@Test
//	public void testSave() {
//		Phase phase = new Phase();
//		assertEquals(Phase.class, phaseService.save(phase));
//	}
//	
//	//TEST DELETE------------------------------------------
//	@Test
//	public void testDelete() {
//		Phase phase = new Phase();
//		//phaseService.delete(phase.getIdPhase());
//		//assertEquals(null,phaseService.findOne(phase.getIdPhase()).isEmpty());
//	}
}
