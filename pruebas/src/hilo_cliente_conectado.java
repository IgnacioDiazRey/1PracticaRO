import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

	public class hilo_cliente_conectado extends Thread {
		
		int puert;
		String fich;
		public  hilo_cliente_conectado(int puerto, String fichero) {
		puert=puerto;
		
		fich=fichero;
		}
	

	public void run(){
	

		try{
			
			ServerSocket server = new ServerSocket(puert);
			System.out.println("Esperando conexion");
			
			while(true) {
				
			Socket socket =server.accept();
			System.out.println("conexion establecida");
			hilo tarea= new hilo(socket,fich);
			tarea.start();
			}
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
	}
	}
	

