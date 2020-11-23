package com.adaming.mapper;

import java.util.Optional;

import com.adaming.dto.DocumentDTO;
import com.adaming.entities.Document;

public interface IDocumentMapper {
	DocumentDTO convertToDocumentDTO(Document document);
	Document convertToDocument(DocumentDTO documentDTO);
	Optional<DocumentDTO> convertToDocumentDTO(Optional<Document> document);
}
