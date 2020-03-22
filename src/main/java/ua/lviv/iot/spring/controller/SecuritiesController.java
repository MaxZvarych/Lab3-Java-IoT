package ua.lviv.iot.spring.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

import ua.lviv.iot.model.Securities;

@RequestMapping("/securities")
@RestController
public class SecuritiesController {
	private Map<Integer, Securities> securities = new HashMap();
	private AtomicInteger idCounter = new AtomicInteger();

	@GetMapping
	public List<Securities> getStudents() {
		return new LinkedList<Securities>(securities.values());
	}

	@GetMapping(path = "/{id}")
	public Securities getStudent(@PathVariable("id") Integer studentId) {
		System.out.println(studentId);
		return securities.get(studentId);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public Securities createStudent(final @RequestBody Securities security) {
		System.out.println(security);
		security.setId(idCounter.incrementAndGet());
		securities.put(security.getId(), security);

		return security;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Securities> deleteStudent(@PathVariable("id") Integer studentId) {
		HttpStatus status = securities.remove(studentId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return ResponseEntity.status(status).build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Securities> updateStudent(final @PathVariable("id") Integer studentId,
			final @RequestBody Securities student) {
		student.setId(studentId);
		HttpStatus status;
		if (securities.containsKey(studentId)) {
			securities.put(studentId, student);
			status = HttpStatus.OK;
			return ResponseEntity.status(status).build();
		} else {
			status = HttpStatus.NOT_FOUND;
			return ResponseEntity.status(status).build();
		}

	}
}
