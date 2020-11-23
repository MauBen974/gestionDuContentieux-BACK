package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Document;
import com.adaming.repositories.IDocumentRepository;
@Service
public class DocumentServiceImpl implements IDocumentService {
	@Autowired
	IDocumentRepository iDocumentRepository;
	@Override
	public List<Document> findAll() {
		// TODO Auto-generated method stub
		return iDocumentRepository.findAll();
	}

	@Override
	public Optional<Document> findOne(Long id) {
		// TODO Auto-generated method stub
		return iDocumentRepository.findById(id);
	}

	@Override
	public Document save(Document document) {
		// TODO Auto-generated method stub
		return iDocumentRepository.save(document);
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		iDocumentRepository.deleteById(id);
		return true;
	}

}
