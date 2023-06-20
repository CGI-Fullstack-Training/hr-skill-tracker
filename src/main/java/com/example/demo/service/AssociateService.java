package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Associate;

public interface AssociateService {

	public Associate createAssociate(Associate associate);

	public Associate findByAssociateId(String associateId);

	public Associate findByAssociateName(String associateName);

	public Associate findByEmail(String email);

	public Associate findByMobile(String mobile);

	public Associate findBySkill(String skill);

	public Associate updateAssociate(Associate associate);

	public String depeteAssociate(int id);

	public Associate findById(int id);

	public List<Associate> findAllassociates();
}
