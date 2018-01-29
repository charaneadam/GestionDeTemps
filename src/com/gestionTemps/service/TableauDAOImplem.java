package com.gestionTemps.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.gestionTemps.beans.Liste;
import com.gestionTemps.beans.Tableau;
import com.gestionTemps.dao.TableauDAO;
import com.mysql.jdbc.PreparedStatement;

public class TableauDAOImplem implements TableauDAO {

	@Override
	public Tableau ajouterTableau(Tableau tableau) {
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "INSERT INTO `tableaux`(`nom_tableau`, `desc_tableau`) VALUES (?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setString(1, tableau.getNomTableau());
			preparedStatement.setString(2, tableau.getDescriptionTableau());
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
		
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
		List<Liste> listes = tableauDAOImplem.recupererToutesLesListesDuTableau(tableauID);
		Iterator<Liste> it = listes.iterator();
		while(it.hasNext()) {
			listeDAOImpl.supprimerListe(it.next().getIdListe());
		}
		
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
		Connection conn = DatabaseUtility.loadDatabase();
		String sql;
		liste = listeDAOImpl.ajouterListe(liste);
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
	public Tableau recupererTableau(Long tableauID) {
		List<Tableau> tableaux = new ArrayList<Tableau>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `tableaux` WHERE `id_tableau` = " + tableauID.toString());
			while(resultat.next()) {
				Long tableauId = resultat.getLong("id_tableau");
				String tableauNom = resultat.getString("nom_tableau");
				String tableauDesc = resultat.getString("desc_tableau");
				Tableau tableau = new Tableau();
				tableau.setIdTableau(tableauId);
				tableau.setNomTableau(tableauNom);
				tableau.setDescriptionTableau(tableauDesc);
				tableaux.add(tableau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(tableaux.isEmpty())
			return null;
		else {
			return tableaux.get(0);
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
				String tableauDesc = resultat.getString("desc_tableau");
				Tableau tableau = new Tableau();
				tableau.setIdTableau(tableauID);
				tableau.setNomTableau(tableauNom);
				tableau.setDescriptionTableau(tableauDesc);
				tableaux.add(tableau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
		return tableaux;
	}
	
	@Override
	public List<Liste> recupererToutesLesListesDuTableau(Long tableauID){
		List<Liste> listes = new ArrayList<Liste>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `tableaux_listes` WHERE `tableau` = " + tableauID.toString());
			Set<Long> listes_id = new HashSet<Long>();
			while(resultat.next()) {
				listes_id.add(resultat.getLong("liste"));
			}
			Iterator<Long> it = listes_id.iterator();
			ListeDAOImpl listeDAOImpl = new ListeDAOImpl();
			while(it.hasNext()) {
				listes.add(listeDAOImpl.recupererListe(it.next()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listes;
	}

}
