import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class cliente {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		String transporte,ip_servidor;
		transporte=args[0];
		ip_servidor=(args[1]);
		int puerto=Integer.parseInt(args[2]);
		
		System.out.println("iniciando cliente");
		
		
		if(transporte.equals("-tcp")){
		
		System.out.println("iniciando conexion");
		try{
		
			Socket socket= new Socket(ip_servidor,puerto);
		
			System.out.println("conexion establecida");
			InputStream input= socket.getInputStream();
			DataInputStream flujo= new DataInputStream(input);

		
		while(true){
			
			
			System.out.println(flujo.readUTF());
		}
		
		}catch (Exception e){
			System.out.println(e);
		}
		
		}
		
		if(transporte.equals("-udp")){
			
			
		       InetAddress destino=InetAddress.getByName(ip_servidor);
		       
		        DatagramSocket dgSocket;
		        DatagramPacket datagram;
		        
		        byte msg[] = new byte[1024];
		 	 
		        dgSocket = new DatagramSocket();
		 
		        datagram = new DatagramPacket (msg, msg.length,destino,puerto);
		      
		        dgSocket.send(datagram);
		 
		        datagram = new DatagramPacket (msg, msg.length);
		     
		        
		        dgSocket.receive(datagram);
		        
		        String received = new String (datagram.getData());
		        System.out.println ("Proverbio: " + received );
	 
		        dgSocket.close();
		 
		        }
		}
	
			
}

	
