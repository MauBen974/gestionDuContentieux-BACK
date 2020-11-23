package com.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
@Repository
public interface ITacheRepository extends JpaRepository<Tache, Long> {

	public List<Tache> findByIdUtilisateur(Long utilisateur);

	@Query(value = "SELECT DISTINCT * FROM tache, phase WHERE tache.id_tache = phase.id_tache AND phase.libelle_phase = :libellePhase", nativeQuery = true)
	public List<Tache> findBylibellePhase(@Param(value = "libellePhase") String libellePhase);


//	@Query(value = "SELECT * FROM tache WHERE status_audience = :statusAudience", nativeQuery = true)
	@Query(value = "from Tache t where t.statusAudience is :statusAudience")
	public List<Tache> findByStatusAudience(@Param(value = "statusAudience") Boolean statusAudience);
	
	// Update phase d'une tache
}
