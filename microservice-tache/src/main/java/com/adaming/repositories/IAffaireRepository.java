package com.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Affaire;
@Repository
public interface IAffaireRepository extends JpaRepository<Affaire, Long> {
	@Query(value = "select d from Affaire d where d.status like :x")
	public List<Affaire> findByStatus(@Param(value="x" )String quelstatus);
}
