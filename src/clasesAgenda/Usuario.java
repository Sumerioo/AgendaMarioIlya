package clasesAgenda;
import java.util.*;

import java.io.*;
import baulErrores.*;
/**
 * Clase que crea Usuarios , extiende de Persona.
 * @see Persona
 * @author Mario e Ilya
 * @version 1.0
 * @since 30-05-2023
 */
public class Usuario extends Persona{

	//Constructor
	public Usuario (String nombre, int numTelefono) {
		super(nombre,numTelefono);
	}
	//Metodos abstractos
	/**
	 * Metodo que envia mensajes a otro numero de telefono
	 * @param numTelf Numero de telefono del destinatario
	 */
	public Mensaje enviarMensaje(int numTelf) throws ErrorEnMensaje {
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
			
		}else {
			throw new ErrorEnMensaje();
		}
		
	}
	
	//Metodos normales
	/**
	 * Metodo que enseña el menu cumpleto de las funciones de un usuario.
	 */
	public static void menuUsuario() {
		System.out.println("Siendo usuario puedes acceder a las siguientes funciones, que deseas?\n1.Enviar Mensaje.\n2.Ver mensajes recibidos.\n3.Borrar un mensaje recibido.\n4.Salir del programa.");
	}
}
