package com.gestionTemps.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gestionTemps.beans.Marque;
import com.gestionTemps.beans.Tache;
import com.gestionTemps.dao.TacheDAO;
import com.mysql.jdbc.PreparedStatement;

public class TacheDAOImpl implements TacheDAO {

	@Override
	public Tache ajouterTache(Tache tache) {
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "INSERT INTO `taches`(`nom_tache`, `description_tache`, `date_creation`, `date_limite`, `priorite`, `liste_id`) VALUES (?, ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, tache.getNomTache());
			preparedStatement.setString(2, tache.getDescriptionTache());
			preparedStatement.setString(3, sdf.format(tache.getDateDeCreationDeTache()));
			preparedStatement.setString(4, sdf.format(tache.getDateLimiteDeTache()));
			preparedStatement.setInt(5, tache.getPriorite());
			preparedStatement.setLong(6, tache.getListeID());
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
		return tache;
	}

	@Override
	public void supprimerTache(Long tacheID) {
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "DELETE FROM `taches` WHERE `id_tache` = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, tacheID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterMarqueDansTache(Long tacheID, Marque marque) {
		MarqueDAOImpl marqueDAOImpl = new MarqueDAOImpl();
		Marque m = marqueDAOImpl.recupererMarque(marque.getIdMarque());
		Connection conn = DatabaseUtility.loadDatabase();
		String sql;
		if(m == null) {
			marqueDAOImpl.ajouterMarque(marque);
		}
		sql = "INSERT INTO `taches_marques`(`tache`, `marque`) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, tacheID);
			preparedStatement.setLong(2, marque.getIdMarque());
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
	}

	@Override
	public void supprimerMarqueDeTache(Long tacheID, Long marqueID) {
		MarqueDAOImpl marqueDAOImpl = new MarqueDAOImpl();
		Marque m = marqueDAOImpl.recupererMarque(marqueID);
		
		if(m == null) return;
		
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "DELETE FROM `taches_marques` WHERE `tache` = ? and `marque` = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, tacheID);
			preparedStatement.setLong(2, marqueID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Tache recupererTache(Long tacheID) {
		List<Tache> taches = new ArrayList<Tache>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `taches` WHERE `id_tache` = " + tacheID.toString());
			while(resultat.next()) {
				Long tacheId = resultat.getLong("id_tache");
				String tacheNom = resultat.getString("nom_tache");
				String tacheDesription = resultat.getString("description_tache");
				Date dateCreation = resultat.getDate("date_creation");
				Date dateLimite = resultat.getDate("date_limite");
				int priorite = resultat.getInt("priorite");
				Long listeID = resultat.getLong("liste_id");
				Tache tache = new Tache();
				tache.setIdTache(tacheId);
				tache.setNomTache(tacheNom);
				tache.setDescriptionTache(tacheDesription);
				tache.setDateDeCreationDeTache(dateCreation);
				tache.setDateLimiteDeTache(dateLimite);
				tache.setPriorite(priorite);
				tache.setListeID(listeID);
				taches.add(tache);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(taches.isEmpty())
			return null;
		else
			return taches.get(0);
	}

	@Override
	public List<Tache> recupererToutesLesTaches() {
		List<Tache> taches = new ArrayList<Tache>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `taches`");
			while(resultat.next()) {
				Long tacheID = resultat.getLong("id_tache");
				String tacheNom = resultat.getString("nom_tache");
				String tacheDesription = resultat.getString("description_tache");
				Date dateCreation = resultat.getDate("date_creation");
				Date dateLimite = resultat.getDate("date_limite");
				int priorite = resultat.getInt("priorite");
				Long listeID = resultat.getLong("liste_id");
				Tache tache = new Tache();
				tache.setIdTache(tacheID);
				tache.setNomTache(tacheNom);
				tache.setDescriptionTache(tacheDesription);
				tache.setDateDeCreationDeTache(dateCreation);
				tache.setDateLimiteDeTache(dateLimite);
				tache.setPriorite(priorite);
				tache.setListeID(listeID);
				taches.add(tache);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return taches;
	}

}
