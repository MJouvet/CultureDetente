package javatest;

import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sql.bean.Document;
import com.sql.connection.SQLConnection;
import com.sql.dao.DAO;
import com.sql.dao.implement.DocumentDAO;

public class CultureDetente extends JFrame {

	private JPanel panel = new JPanel();
	
	public String requetAuteur;
	public String cau;
	public String cti = null;
	Document sqla = null;
	Document sqlt = null;
	
	
	/**
	 * Create the frame.
	 */
	public CultureDetente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		setContentPane(panel);
		
		initContent();
	    initTable(requetAuteur);
		
	}
	
	
	public void initContent() {
		// TODO Auto-generated method stub
	
	}
	
	public void initTable(String query) {
		
		try {
			long start = System.currentTimeMillis();
			com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) SQLConnection.getInstance();
			Statement sta = con.createStatement();
			//ResultSet res = (ResultSet) sqla;
			DAO<Document> documentDAO = new DocumentDAO(con);
			Document document = documentDAO.findAuteur(cau);
			System.out.println(document.getAuteur());
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
				
				long totalTime = System.currentTimeMillis() - start;
				
				panel.removeAll();
				panel.add(new JScrollPane(new JTable(data, column)), BorderLayout.CENTER);
				panel.revalidate();
				panel.add(new JLabel("La requête à été exécuter en " + totalTime +
						" ms et a retourné " + rowCount + " ligne(s)"), BorderLayout.SOUTH);
				
				
			/*} else {
				sqlt = documentDAO.findTitre(cti);
				Object[] column = new Object[((ResultSetMetaData) sqlt).getColumnCount()];

			}*/
			
			
			
			
			
			
			
		} catch (Exception e) {
			panel.removeAll();
			panel.add(new JScrollPane(new JTable()), BorderLayout.CENTER);
			panel.revalidate();
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR !", 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}

	

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
