package com.example.demo.controller;

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

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/skill")
@Slf4j
public class SkillController {

	@Autowired
	private SkillService skillService;

	@PostMapping
	public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {

		return ResponseEntity.status(HttpStatus.CREATED).body(skillService.addSkill(skill));

	}

	@GetMapping("/{id}")
	public ResponseEntity<Skill> findSkillById(@PathVariable("id") int id) {
		log.info("skills are {} ",skillService.findSkillById(id));
		return ResponseEntity.status(HttpStatus.OK).body(skillService.findSkillById(id));
	}

	@PutMapping
	public ResponseEntity<Skill> updateSkillById(@RequestBody Skill skill) {
		return ResponseEntity.ok(skillService.updateSkill(skill));
	}

	@DeleteMapping("/{id}")
	public void deleteSkillById(@PathVariable("id") int id) {
		skillService.deleteSkillById(id);
	}
}
