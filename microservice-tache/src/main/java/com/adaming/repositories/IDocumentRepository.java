package com.adaming.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adaming.entities.Affaire;
import com.adaming.entities.Document;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface IDocumentRepository extends JpaRepository<Document, Long> {
	@Query("select d from Document d where d.affaire like :x")
	public List<Document> chercherDocParAffaire(@Param(value="x")Affaire codeaff);
	
	@Query(value = "select d from Document d where d.archive like :x")
	public List<Document> findIfArchiveFalse(@Param(value="x") String nonArchive);
}
