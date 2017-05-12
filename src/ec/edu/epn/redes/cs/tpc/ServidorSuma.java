package ec.edu.epn.redes.cs.tpc;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSuma {

	private static int PORT = 9000; //Se define el puerto
	
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(PORT); //Se define el socket con el puerto definido
		int suma=0; //Variable usada para la suma de los dos números
		String num1, num2; //Variables usadas para almacenar los números ingresador por el cliente
		try{ //Con este Try intenta realizar la conexión
			while(true){ //Con esto se un servidor "Always in"
				Socket socket = serverSocket.accept(); //Acepta la conexión
				DataInputStream datRecibe = new DataInputStream(socket.getInputStream()); //Canal de entrada para los datos del cliente
				try{ //Con este Try intenta recuperar los datos ingresados por el cliente
						num1=datRecibe.readUTF(); //Con el canal de entrada se recibe el primer número
						num2=datRecibe.readUTF(); //Con el canal de entrada se recibe el segundo número
						suma=Integer.parseInt(num1)+Integer.parseInt(num2); //Se transforma los números recibidos a enteros para poder sumarlos
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true); //Se crea un canal de salida para la respuesta
					out.println("suma= "+String.valueOf(suma)); //Se da el parámetro a imprimir como respuesta
				} finally{
					socket.close(); //Se cierra la conexión
				}
			}
			
		}finally{
			serverSocket.close(); //Se cierra el servidor
		}
	}
}
