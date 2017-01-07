import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.DestroyFailedException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class Database extends JPanel{
	
	static JTextArea sql = new JTextArea();
	JLabel prompt = new JLabel("Please Enter your Database Credentials: ");
	JButton exe = new JButton("Execute");
	JButton reset = new JButton("Reset");
	static JTable table = new JTable();
	static Connector dc;
	static DefaultTableModel model = (DefaultTableModel) table.getModel();	
	
	public Database(Connector conn){
		add(prompt);
		dc = conn;
		JScrollPane pane = new JScrollPane(sql);	//In case if the user has a lot of text
		pane.setPreferredSize(new Dimension(750, 100));
		add(pane);
		
		exe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				execute();
			}
		});
		
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.setColumnCount(0);
				model.setRowCount(0);
			}
		});
		
		add(exe);
		add(reset);
		JScrollPane pane2 = new JScrollPane(table);	//In case if the user has a lot of text
		pane2.setPreferredSize(new Dimension(750, 400));
		add(pane2);
	}
	
	private static void execute(){
		model.setColumnCount(0);
		model.setRowCount(0);
		String s = sql.getText();
		try{
			if((s.length() >= 6 && s.substring(0, 6).equalsIgnoreCase("SELECT"))){
				ResultSet rs = dc.executeQuery(s); 
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData(); //This will allow us to get the number of column
				for(int i=1; i<=rsmd.getColumnCount(); i++){
					model.addColumn(rsmd.getColumnName(i));
				}
				while(rs.next()){
					String[] data = new String[rsmd.getColumnCount()];
					for(int i=1; i<=rsmd.getColumnCount(); i++){
						data[i-1] = rs.getString(i);
					}
					model.addRow(data);
				}
			}
			else{
				dc.executeUpdate(s);
			}
		}catch(SQLException e){
			System.out.println("Error: " + e);
		}
	}
			
}
