package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Associate;
import com.example.demo.model.AssociateNotFoundException;
import com.example.demo.repository.AssociateRepository;

@Service
public class AssociateServiceImpl implements AssociateService {

	@Autowired
	private AssociateRepository associateRepository;

	@Override
	public Associate createAssociate(Associate associate) {
		return associateRepository.save(associate);
	}

	@Override
	public Associate findByAssociateId(String associateId) {
		return associateRepository.findByAssociateId(associateId);
	}

	@Override
	public Associate findByAssociateName(String associateName) {
		return associateRepository.findByAssociateName(associateName);
	}

	@Override
	public Associate findByEmail(String email) {
		return associateRepository.findByEmail(email);
	}

	@Override
	public Associate findByMobile(String mobile) {
		return associateRepository.findByEmail(mobile);
	}

	@Override
	public Associate findBySkill(String skill) {
		return associateRepository.findBySkill(skill);
	}

	@Override
	public Associate updateAssociate(Associate associate) {
		return associateRepository.save(associate);
	}

	@Override
	public String depeteAssociate(int id) {
		Associate associate = associateRepository.findById(id)
				.orElseThrow(() -> new AssociateNotFoundException("Associate with Id :: " + id + "Not Found"));

		associateRepository.delete(associate);

		return "Associate with ID:: " + id + " not found";

	}

	@Override
	public Associate findById(int id) {

		return associateRepository.findById(id)
				.orElseThrow(() -> new AssociateNotFoundException("Associate with Id :: " + id + "Not Found"));

	}

	@Override
	public List<Associate> findAllassociates() {
		return associateRepository.findAll();
	}

}
