package com.sql.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.sql.bean.DocumentsList;
import com.sql.connection.SQLConnection;
import com.sql.dao.DAO;

public class DocumentDAO extends DAO<DocumentsList> {
	public DocumentDAO(Connection conn) {
		super(SQLConnection.getInstance());
	}

	@Override
	public boolean create(DocumentsList obj) {
		
		return false;
	}

	@Override
	public boolean delete(DocumentsList obj) {
		
		return false;
	}

	@Override
	public boolean update(DocumentsList obj) {
		
		return false;
	}

	@Override
	public DocumentsList find(String IdCote) {
		DocumentsList document = new DocumentsList();
		
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("Select * FROM Documents WHERE IdCote "
							+ "= " + IdCote);
			if (result.first()) {
				document = new DocumentsList(
						IdCote,
						result.getString("Titre"),
						result.getString("Auteur"),
						result.getString("typeDoc"), 
						result.getString("Genre"), 
						result.getBoolean("Disponible"), 
						result.getInt("Caution")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return document;
	}
	
	public ArrayList<DocumentsList> findAuteur(String cau) {
		
		DocumentsList docAuteur = new DocumentsList();
		
		ArrayList<DocumentsList> listAuteur = new ArrayList<>();
		
		String sqlString;
		if (cau!=null) {
			 sqlString = "SELECT * FROM Documents WHERE Auteur ='"+cau+"'";
		} else {
			 sqlString = "Select * from documents";
		}
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(sqlString);
			while (result.next()) {
				
				//docAuteur = new Document(
				listAuteur.add(new DocumentsList(		
						result.getString("IdCote"),
						result.getString("Titre"),
						result.getString("Auteur"),
						result.getString("typeDoc"), 
						result.getString("Genre"), 
						result.getBoolean("Disponible"), 
						result.getInt("Caution"))); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAuteur;
	}
	
	// pour les titres
	public ArrayList<DocumentsList> findTitre(String cti) {
		
		
		ArrayList<DocumentsList> listTitre = new ArrayList<>();
		
		String sqlString;
		if (cti!=null) {
			 sqlString = "SELECT * FROM Documents WHERE titre ='"+cti+"'" ;
		} else {
			 sqlString = "Select * from documents";
		}
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(sqlString);
			while (result.next()) {
				
				//docTitre = new Document(
				listTitre.add(new DocumentsList(		
						result.getString("IdCote"),
						result.getString("Titre"),
						result.getString("Auteur"),
						result.getString("typeDoc"), 
						result.getString("Genre"), 
						result.getBoolean("Disponible"), 
						result.getInt("Caution"))); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTitre;
	}
	
	public ArrayList<DocumentsList> getList(String lisA){
		ArrayList<DocumentsList> listByAuteur = new ArrayList<>();
		String sqlString;
		if (lisA!=null) {
			 sqlString = "SELECT * FROM Documents ";
		} else {
			 sqlString = "Select * from documents group by auteur";
		}
		
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(sqlString);
			while (result.next()) {
				
				//docAuteur = new Document(
				listByAuteur.add(new DocumentsList(		
						result.getString("IdCote"),
						result.getString("Titre"),
						result.getString("Auteur"),
						result.getString("typeDoc"), 
						result.getString("Genre"), 
						result.getBoolean("Disponible"), 
						result.getInt("Caution"))); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listByAuteur;
	}
	public ArrayList<DocumentsList> getListG(String lisA){
		ArrayList<DocumentsList> listByGenre = new ArrayList<>();
		String sqlString;
		if (lisA!=null) {
			 sqlString = "SELECT * FROM Documents ";
		} else {
			 sqlString = "Select * from documents group by genre";
		}
		
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(sqlString);
			while (result.next()) {
				
				//docAuteur = new Document(
				listByGenre.add(new DocumentsList(		
						result.getString("IdCote"),
						result.getString("Titre"),
						result.getString("Auteur"),
						result.getString("typeDoc"), 
						result.getString("Genre"), 
						result.getBoolean("Disponible"), 
						result.getInt("Caution"))); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listByGenre;
	}
	

}
