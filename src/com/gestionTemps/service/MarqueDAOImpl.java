package com.gestionTemps.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionTemps.beans.Marque;
import com.gestionTemps.dao.MarqueDAO;
import com.mysql.jdbc.PreparedStatement;

public class MarqueDAOImpl implements MarqueDAO {

	@Override
	public Marque ajouterMarque(Marque marque) {
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "INSERT INTO `marques`(`nom_marque`) VALUES (?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, marque.getNomMarque());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return marque;
	}

	@Override
	public void supprimerMarque(Long marqueID) {

		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "DELETE FROM `marques` WHERE `id_marque` = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, marqueID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public Marque recupererMarque(Long marqueID) {
		List<Marque> marques = new ArrayList<Marque>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `marques` WHERE `id_marque` = " + marqueID.toString());
			while(resultat.next()) {
				Long marqueId = resultat.getLong("id_marque");
				String marqueNom = resultat.getString("nom_marque");
				Marque marque = new Marque();
				marque.setIdMarque(marqueId);
				marque.setNomMarque(marqueNom);
				marques.add(marque);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(marques.isEmpty())
			return null;
		else
			return marques.get(0);
	}

	@Override
	public List<Marque> recupererToutesLesMarques() {
		List<Marque> marques = new ArrayList<Marque>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `marques`");
			while(resultat.next()) {
				Long idMarque = resultat.getLong("id_marque");
				String nomMarque = resultat.getString("nom_marque");
				Marque marque = new Marque();
				marque.setIdMarque(idMarque);
				marque.setNomMarque(nomMarque);
				marques.add(marque);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return marques;
	}

}