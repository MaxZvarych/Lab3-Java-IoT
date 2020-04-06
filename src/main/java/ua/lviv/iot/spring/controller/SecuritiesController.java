package ua.lviv.iot.spring.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

import ua.lviv.iot.spring.business.SecuritiesService;
import ua.lviv.iot.spring.model.Securities;

@RequestMapping("/securities")
@RestController
public class SecuritiesController {
	private Map<Integer, Securities> securities = new HashMap<>();
	private AtomicInteger idCounter = new AtomicInteger();
	@Autowired
	private SecuritiesService securitiesService;

	@GetMapping
	public List<Securities> getStudents() {
		return new LinkedList<Securities>(securitiesService.findAll());
	}

	@GetMapping(path = "/{id}")
	public Securities getStudent(@PathVariable("id") Integer securityId) {
		System.out.println(securityId);
		return securitiesService.findSecurity(securityId);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public Securities createStudent(final @RequestBody Securities security) {
		security.setId(idCounter.incrementAndGet());
		return securitiesService.createSecurities(security);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Securities> deleteStudent(@PathVariable("id") Integer securitytId) {
		if (securitiesService.checkIfSecurityExist(securitytId)) {
			securitiesService.deleteSecurity(securitytId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Object> updateStudent(final @PathVariable("id") Integer securityId,
			final @RequestBody Securities security) {
		security.setId(securityId);
		Securities result = null;
		if (securitiesService.checkIfSecurityExist(securityId)) {
			result = securitiesService.updateSecurity(securityId, security);
		}
		ResponseEntity<Object> status = result == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(result, HttpStatus.OK);
		securitiesService.updateSecurity(securityId, security);

		return status;
	}
}
