package com.sql.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.sql.bean.DocumentsList;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn) {
		this.connect = conn;
		
	}
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(String IdCote);
	
	public abstract ArrayList<DocumentsList> findAuteur(String cau);
	
	public abstract ArrayList<DocumentsList> findTitre(String cti);
	

}
