package javatest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.sql.connection.SQLConnection;

public class biblio extends JFrame {

	private JSplitPane split;
	private JPanel contentPane;
	private JTable table;
	public String cau = null;
	public String cti = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biblio frame = new biblio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//new biblio();
		/*DAO<Document> documentDao = DocumentDAO(SQLConnection.getInstance());
		for (int i = 0; i < args.length; i++) {
			Document document = documentDao.find();
			System.out.println();
		}*/
	}

	

	/**
	 * Create the frame.
	 */
	public biblio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> jca = new JComboBox<String>();
		jca.setBounds(24, 45, 141, 27);
		contentPane.add(jca);
		
		JComboBox<String> jct = new JComboBox<String>();
		jct.setBounds(323, 45, 141, 27);
		contentPane.add(jct);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setBounds(29, 17, 61, 16);
		contentPane.add(lblAuteur);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(337, 17, 61, 16);
		contentPane.add(lblTitre);
		
		JPanel panel = new JPanel();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// la methode manuel
			//con = DriverManager.getConnection("jdbc:mysql://localhost:8889/biblio","root","root");
			//en faisant appel au pattern singleton
			con = SQLConnection.getInstance();
			st = con.createStatement();
			String sql = "SELECT * FROM Documents";
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				//pour verifier si connexion BDD
				//System.out.println(rs.getString("auteur") +" === "+rs.getString("titre"));
				jca.addItem(rs.getString("auteur"));
				jct.addItem(rs.getString("titre"));
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}finally {
			try {
				st.close();
				rs.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		
		this.getContentPane().add(panel);
		initContent();
		initTable(cau);
		
		JButton btnAuteur = new JButton("Validation Auteur");
		btnAuteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cau = jca.getSelectedItem().toString();
				
				initTable(cau);
				
			}
		});
		btnAuteur.setBounds(170, 44, 141, 29);
		contentPane.add(btnAuteur);
		
		JButton btnTitre = new JButton("Validation Titre");
		btnTitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initTable();
				cti = jct.getSelectedItem().toString();
			}
		});
		btnTitre.setBounds(463, 44, 141, 29);
		contentPane.add(btnTitre);
		
		
		
		table = new JTable();
		table.setBackground(Color.yellow);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setBounds(23, 331, 580, -236);
		contentPane.add(table);
		this.setVisible(true);
	}

	public void initContent() {
		contentPane.setLayout(new BorderLayout());
		//split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(),contentPane);
		//split.setDividerLocation(100);
		//getContentPane().add(split, BorderLayout.CENTER);
		
		
	}

	public void initTable(String query) {
		try {
			//if (cti == null) {
				Statement sta = SQLConnection.getInstance().createStatement();
				String sqla = "SELECT * FROM Documents WHERE Auteur ="+cau;
				ResultSet rsa = sta.executeQuery(sqla);
				ResultSetMetaData meta = rsa.getMetaData();
				Object[] column = new Object[meta.getColumnCount()];
				
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					column[i-1] = meta.getColumnName(i);
				}
				rsa.last();
				Object[][] data = new Object[rsa.getRow()][meta.getColumnCount()];
				rsa.beforeFirst();
				int j = 1;
				
				while (rsa.next()) {
					for (int i = 1; i <= meta.getColumnCount(); i++) {
						data[j-1][i-1] = rsa.getObject(i);
					}
					j++;
				}
				rsa.close();
				sta.close();
				
				//contentPane
			//} 
			//else {

			//}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
