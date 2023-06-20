package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Skill addSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	@Override
	public Skill updateSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	@Override
	public void deleteSkillById(int id) {
		skillRepository.deleteById(id);
		;
	}

	@Override
	public Skill findSkillById(int id) {
		Optional<Skill> optionalSkill = skillRepository.findById(id);
		if (optionalSkill.isPresent()) {
			return optionalSkill.get();
		}
		return null;
	}

}
