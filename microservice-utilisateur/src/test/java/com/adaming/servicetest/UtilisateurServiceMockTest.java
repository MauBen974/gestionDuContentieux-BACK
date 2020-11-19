package com.adaming.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.adaming.entities.Utilisateur;
import com.adaming.repositories.UtilisateurRepository;
import com.adaming.services.IUtilisateurService;
import com.adaming.services.UtilisateurServiceImp;

@SpringBootTest
public class UtilisateurServiceMockTest {
	Utilisateur utilisateur;
	Long idUtilisateur = 1L;
	
	@Mock
	private UtilisateurRepository utilisateurRepository;
	
	@InjectMocks
	private IUtilisateurService utilisateurService = new UtilisateurServiceImp();
	
	//TEST FIND BY ID--------------------------------------
	@BeforeEach
	void setMockOutPut() {
		when(utilisateurRepository.findById(idUtilisateur).get()).thenReturn(utilisateur);
	}
	
	@Test
	public void testFindOneById() {
		Utilisateur result = utilisateurService.findOne(idUtilisateur).get();
		assertEquals(idUtilisateur,result.getIdUtilisateur());
	}
	
	//TEST FIND ALL----------------------------------------
	@Test
	public void testFindAll() {
		assertEquals(Collection.class, utilisateurService.findAll());
	}
	
	//TEST SAVE--------------------------------------------
	@Test
	public void testSave() {
		Utilisateur utilisateur = new Utilisateur();
		assertEquals(Utilisateur.class, utilisateurService.saveUtilisateur(utilisateur));
	}
	
	//TEST DELETE------------------------------------------
	@Test
	public void testDelete() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateurService.deleteUtilisateur(utilisateur.getIdUtilisateur());
		assertEquals(null,utilisateurService.findOne(utilisateur.getIdUtilisateur()).isEmpty());
	}
	
}
