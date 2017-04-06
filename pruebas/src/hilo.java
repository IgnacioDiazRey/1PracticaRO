
import java.io.*;
import java.net.*;

public class hilo extends Thread {

	Socket servidor;
	String fich;
	public hilo(Socket serv, String fichero) {
	servidor=serv;
	fich=fichero;
	}


public void run(){
	try {
		
		while(true){
			OutputStream aux = servidor.getOutputStream();
			DataOutputStream flujo= new DataOutputStream( aux );
			
			String cadena;
	

		FileReader f = new FileReader(fich);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine())!=null) {
			flujo.writeUTF(cadena);
			sleep(1500);
			
		} 
		flujo.writeUTF("----------------------");
		flujo.writeUTF("----------------------");
		flujo.writeUTF("Alcanzouse o final de ficheiro,volvera comenzar");
		flujo.writeUTF("crtl+c para cerrar a conexion co servidor");
		flujo.writeUTF("----------------------");
		flujo.writeUTF("----------------------");
		b.close();

		
			//flujo.close();
			
			
		} 
		
	} catch (Exception e) {
		try {
			servidor.close();
			System.out.println("cerrando conexion co cliente");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		
	}
}
}
