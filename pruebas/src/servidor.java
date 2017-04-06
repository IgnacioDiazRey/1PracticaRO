import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servidor {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		int puerto=Integer.parseInt(args[0]);
		String fichero=args[1];
		 

		//if(transporte.equals("-tcp"))
		{
		System.out.println("iniciando servidor");
		
		hilo_cliente_conectado tarea =new hilo_cliente_conectado(puerto, fichero);
		tarea.start();
		
		}
/*-----------------------------------------------------------------------*/
		
		//if(transporte.equals("-tcp"))
		{
        int j=0;
        byte msg[]=new byte[1024];
 
     
        DatagramSocket s = new DatagramSocket(puerto);
        System.out.println("Servidor Activo");
 
        File f= new File(fichero);
        FileReader fr =new FileReader (f);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
        DatagramPacket recibido = new DatagramPacket(new byte [1024],1024);
        j++;
     
        s.receive(recibido);
        System.out.println("Peticion UDP"+j);
         
        
        msg=br.readLine().getBytes();
        
 
        DatagramPacket paquete=new DatagramPacket(msg,msg.length,recibido.getAddress(),
 
        recibido.getPort());
        s.send(paquete);
 
        }
        } 


	}
	}

