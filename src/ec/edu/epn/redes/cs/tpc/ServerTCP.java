package ec.edu.epn.redes.cs.tpc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

	private static int PORT = 9090;
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server listening on port"+PORT);
	
		try{
			while(true){
				Socket socket = serverSocket.accept();
				
				try{
					
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
					out.println("Message from Gork");
				} finally{
					socket.close();
				}
			}
			
		}finally{
			serverSocket.close();
		}
	}
}
