package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Associate;
import com.example.demo.service.AssociateService;

@RestController
@RequestMapping("/associate")
public class AssociateController {

	@Autowired
	private AssociateService associateService;

	@GetMapping
	public ResponseEntity<List<Associate>> findAllassociates() {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findAllassociates());
	}
	
	@PostMapping
	public ResponseEntity<Associate> createAssociate(@RequestBody Associate associate) {
		return ResponseEntity.status(HttpStatus.CREATED).body(associateService.createAssociate(associate));

	}

	@GetMapping("/{id}")
	public ResponseEntity<Associate> findById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findById(id));
	}

	@GetMapping("/associateId/{associateId}")
	public ResponseEntity<Associate> findByAssociateId(@PathVariable("associateId") String associateId) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findByAssociateId(associateId));
	}

	@GetMapping("/associateName/{associateName}")
	public ResponseEntity<Associate> findByAssociateName(@PathVariable("associateName") String associateName) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findByAssociateName(associateName));
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<Associate> findByEmail(@PathVariable("email") String email) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findByEmail(email));
	}

	@GetMapping("/mobile/{mobile}")
	public ResponseEntity<Associate> findByMobile(@PathVariable("mobile") String mobile) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findByMobile(mobile));
	}

	@GetMapping("/skill/{skill}")
	public ResponseEntity<Associate> findBySkill(@PathVariable("skill") String skill) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.findBySkill(skill));
	}

	@PutMapping
	public ResponseEntity<Associate> updateAssociate(@RequestBody Associate associate) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.updateAssociate(associate));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> depeteAssociateById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(associateService.depeteAssociate(id));
	}
}
