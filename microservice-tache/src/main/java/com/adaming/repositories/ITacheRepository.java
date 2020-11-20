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

//	public List<Tache> findByIdUtilisateur(Long utilisateur);

	@Query(value = "SELECT * FROM tache WHERE tache.idTache=Tache_Phase.idTache INNER JOIN Tache_Phase.idPhase = phase.idPhase AND phase.libellePhase = :libellePhase", nativeQuery = true)
	public List<Tache> findBylibellePhase(@Param(value = "libellePhase") String libellePhase);

	@Query(value = "from Tache t where t.statusAudience is :statusAudience")
	public List<Tache> findByStatusAudience(@Param(value = "statusAudience") Boolean statusAudience);
	
	
}
