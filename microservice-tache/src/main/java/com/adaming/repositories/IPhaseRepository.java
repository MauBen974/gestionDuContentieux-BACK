package com.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Phase;

/**
 * @author VITTOZ Guillaume
 *
 */
@Repository
public interface IPhaseRepository extends JpaRepository<Phase, Long> {

}
