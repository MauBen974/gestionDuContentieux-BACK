package com.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Phase;

/**
 * @author VITTOZ Guillaume
 *
 */
@Repository
public interface IPhaseRepository extends JpaRepository<Phase, Long> {

	@Query(value = "UPDATE phase SET date_fin = NOW() WHERE id_phase =: id_phase", nativeQuery = true)
	public Phase cloturePhase(@Param(value = "id_phase") Long idPhase);
}
