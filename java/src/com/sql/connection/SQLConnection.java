package com.sql.connection;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class SQLConnection {
	
	private static String url = "jdbc:mysql://localhost:8889/biblio";
	
	private static String user = "root";
	
	private static String passwd = "root";
	
	private static Connection connect;
	
	public static Connection getInstance() {
		if (connect == null) {
			try {
				connect = DriverManager.getConnection(url,user,passwd);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur de Connexion!"
						, JOptionPane.ERROR_MESSAGE);
			}
		}
		return connect;
	}

}
