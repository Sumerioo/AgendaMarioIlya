package clasesAgenda;
import java.util.*;
import java.io.*;
public class Usuario extends Persona{

	//Constructor
	public Usuario (String nombre, int numTelefono) {
		super(nombre,numTelefono);
	}
	//Metodos abstractos
	public Mensaje enviarMensaje(int numTelf) {
													//TODO terminar para que no meta nulos en la agenda
		Scanner sc=new Scanner(System.in);
		String tipomsj;
		System.out.println("Que tipo de mensaje deseas enviar? (SMS|MMS)");
		tipomsj = sc.nextLine();
		if (tipomsj.equalsIgnoreCase("SMS")) {
			System.out.println("Introduce un contenido.");
			SMS sms = new SMS(this.getNumTelefono(), numTelf, sc.nextLine());
			System.out.println("Mensaje enviado y guardado!");
			return sms;
			
		} else if (tipomsj.equalsIgnoreCase("MMS")) {
			System.out.println("Introduce el telefono del receptor, un contenido y la foto.");
			MMS mms = new MMS(this.getNumTelefono(), numTelf, sc.nextLine(), true);
			System.out.println("Mensaje enviado y guardado!");
			return mms;
			
		}
		return null;
	}
	
	//Metodos normales
	public void menuUsuario() {
		System.out.println("Siendo usuario puedes acceder a las siguientes funciones, que deseas?\n1.Enviar Mensaje.\n2.Ver mensajes recibidos.\n3.Borrar un mensaje recibido.\n4.Salir del programa.");
	}
}
