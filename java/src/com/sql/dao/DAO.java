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
	
	public abstract ArrayList<T> findAuteur(String cau);
	
	public abstract ArrayList<T> findTitre(String cti);
	
	public abstract ArrayList<T> getList(String lisA);
	
	public abstract ArrayList<T> getListG(String lisA);

}
