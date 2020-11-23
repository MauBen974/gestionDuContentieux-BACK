package com.adaming.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.adaming.beans.AffaireBean;
import com.adaming.beans.DocumentBean;
import com.adaming.beans.PhaseBean;
import com.adaming.beans.TacheBean;

@FeignClient(name = "microservice-tache")
//@RibbonClient(name = "microservice-tache")
public interface MicroServiceTacheProxies {
	
	@GetMapping(value = "/phases")
	List<PhaseBean> getAllPhases();

	@GetMapping(value = "/phases/{pId}")
	PhaseBean findOnePhase(@PathVariable(value = "pId") Long id);

	@PostMapping(value = "/phases")
	PhaseBean savePhase(@RequestBody PhaseBean pIn);

	@DeleteMapping(value = "phases/{pId}")
	void deletePhase(@PathVariable(value = "pId") Long id);

	@PutMapping(value = "phases/{pId}")
	public PhaseBean updatePhase(@PathVariable(value = "pId") Long id, @RequestBody PhaseBean pIn);
	
	@GetMapping(value = "/taches")
	public List<TacheBean> getAllTache();

	@GetMapping(value = "/tachesById/{tId}")
	public TacheBean findOneTache(@PathVariable(value = "tId") Long id);

	@PostMapping(value = "/taches")
	public TacheBean saveTache(@RequestBody TacheBean tIn);

	@DeleteMapping(value = "taches/{tId}")
	public void deleteTache(@PathVariable(value = "tId") Long id);

	@PutMapping(value = "taches/{tId}")
	public TacheBean updateTache(@PathVariable(value = "tId") Long id, @RequestBody TacheBean tIn);

	@GetMapping(value = "tachesLibelle/{libellePhase}")
	public List<TacheBean> findTacheBylibellePhase(@PathVariable(value = "libellePhase") String libellePhase);

	@GetMapping(value = "tachesAudience/{statusAudience}")
	public List<TacheBean> findTacheByStatusAudience(@PathVariable(value = "statusAudience") Boolean statusAudience);
	
	@GetMapping(value = "tachesUtilisateur/{idUtilisateur}")
	public List<TacheBean> findByIdUtilisateur(@PathVariable(value = "idUtilisateur") Long idUtilisateur);
	
	@GetMapping(value = "tachesTribunal/{idTribunal}")
	public List<TacheBean> findByIdTribunal(@PathVariable(value = "idTribunal") Long idTribunal);

	@GetMapping("/document")
	public List<DocumentBean> findAllDocument();

	@GetMapping("/document/{id}")
	public Optional<DocumentBean> findOneDocument(@PathVariable Long id) ;
	
	@GetMapping("/chercherDocParAffaire/{codeaff}")
	public List<DocumentBean> chercherDocParAffaire(@PathVariable(value="codeaff") AffaireBean codeaff);
	
	@GetMapping(value = "/docNonArchive/{nonArchive}")
	public List<DocumentBean> findIfArchiveFalse(@PathVariable(value="nonArchive") Boolean nonArchive);

	@PostMapping("/document")
	public DocumentBean save(@RequestBody DocumentBean document) ;

	@PutMapping("/document/{id}")
	public DocumentBean MiseAJour(@PathVariable Long id,@RequestBody DocumentBean d);
	
	@DeleteMapping("/document/{id}")
	public String delete(@PathVariable Long id);


	@GetMapping("/affaire")
	public List<AffaireBean> findAllAffaire();

	@GetMapping("/affaire/{id}")
	public Optional<AffaireBean> findOneAffaire(@PathVariable Long id);
	
	@GetMapping("/affaireParStatus/{quelstatus}")
	public List<AffaireBean> findByStatus(@PathVariable String quelstatus);

	@PostMapping("/affaire")
	public AffaireBean save(@RequestBody AffaireBean affaire);
	
	@PutMapping("/affaire/{id}")
	public AffaireBean MiseAJour(@PathVariable Long id,@RequestBody AffaireBean a);

	@DeleteMapping("/affaire/{id}")
	public String deleteAffaire(@PathVariable Long id);

}

