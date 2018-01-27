package com.gestionTemps.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.dao.TableauDAO;
import com.mysql.jdbc.PreparedStatement;

public class TableauDAOImplem implements TableauDAO {

	@Override
	public Tableau ajouterTableau(Tableau tableau) {
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "INSERT INTO `tableaux`(`nom_tableau`) VALUES (?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, tableau.getNomTableau());
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
		return tableau;
	}

	@Override
	public void supprimerTableau(Long tableauID) {
		
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "DELETE FROM `tableaux` WHERE `id_tableau` = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, tableauID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void ajouterListeAuTableau(Liste liste) {
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		Liste l = listeDAOImpl.recupererListe(liste.getIdListe());
		Connection conn = DatabaseUtility.loadDatabase();
		String sql;
		if(l == null) {
			listeDAOImpl.ajouterListe(liste);
		}
		sql = "INSERT INTO `tableaux_listes`(`tableau`, `liste`) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, liste.getTableauID());
			preparedStatement.setLong(2, liste.getIdListe());
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
	public void supprimerListeDuTableau(Long listeID) {
		
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		Liste l = listeDAOImpl.recupererListe(listeID);
		
		if(l == null) return;
		
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "DELETE FROM `tableaux_listes` WHERE `tableau` = ? and `liste` = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, l.getTableauID());
			preparedStatement.setLong(2, listeID);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Tableau> recpererTousLesTableaux() {
		List<Tableau> tableaux = new ArrayList<Tableau>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `tableaux`");
			while(resultat.next()) {
				Long tableauID = resultat.getLong("id_tableau");
				String tableauNom = resultat.getString("nom_tableau");
				Tableau tableau = new Tableau();
				tableau.setIdTableau(tableauID);
				tableau.setNomTableau(tableauNom);
				tableaux.add(tableau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		return tableaux;
	}

}
