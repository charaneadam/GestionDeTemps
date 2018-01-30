package com.gestionTemps.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionTemps.beans.Tableau;
import com.gestionTemps.beans.Utilisateur;
import com.gestionTemps.dao.UtilisateurDAO;
import com.mysql.jdbc.PreparedStatement;

public class UtilisateurDOAImpl implements UtilisateurDAO {

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "INSERT INTO `utilisateurs`(`nom_utilisateur`, `prenom_utilisateur`, `emailUtilisateur`) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, utilisateur.getNomUtilisateur());
			preparedStatement.setString(2, utilisateur.getPrenomUtilisateur());
			preparedStatement.setString(3, utilisateur.getEmailUtilisateur());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			utilisateur.setIdUtilisateur(rs.getLong(1));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateur;
	}

	@Override
	public void supprimerUtilisateur(Long idUtilisateur) {
		
		Connection conn = DatabaseUtility.loadDatabase();
		String sql = "DELETE FROM `utilisateurs` WHERE `id_utilisateur` = ?";
		PreparedStatement preparedStatement = null;
		TableauDAOImplem tableauDAOImplem = new TableauDAOImplem();
		List<Tableau> tableaux = tableauDAOImplem.recpererTousLesTableaux(idUtilisateur);
		for (Tableau tableau : tableaux) {
			tableauDAOImplem.supprimerTableau(tableau.getIdTableau());
		}
		try {
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			preparedStatement.setLong(1, idUtilisateur);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
		}
		
	}

	@Override
	public Utilisateur recupererUtilisateur(Long idUtilisateur) {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection conn = DatabaseUtility.loadDatabase();
        Statement statement;
		try {
			statement = conn.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM `utilisateurs` WHERE `id_utilisateur` = " + idUtilisateur.toString());
			while(resultat.next()) {
				// `id_utilisateur`, `nom_utilisateur`, `prenom_utilisateur`, `emailUtilisateur`
				String nom_utilisateur = resultat.getString("nom_utilisateur");
				String prenom_utilisateur = resultat.getString("prenom_utilisateur");
				String emailUtilisateur = resultat.getString("emailUtilisateur");
				Utilisateur utilisateur = new Utilisateur(nom_utilisateur, prenom_utilisateur, emailUtilisateur);
				utilisateur.setIdUtilisateur(idUtilisateur);
				utilisateurs.add(utilisateur);
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
		if(utilisateurs.isEmpty())
			return null;
		else {
			return utilisateurs.get(0);
		}
	}

}
