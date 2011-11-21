package com.persistence;

import java.util.Date;

public class Client {

	private Long id;
	private String numero;
	private Date date_inscription;
	private String adresse_facturation ;

	public Client(Long id, String numero, Date date_inscription,
			String adresse_facturation) {
		super();
		this.id = id;
		this.numero = numero;
		this.date_inscription = date_inscription;
		this.adresse_facturation = adresse_facturation;
	}
	
	public Client() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDate_inscription() {
		return date_inscription;
	}

	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

	public String getAdresse_facturation() {
		return adresse_facturation;
	}

	public void setAdresse_facturation(String adresse_facturation) {
		this.adresse_facturation = adresse_facturation;
	} 

}
