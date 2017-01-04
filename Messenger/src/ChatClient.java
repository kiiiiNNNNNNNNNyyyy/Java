import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable{
	
	Socket socket;
	JTextArea ta;
	JButton send, logout;
	TextField tf;
	
	Thread thread;
	
	DataInputStream din;
	DataOutputStream dout;
	
	String LoginName;
	
	ChatClient(String login) throws UnknownHostException, IOException{
		super(login);
		LoginName =  login;
		
		ta = new JTextArea(18, 50);
		tf = new TextField(50);
		send = new JButton("Send");
		logout = new JButton("Logout");
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dout.writeUTF(LoginName + " " + "Data " + tf.getText().toString());
					tf.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dout.writeUTF(LoginName + " " + "Logout");
					System.exit(1);     
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		socket = new Socket("localhost", 5217);
		
		din = new DataInputStream(socket.getInputStream());
		dout = new DataOutputStream(socket.getOutputStream());
		
		dout.writeUTF(LoginName);
		dout.writeUTF(LoginName + " " + "Login");
		
		thread = new Thread(this);
		thread.start();
		setup();
	}
	
	private void setup(){
	
		setSize(600, 400);
		
		JPanel panel = new JPanel();
		panel.add(new JScrollPane(ta));
		panel.add(tf);
		panel.add(send);
		panel.add(logout);
		add(panel);
		setVisible(true); 
		
	}
	
	public void run(){

		while(true){
			try {
				ta.append("\n" + din.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
	
	public static void main(String args[]) throws UnknownHostException, IOException{
		ChatClient client = new ChatClient("User1");
	}
	
}
