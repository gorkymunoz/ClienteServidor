package ec.edu.epn.redes.cs.tpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientTPC {

	private static int SERVER_PORT = 9090;
	
	public static void main(String[] args) throws IOException{
		
		String serverAddres = JOptionPane.showInputDialog("Enter IP Addres"+SERVER_PORT);
		
		Socket clienteSocket = new Socket(serverAddres, SERVER_PORT);
		
		InputStreamReader inputStream = new InputStreamReader(clienteSocket.getInputStream()); //Para recuperar cualquier respuesta del servidor
		
		BufferedReader input = new BufferedReader(inputStream);
		String answer = input.readLine();
		
		JOptionPane.showMessageDialog(null, answer);
		System.exit(0);
		
	}
}
