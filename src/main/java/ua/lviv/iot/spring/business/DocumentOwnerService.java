package ua.lviv.iot.spring.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spring.dataaccess.DocumentOwnerRepository;

import ua.lviv.iot.spring.model.DocumentOwner;

@Service
public class DocumentOwnerService {
	@Autowired
	private DocumentOwnerRepository documentOwnerRepository;

	public DocumentOwner createDocumentOwner(DocumentOwner documentOwner) {
		return documentOwnerRepository.save(documentOwner);

	}

	public List<DocumentOwner> findAll() {
		return documentOwnerRepository.findAll();
	}

	public DocumentOwner findDocumentOwner(Integer id) {
		return documentOwnerRepository.getOne(id);
	}

	public void deleteDocumentOwner(Integer id) {
		documentOwnerRepository.deleteById(id);
	}

	public boolean checkIfDocumentOwnerExist(Integer id) {
		return documentOwnerRepository.existsById(id);
	}

	public DocumentOwner updateDocumentOwner(Integer id, DocumentOwner documentOwner) {
		DocumentOwner firstDocumentOwner = documentOwnerRepository.findById(id).get();
		DocumentOwner oldDocumentOwner = new DocumentOwner(firstDocumentOwner.getName());
		oldDocumentOwner.setId(id);
		documentOwner.setId(id);
		documentOwnerRepository.save(documentOwner);
		return oldDocumentOwner;
	}

}
