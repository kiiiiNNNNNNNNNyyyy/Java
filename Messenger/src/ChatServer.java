import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ChatServer {

	static Vector ClientSockets;
	static Vector LoginNames;
	
	ChatServer() throws IOException{
		ServerSocket server = new ServerSocket(5217);
		ClientSockets = new Vector();
		LoginNames = new Vector();
		
		while(true){
			Socket client  = server.accept();
			AcceptClient acceptClient = new AcceptClient(client);
			
		}
	}

	public static void main(String[] args) throws IOException{
		ChatServer server = new ChatServer();
	}
	
	class AcceptClient extends Thread{
		Socket CleintSocket;
		DataInputStream din;
		DataOutputStream dout;
		AcceptClient(Socket client) throws IOException{
			CleintSocket = client;
			din = new DataInputStream(CleintSocket.getInputStream());
			dout = new DataOutputStream(CleintSocket.getOutputStream());
			
			String LoginName = din.readUTF();
			
			LoginNames.add(LoginName);
			ClientSockets.add(CleintSocket);
			start();
		}	
		
		public void run(){
			while(true){
				try {
					
					String msgFromClient = din.readUTF();
					StringTokenizer st = new StringTokenizer(msgFromClient);
					String LoginName = st.nextToken();
					String msgType = st.nextToken();
					int lo = -1;
					String msg = "";
					
					while(st.hasMoreTokens()){
						msg = msg + " " + st.nextToken();
					}
					
					if(msgType.equals("Login")){
						for(int i = 0;i < LoginNames.size(); i++){
							Socket pScoket  = (Socket) ClientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pScoket.getOutputStream());
							pOut.writeUTF(LoginName + " has Logged in!!");
						}
					}
					else if(msgType.equals("Logout")){
						for(int i = 0;i < LoginNames.size(); i++){
							
							if(LoginName.equals(LoginNames.elementAt(i))){
								lo = i;
							}
							
							Socket pScoket  = (Socket) ClientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pScoket.getOutputStream());
							pOut.writeUTF(LoginName + " has Logged out!!");
						}
						
						if(lo >= 0){
							LoginNames.removeElementAt(lo);
							ClientSockets.removeElementAt(lo);
						}
					}
					else{
						for(int i = 0;i < LoginNames.size(); i++){
							Socket pScoket  = (Socket) ClientSockets.elementAt(i);
							DataOutputStream pOut = new DataOutputStream(pScoket.getOutputStream());
							pOut.writeUTF(LoginName + " : " + msg);
						}
					}
					if(msgType.equals("Logout")){
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
