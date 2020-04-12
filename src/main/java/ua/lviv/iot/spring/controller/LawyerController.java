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

import ua.lviv.iot.spring.business.LawyerService;

import ua.lviv.iot.spring.model.Lawyer;

@RequestMapping("/lawyer")
@RestController
public class LawyerController {
	private AtomicInteger idCounter = new AtomicInteger();
	@Autowired
	private LawyerService LawyerService;

	@GetMapping
	public List<Lawyer> getLawyer() {
		return new LinkedList<Lawyer>(LawyerService.findAll());
	}

	@GetMapping(path = "/{id}")
	public Lawyer getLawyer(@PathVariable("id") Integer LawyerId) {
		System.out.println(LawyerId);
		return LawyerService.findLawyer(LawyerId);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public Lawyer createLawyer(final @RequestBody Lawyer lawyer) {
		lawyer.setId(idCounter.incrementAndGet());
		return LawyerService.createLawyer(lawyer);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Lawyer> deleteLawyer(@PathVariable("id") Integer LawyerId) {
		if (LawyerService.checkIfLawyerExist(LawyerId)) {
			LawyerService.deleteLawyer(LawyerId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateLawyer(final @PathVariable("id") Integer LawyerId,
			final @RequestBody Lawyer lawyer) {
		lawyer.setId(LawyerId);
		Lawyer result = null;
		if (LawyerService.checkIfLawyerExist(LawyerId)) {
			result = LawyerService.updateLawyer(LawyerId, lawyer);
		}
		ResponseEntity<Object> status = result == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(result, HttpStatus.OK);
		LawyerService.updateLawyer(LawyerId, lawyer);

		return status;
	}
}
