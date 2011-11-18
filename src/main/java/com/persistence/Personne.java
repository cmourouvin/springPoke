package com.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stepinfo.dao.beans.PersonneDAO;

@Component ("componentPersonne")
public class Personne {

	private Long id;
	private String nom;
	private String prenom;
	private Integer age;
	
	@Autowired
	private PersonneDAO dao;

	public Personne() {
		super();
	}
	
	public Personne(Long id, String nom, String prenom, Integer age) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	// Méthodes de récupération des données en base
	public Personne getPersonneById(Long id) {
		return dao.find(id);
	}
	
	public void creer() {
		dao.create(this);
		// dao.create(this.getClass())
	}
	
	// Méthodes divers
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", age=" + age + "]";
	}
	

}
