package com.stepinfo.dao.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.persistence.Personne;
import com.stepinfo.dao.ObjectDAO;

public class PersonneDAO extends ObjectDAO<Personne> {

	@Override
	public Personne find(long id) {

		System.out.println("Passage dans le find de le l'object DAO : "
				+ Personne.class + " pour l'id = " + id);

		Personne pers = new Personne();
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(
					"SELECT * FROM personne WHERE id = " + id);
			if (result.first())
				pers = new Personne(id, result.getString("nom"), result.getString("prenom"), Integer.parseInt(result.getString("age")));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pers;
	}

	@Override
	public Personne create(Personne obj) {

		System.out.println("Passage dans le create de le l'object DAO : "
				+ Personne.class);

		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE).executeQuery(
					"INSERT INTO personne VALUE (?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Personne update(Personne obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Personne obj) {
		// TODO Auto-generated method stub

	}

}
