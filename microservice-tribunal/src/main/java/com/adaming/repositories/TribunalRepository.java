package com.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Tribunal;

@Repository
public interface TribunalRepository extends JpaRepository<Tribunal, Long> {

}
