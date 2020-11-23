package com.adaming;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.adaming.servicetest.TribunalServiceMockTest;

@SpringBootTest
class MicroserviceTribunalApplicationTests {

	TribunalServiceMockTest tribunalService = new TribunalServiceMockTest();

	@Test
	void contextLoads() {
		tribunalService.createValidTribunal_ShouldReturnTribunalObject();
		tribunalService.readValidTribunalById_shouldReturnThisTribunal();
		tribunalService.readUnknownTribunalById_shouldReturnFalse();
		tribunalService.readAllTribunalEmptyList_shouldReturnEmptyList();
		tribunalService.readAllTribunalWithData_shouldReturnSize();
	}

}
