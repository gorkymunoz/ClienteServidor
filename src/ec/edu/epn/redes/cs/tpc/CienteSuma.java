package ec.edu.epn.redes.cs.tpc;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class CienteSuma {

	private static int SERVER_PORT = 9000; //Se crea el puerto del servidor
	
public static void main(String[] args) throws IOException{
		
		Socket clienteSocket = new Socket("localhost", SERVER_PORT); //Al crear el socket se define previamente que se usará la Ip local y el puerto creado
		String datos; //Variable usada para almacenar los números ingresados antes de ser enviados
		DataOutputStream envioServer = new DataOutputStream(clienteSocket.getOutputStream()); //Canal de salida hacia el servidor
		DataInputStream salidaServidor = new DataInputStream(clienteSocket.getInputStream()); //Canal de entrada desde el servidor
		for(int i=0;i<2;i++){ //Lazo usado para que el cliente ingrese los 2 números a sumar
			datos=JOptionPane.showInputDialog(null, "Ingrese el valor del numero " +(i+1)); //Ingreso de los números mediante una JOptionPane
			envioServer.writeUTF(datos); //Con el canal de salida, envía los números ingresados, uno por uno.
		}
		
		
		JOptionPane.showMessageDialog(null, salidaServidor.readLine()); //Imprime el resultado de la suma, enviado por el servidor
		System.exit(0);
		
	}
}
