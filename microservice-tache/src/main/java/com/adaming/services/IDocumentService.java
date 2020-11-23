package com.adaming.services;

import java.util.List;
import java.util.Optional;


import com.adaming.entities.Document;

public interface IDocumentService {

	List<Document> findAll();
	Optional<Document> findOne(Long id);
	Document save(Document document);
	boolean delete(Long id);
}
