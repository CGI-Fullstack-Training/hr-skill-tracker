package com.example.demo.service;

import com.example.demo.model.Skill;

public interface SkillService {

	public Skill addSkill(Skill skill);

	public Skill updateSkill(Skill skill);

	public void deleteSkillById(int id);

	public Skill findSkillById(int id);

}
