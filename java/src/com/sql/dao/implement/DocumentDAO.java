package com.sql.dao.implement;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.sql.bean.Document;
import com.sql.connection.SQLConnection;
import com.sql.dao.DAO;

public class DocumentDAO extends DAO<Document> {
	public DocumentDAO(Connection conn) {
		super(SQLConnection.getInstance());
	}

	@Override
	public boolean create(Document obj) {
		
		return false;
	}

	@Override
	public boolean delete(Document obj) {
		
		return false;
	}

	@Override
	public boolean update(Document obj) {
		
		return false;
	}

	@Override
	public Document find(String IdCote) {
		Document document = new Document();
		
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("Select * FROM Documents WHERE IdCote "
							+ "= " + IdCote);
			if (result.first()) {
				document = new Document(
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
	
	public Document findAuteur(String cau) {
		Document docAuteur = new Document();
		
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("Select * FROM Documents WHERE Auteur "
						+ "= "+cau);
			if (result.first()) {
				docAuteur = new Document(
						result.getString("IdCote"),
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
		return docAuteur;
	}
	
	public Document findTitre(String cti) {
		Document docTitre = new Document();
		
		try {
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("Select * FROM Documents WHERE Titre "
							+ "= " + cti);
			if (result.first()) {
				docTitre = new Document(
						result.getString("IdCote"),
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
		return docTitre;
	}

	

}
