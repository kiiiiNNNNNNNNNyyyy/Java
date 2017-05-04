import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{

	JLabel userL = new JLabel("Username: ");
	JTextField userTF =  new JTextField();
	JLabel passL = new JLabel("Password : ");
	JPasswordField passTF = new JPasswordField();
	JPanel loginP = new JPanel(new GridLayout(4, 2));
	JPanel panel = new JPanel();
	JButton login = new JButton("Login");
	JButton register = new JButton("Register");
	JLabel nouser = new JLabel("");
	CardLayout cl;
	
	Login(){
		
		System.out.println("My final project is a Text Editor, which allows user to create new files and edit existing text files. The program allows you to create new files with your desired name with .txt extension. The program also contains shows the existing files created by the user. In order to create the complexity of the program, I also tried to implement a Login/Register feature into the application. If the user is new to the program, the user has to create a new profile using the Register feature, where he has to Choose his username and password. All the passwords are encrypted and stored in the password.txt files with their username in front of them. If the user is not new to the program and already has an account, then he can login by adding his credentials into the program and he will be logged in. The program also takes in consideration, some of the test cases for example - If the user does not exist, If the password is wrong, If the user is already registered etc. Once the user has logged in, he/she has access to all his existing files. Since there is no implementation of session and it is just a static program, the user has to login again in order to see the newly created files. The user can open the existing files and edit them and save it again. ");
		setLayout(new CardLayout());
		loginP.add(userL);
		loginP.add(userTF);
		loginP.add(passL);
		loginP.add(passTF);
		login.addActionListener(this);
		register.addActionListener(this);
		loginP.add(login);
		loginP.add(register);
		loginP.add(nouser);
		panel.add(loginP);
		add(panel, "login");	//login is the key
		cl = (CardLayout)getLayout();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login){
			try {
				
				BufferedReader input = new BufferedReader(new FileReader("passwords.txt"));
				String pass = null;
				String line = input.readLine();
				boolean found = false;
				while(line != null){
					 StringTokenizer st = new StringTokenizer(line);
					 if(userTF.getText().equals(st.nextToken())){
						 pass = st.nextToken();
						 found = true;
					 }
					 line = input.readLine();
				}
				
				if(!found){
					nouser.setText("No User found!!");
				}
				input.close();
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(new String(passTF.getPassword()).getBytes());
				byte byteData[] = md.digest();
				StringBuffer sb = new StringBuffer();
				
				for(int i=0; i<byteData.length; i++){	
					sb.append(Integer.toString((byteData[i] & 0xFF) + 0x100, 16).substring(1));	//encryption
				}
				
				boolean correctPass = false;
				if(pass.equals(sb.toString())){
					//System.out.println("You have logged in!!");
					add(new FileBrowser(userTF.getText()), "fb");
					cl.show(this, "fb");
					correctPass = true;
				}
				
				if(!correctPass){
					nouser.setText("Wrong Password");
				}
				
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == register){
			add(new Register(), "register");
			cl.show(this, "register");
		}
		
		
	}
	
	public static void main(String args[]){
		
		JFrame frame = new JFrame("Text Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		Login login = new Login();
		frame.add(login);
		frame.setVisible(true);
		
	}

}
