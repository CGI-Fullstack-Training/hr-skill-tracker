package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Associate;

public interface AssociateRepository extends JpaRepository<Associate, Integer> {

	@Query
	public Associate findByAssociateId(String associateId);

	@Query
	public Associate findByAssociateName(String associateName);

	@Query
	public Associate findByEmail(String email);

	@Query
	public Associate findByMobile(String mobile);

	@Query
	public Associate findBySkill(String skill);
}
