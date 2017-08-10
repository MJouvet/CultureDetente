package com.sql.dao;

import java.sql.Connection;

public abstract class DAO<T> {
	protected Connection connect = null;
	
	public DAO(Connection conn) {
		this.connect = conn;
		
	}
	public abstract boolean create(T obj);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
	
	public abstract T find(String IdCote);
	
	public abstract T findAuteur(String cau);
	
	public abstract T findTitre(String cti);
	

}
