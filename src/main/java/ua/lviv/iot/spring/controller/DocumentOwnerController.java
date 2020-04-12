package ua.lviv.iot.spring.controller;

import java.util.LinkedList;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.spring.business.DocumentOwnerService;

import ua.lviv.iot.spring.model.DocumentOwner;

@RequestMapping("/documentOwner")
@RestController
public class DocumentOwnerController {
	private AtomicInteger idCounter = new AtomicInteger();
	@Autowired
	private DocumentOwnerService documentOwnerService;

	@GetMapping
	public List<DocumentOwner> getDocumentOwners() {
		return new LinkedList<DocumentOwner>(documentOwnerService.findAll());
	}

	@GetMapping(path = "/{id}")
	public DocumentOwner getDocumentOwner(@PathVariable("id") Integer documentOwnerId) {
		System.out.println(documentOwnerId);
		return documentOwnerService.findDocumentOwner(documentOwnerId);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public DocumentOwner createDocumentOwner(final @RequestBody DocumentOwner documentOwner) {
		documentOwner.setId(idCounter.incrementAndGet());
		return documentOwnerService.createDocumentOwner(documentOwner);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<DocumentOwner> deleteDocumentOwner(@PathVariable("id") Integer documentOwnerId) {
		if (documentOwnerService.checkIfDocumentOwnerExist(documentOwnerId)) {
			documentOwnerService.deleteDocumentOwner(documentOwnerId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateDocumentOwner(final @PathVariable("id") Integer documentOwnerId,
			final @RequestBody DocumentOwner documentOwner) {
		documentOwner.setId(documentOwnerId);
		DocumentOwner result = null;
		if (documentOwnerService.checkIfDocumentOwnerExist(documentOwnerId)) {
			result = documentOwnerService.updateDocumentOwner(documentOwnerId, documentOwner);
		}
		ResponseEntity<Object> status = result == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(result, HttpStatus.OK);
		documentOwnerService.updateDocumentOwner(documentOwnerId, documentOwner);

		return status;
	}
}
