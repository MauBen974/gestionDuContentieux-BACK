package com.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Phase;
import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
@Repository
public interface IPhaseRepository extends JpaRepository<Phase, Long> {

//	@Query(value = "UPDATE phase SET date_fin = NOW() WHERE id_phase =: id_phase", nativeQuery = true)
//	public Phase cloturePhase(@Param(value = "id_phase") Long idPhase);

	@Query(name = "SELECT * FROM phase WHERE tache like :tache")
	public List<Phase> findByTache(Tache tache);
}
