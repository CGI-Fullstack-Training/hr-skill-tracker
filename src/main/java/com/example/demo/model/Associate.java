package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Transactional
@Data
@Table(name = "associates")
@Entity
public class Associate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "associate_id")
	private String associateId;
	@Column(name = "associate_name")
	private String associateName;
	private String email;
	private String mobile;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_associate_id", referencedColumnName = "id")
	private Set<Skill> skill;
}
