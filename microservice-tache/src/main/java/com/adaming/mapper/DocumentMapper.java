package com.adaming.mapper;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.adaming.dto.DocumentDTO;
import com.adaming.entities.Document;
@Component
public class DocumentMapper implements IDocumentMapper  {
	ModelMapper modelMapper	=new ModelMapper();
	@Override
	public DocumentDTO convertToDocumentDTO(Document document) {
		
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		DocumentDTO documentDTO=modelMapper.map(document,DocumentDTO.class);

		return documentDTO;

	}

	@Override
	public Document convertToDocument(DocumentDTO documentDTO) {
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Document document=modelMapper.map(documentDTO,Document.class);

			return document;	
	}
	
	@Override
	public Optional<DocumentDTO> convertToDocumentDTO(Optional<Document> document) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<DocumentDTO> documentDto = modelMapper.map(document, Optional.class);
		return documentDto;
	}

}
