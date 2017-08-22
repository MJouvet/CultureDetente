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
			 sqlString = "SELECT * FROM Documents WHERE Auteur ='"+cau+"' order by auteur";
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
	
	public ArrayList<DocumentsList> findTitre(String cti) {
		DocumentsList docTitre = new DocumentsList();
		
		ArrayList<DocumentsList> listTitre = new ArrayList<>();
		
		String sqlString;
		if (cti!=null) {
			 sqlString = "Select * from documents where titre = "+cti ;
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

	

}
