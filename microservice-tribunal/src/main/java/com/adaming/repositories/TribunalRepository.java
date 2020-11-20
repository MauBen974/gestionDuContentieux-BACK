package com.adaming.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adaming.entities.Tribunal;

@Repository
public interface TribunalRepository extends JpaRepository<Tribunal, Long> {
	
	public List<Tribunal> findAllTribunalByArchiveFalse();
	
	public List<Tribunal> findAllTribunalByArchiveTrue();


}
