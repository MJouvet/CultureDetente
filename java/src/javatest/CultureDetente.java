package javatest;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.sql.bean.DocumentsList;
import com.sql.connection.SQLConnection;
import com.sql.dao.DAO;
import com.sql.dao.implement.DocumentDAO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CultureDetente extends JFrame {

	private JPanel panel = new JPanel();
	
	public String requetAuteur;
	public String cau = null;
	public String cti = null;
	DocumentsList sqla = null;
	DocumentsList sqlt = null;
	
	//public JTable table;
	private JTable table;
	
	
	/**
	 * Create the frame.
	 */
	public CultureDetente() {
		
	    
	    try {
			
			com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) SQLConnection.getInstance();
			Statement sta = con.createStatement();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 706, 404);
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(panel);
			panel.setLayout(null);
			
			
			JComboBox<String> jca = new JComboBox<String>();
			jca.setBounds(24, 45, 141, 27);
			DAO<DocumentsList>auteurCombo = new DocumentDAO(con);
			ArrayList<DocumentsList> auteurs = auteurCombo.findAuteur(cau);
			for(int i = 0; i<auteurs.size(); i++) {
				jca.addItem(auteurs.get(i).getAuteur());
			}
			panel.add(jca);
			
			JComboBox<String> jct = new JComboBox<String>();
			jct.setBounds(368, 45, 141, 27);
			DAO<DocumentsList>titreCombo = new DocumentDAO(con);
			ArrayList<DocumentsList> titres = titreCombo.findTitre(cti);
			for(int i = 0; i<titres.size(); i++) {
				jct.addItem(titres.get(i).getTitre());
			}
			panel.add(jct);
			
			JLabel lblAuteur = new JLabel("Auteur");
			lblAuteur.setBounds(29, 17, 61, 16);
			panel.add(lblAuteur);
			
			JLabel lblTitre = new JLabel("Titre");
			lblTitre.setBounds(370, 17, 61, 16);
			panel.add(lblTitre);
			
			/*JTable table = new JTable();
			table.setBounds(42, 312, 549, -209);
			
			table.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.add(table);*/
			
			
			
			
			
			JScrollPane scrollTable = new JScrollPane(table);
			
			JButton btnAuteur = new JButton("Recherche par Auteur");
			btnAuteur.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(jca.getSelectedItem() !=null) {
						DefaultTableModel modele = new DefaultTableModel();
						Object[] nomColonne = new Object[7];
						nomColonne[0]="IdCote";
						nomColonne[1]="Titre";
						nomColonne[2]="Auteur";
						nomColonne[3]="typeDoc";
						nomColonne[4]="Genre";
						nomColonne[5]="Disponible";
						nomColonne[6]="Caution";
						
						modele.setColumnIdentifiers(nomColonne);
						
						Object[] ligne = new Object[7];
						DAO<DocumentsList> documentDAO = new DocumentDAO(con);
						ArrayList<DocumentsList> documents = documentDAO.findAuteur(jca.getSelectedItem().toString());
						for(int i = 0; i<documents.size();i++){
							
							//System.out.println(documents.get(i).getTitre());
							ligne[0] = documents.get(i).getIdCote();
							ligne[1] = documents.get(i).getTitre();
							ligne[2] = documents.get(i).getAuteur();
							ligne[3] = documents.get(i).getTypeDoc();
							ligne[4] = documents.get(i).getGenre();
							ligne[5] = documents.get(i).getDisponible();
							ligne[6] = documents.get(i).getCaution();
							modele.addRow(ligne);
							//System.out.println(ligne[3]);
							}
						table.setModel(modele);
						scrollTable.repaint();
					}
				}
			});
			
			btnAuteur.setBounds(177, 44, 163, 29);
			panel.add(btnAuteur);
			
			JButton btnTitre = new JButton("Recherche par Titre");
			btnTitre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnTitre.setBounds(524, 44, 163, 29);
			panel.add(btnTitre);
			
			table = new JTable();
			table.setBounds(24, 112, 663, 264);
			table.setBackground(Color.ORANGE);
			
			panel.add(table);
			
			
			
			
			
			
			
			DefaultTableModel modele = new DefaultTableModel();
			Object[] nomColonne = new Object[7];
			nomColonne[0]="IdCote";
			nomColonne[1]="Titre";
			nomColonne[2]="Auteur";
			nomColonne[3]="typeDoc";
			nomColonne[4]="Genre";
			nomColonne[5]="Disponible";
			nomColonne[6]="Caution";
			
			modele.setColumnIdentifiers(nomColonne);
			
			Object[] ligne = new Object[7];
			DAO<DocumentsList> documentDAO = new DocumentDAO(con);
			ArrayList<DocumentsList> documents = documentDAO.findTitre(cti);
			for(int i = 0; i<documents.size();i++){
				
				//System.out.println(documents.get(i).getTitre());
				ligne[0] = documents.get(i).getIdCote();
				ligne[1] = documents.get(i).getTitre();
				ligne[2] = documents.get(i).getAuteur();
				ligne[3] = documents.get(i).getTypeDoc();
				ligne[4] = documents.get(i).getGenre();
				ligne[5] = documents.get(i).getDisponible();
				ligne[6] = documents.get(i).getCaution();
				modele.addRow(ligne);
				}
			table.setModel(modele);
			
	    } catch (Exception e) {
			panel.removeAll();
			panel.add(new JScrollPane(new JTable()), BorderLayout.CENTER);
			panel.revalidate();
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR !", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	/*public void initContent() {
		// TODO Auto-generated method stub
	
	}*/
	
	/*public void initTable(String query) {
		
		JComboBox<String> jca = new JComboBox<String>();
		jca.setBounds(24, 45, 141, 27);
		panel.add(jca);
		
		
			//System.out.println(documents.get(i).getAuteur());
			//sqla = documentDAO.findAuteur(cau);     
			ResultSet res = sta.executeQuery(query);
			
			ResultSetMetaData meta = res.getMetaData();
			
			
			//if (cau != null) {
				
				Object[] column = new Object[meta.getColumnCount()];
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					column[i-1] = meta.getColumnName(i);
					}
				res.last();
				int rowCount = res.getRow();
				Object[][] data = new Object[res.getRow()][meta.getColumnCount()];
				res.beforeFirst();
				int j = 1;
				
				while (res.next()) {
					//System.out.println(res.getString(cau));
					for(int i = 1; i<= meta.getColumnCount();i++) {
						data[j-1][i-1] = res.getObject(i);
					}
					j++;
					
				}
				res.close();
				sta.close();
				
				//long totalTime = System.currentTimeMillis() - start;
				
				panel.removeAll();
				panel.add(new JScrollPane(new JTable()), BorderLayout.CENTER);
				panel.revalidate();
				panel.add(new JLabel("La requête à été exécuter en " + totalTime +
						" ms et a retourné " + rowCount + " ligne(s)"), BorderLayout.SOUTH);
				
				
			} else {
				sqlt = documentDAO.findTitre(cti);
				Object[] column = new Object[((ResultSetMetaData) sqlt).getColumnCount()];

			}
			
			
			
			
			
			
			
		
		
	}

	
*/
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		CultureDetente cul = new CultureDetente();
		cul.setVisible(true);
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CultureDetente frame = new CultureDetente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
}
