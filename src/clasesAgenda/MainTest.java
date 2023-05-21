package clasesAgenda;
import java.util.*;
import baulErrores.*;

import java.io.*;
public class MainTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Agenda agenda1=new Agenda();
		
		
		//BORRAR ESTO;SOLOPRUEBA
		AccesoFicheros.borradoFicheroContactos();
		AccesoFicheros.leerFicheroContactos();
		
		//CREACION USUARIOS 
		
		System.out.println("Quieres crear algun usuario?");
		String decision1=sc.nextLine();
		
		if (decision1.equalsIgnoreCase("Si")) {

			System.out.println("Benvenute! ");
			String nombre;
			int numTelf;
			int contNewUsers = 0;
			System.out.println("Introduce el tipo de persona a crear (Administrador|Usuario)");

			String tipo = sc.nextLine();

			while (tipo.equalsIgnoreCase("Admin") || tipo.equalsIgnoreCase("Administrador")
					|| tipo.equalsIgnoreCase("Usuario")) {
				System.out.println("Introduce un nombre:");
				nombre = sc.next();
				System.out.println("Introduce un telefono:");
				numTelf = sc.nextInt();
				agenda1.crearPersona(tipo, nombre, numTelf);
				System.out.println("Introduce el tipo de persona a crear (Administrador|Usuario|S para salir) ");
				tipo = sc.next();
				contNewUsers++;
			}
			
			System.out.println("Saliste, has creado " + contNewUsers + " usuarios/admins nuevos !");
		}
		
		//PRUEBAS FICHEROS
		
		AccesoFicheros.leerFicheroContactos();
		
		AccesoFicheros.leerFicheroMensajes();
		
		//METODO VER AGENDA
		
//		agenda1.mostrarAgenda();
		
		
		//LOG IN USERS/ADMINS
		
//		System.out.println("Hola! Esta es la agenda de Mario e Ilya, por favor haz Log In.");
//		System.out.println("Introduce tu telefono para hacer Log In en la aplicación");
//		
//		int numLogIn=0; //*
//		try {
//			agenda1.logIn(numLogIn);
//		} catch (ErrorLogIn exc) {
//			System.err.println("ERROR AL LOGEAR");
//		}
		
		//MENU DE FUNCIONES PARA USUARIOS
		
		
		Usuario user1=new Usuario("Boinas",101);
		//Usuario user2=new Usuario("SorakaBoinas",102);
//		Usuario.menuUsuario();
//		int eleccionUsu=sc.nextInt();
//		while(eleccionUsu<4) {
//		switch(eleccionUsu) {
//		
//			case 1:
//				
//				System.out.println("Introduce el numero de telefono del destinatario");
//				;
//				agenda1.guardarMensaje(user1.enviarMensaje(sc.nextInt()));
//				System.out.print("\n");
//				break;
//				
//			case 2:
//				
//				System.out.println("Mostrando mensajes recibidos al numero"+user1.getNumTelefono());
//				System.out.print("\n");
//				agenda1.verMensajesNumConcreto(user1.getNumTelefono());
//				System.out.print("\n");
//				break;
//				
//			case 3:
//				
//				System.out.println("Elige el mensaje que quieres borrar, indicando el numero de telefono del emisor:");
//				System.out.print("\n");
//				agenda1.verMensajesNumConcreto(user1.getNumTelefono());
//				System.out.print("\n");
//				int numParaBorrar = sc.nextInt();
//				try {
//					agenda1.borrarMensaje(numParaBorrar);
//				} catch (ErrorAlBorrar exc) {
//					System.err.println("Se ha producido un error al borrar el mensaje");
//				}
//				break;
//			default: System.err.println("Funcion no reconocida.");
//			
//			break;
//		}
//		Usuario.menuUsuario();
//		eleccionUsu=sc.nextInt();
//		System.out.print("\n");
//		}
//		if(eleccionUsu==4) {
//			System.out.println("Saliendo del menu usuario");
//		}
		
		//MENU DE FUNCIONES PARA ADMINISTRADOR 
				//implementar menu desde metodo??
		Administrador.menuAdmin();
//		int eleccionAdmin = sc.nextInt();
//		while (eleccionAdmin < 6) {
//			switch (eleccionAdmin) {
//
//			case 1:
//
//				System.out.println("Introduce el numero de telefono del destinatario");
//				;
//				agenda1.guardarMensaje(user1.enviarMensaje(sc.nextInt()));
//				System.out.print("\n");
//				break;
//
//			case 2:
//
//				System.out.println("Mostrando mensajes recibidos al numero" + user1.getNumTelefono());
//				System.out.print("\n");
//				agenda1.verMensajesNumConcreto(user1.getNumTelefono());
//				System.out.print("\n");
//				break;
//
//			case 3:
//				System.out.println("Introduce un numero de telefono para ver todos sus mensajes");
//				int verMensajesConcreto=sc.nextInt();
//				agenda1.verMensajesNumConcreto(verMensajesConcreto);
//				break;
//			case 4:
//				System.out.println("Borrando contacto de la agenda, introduce su numero de telefono");
//				int borrarContactoDesdeAdmin=sc.nextInt();
//				try {
//				agenda1.borrarContacto(borrarContactoDesdeAdmin);
//				}catch(ErrorAlBorrar exc) {
//					System.err.println("Ha ocurrido un error al borrar el contacto");
//				}
//				break;
//			case 5:
//
//				System.out.println("Elige el mensaje que quieres borrar, indicando el numero de telefono del emisor:");
//				System.out.print("\n");
//				int borrarMensajeDesdeAdmin=sc.nextInt();
//				agenda1.verMensajesNumConcreto(borrarMensajeDesdeAdmin);
//				System.out.print("\n");
//				int numParaBorrar = sc.nextInt();
//				try {
//					agenda1.borrarMensaje(numParaBorrar);
//				} catch (ErrorAlBorrar exc) {
//					System.err.println("Se ha producido un error al borrar el mensaje");
//				}
//				break;
//			default:
//				System.err.println("Funcion no reconocida.");
//
//				break;
//			}
//		Administrador.menuAdmin();
//			eleccionAdmin = sc.nextInt();
//			System.out.print("\n");
//		}
//		if (eleccionAdmin == 6) {
//			System.out.println("Saliendo del menu administrador");
//		}
		
		//PRUEBA BORRADO DE CONTACTO/MENSAJE
		
//		try {
//			agenda1.borrarContacto(user1);
//		}catch(ErrorAlBorrar exc) {
//			System.err.println("Ha ocurrido un error al borrar un contacto!");
//		}
//		
//		SMS sms1=new SMS(user1.getNumTelefono(),102,"hola que tal");
//		
//		try {
//			agenda1.borrarMensaje(sms1);
//		}catch(ErrorAlBorrar exc) {
//			System.err.println("Ha ocurrido un error al borrar un mensaje !");
//		}
		
		
		
		sc.close();
	}

}
