package clasesAgenda;
import java.util.*;
import baulErrores.*;
import java.io.*;
public class MainTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Agenda agenda1=new Agenda();
		
		System.out.println("HOLA");
		
		//SINCRONIZACION FICHEROS / ARRAYLISTS
		
		agenda1.updateARLCnt();
		agenda1.updateARLMsg();
		
		
		//BORRAR ESTO;SOLOPRUEBA
//		AccesoFicheros.borradoFicheroContactos();
//		AccesoFicheros.leerFicheroContactos();
		
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
		
//		AccesoFicheros.leerFicheroContactos();
//		
//		AccesoFicheros.leerFicheroMensajes();
		
		//METODO VER AGENDA
		
		agenda1.mostrarAgenda();
		
		
		//LOG IN USERS/ADMINS
		
		System.out.println("Hola! Esta es la agenda de Mario e Ilya, por favor haz Log In.");
		System.out.println("Introduce tu telefono para hacer Log In en la aplicación");
		
		int numLogIn=sc.nextInt(); 
		int adminOusu=0;
		try {
			adminOusu=agenda1.logIn(numLogIn);
		} catch (ErrorLogIn exc) {
			System.err.println("ERROR AL LOGEAR");
		}
		
		
		//MENU DE FUNCIONES PARA USUARIOS Y ADMINISTRADORES
		
//		Persona persona=agenda1.sacarPersona(numLogIn);
//		
//		if (adminOusu==0) {
//			Usuario.menuUsuario();
//			int eleccionUsu=sc.nextInt();
//			while(eleccionUsu<4) {
//			switch(eleccionUsu) {
//			
//				case 1:
//					try {
//					System.out.println("Introduce el numero de telefono del destinatario");
//					;
//					agenda1.guardarMensaje(persona.enviarMensaje(sc.nextInt()));
//					System.out.print("\n");
//					}catch(ErrorEnMensaje exc) {
//						System.err.println("Error al enviar un mensaje");
//					}
//					break;
//					
//				case 2:
//					
//					System.out.println("Mostrando mensajes recibidos al numero"+persona.getNumTelefono());
//					System.out.print("\n");
//					agenda1.verMensajesNumConcreto(persona.getNumTelefono());
//					System.out.print("\n");
//					break;
//					
//				case 3:
//					
//					System.out.println("Elige el mensaje que quieres borrar, indicando el numero de telefono del emisor:");
//					System.out.print("\n");
//					agenda1.verMensajesNumConcreto(persona.getNumTelefono());
//					System.out.print("\n");
//					int numParaBorrar = sc.nextInt();
//					try {
//						agenda1.borrarMensaje(numParaBorrar);
//					} catch (ErrorAlBorrar exc) {
//						System.err.println("Se ha producido un error al borrar el mensaje");
//					}
//					break;
//				default: System.err.println("Funcion no reconocida.");
//				
//				break;
//			}
//			Usuario.menuUsuario();
//			eleccionUsu=sc.nextInt();
//			System.out.print("\n");
//			}
//			if(eleccionUsu==4) {
//				System.out.println("Saliendo del menu usuario");
//			}
//		}else if(adminOusu==1){
//			Administrador.menuAdmin();
//			int eleccionAdmin = sc.nextInt();
//			while (eleccionAdmin < 6) {
//				switch (eleccionAdmin) {
//
//				case 1:
//					try {
//						
//					
//					System.out.println("Introduce el numero de telefono del destinatario");
//					;
//					agenda1.guardarMensaje(persona.enviarMensaje(sc.nextInt()));
//					System.out.print("\n");
//					}catch(ErrorEnMensaje exc) {
//						System.err.println("Error al enviar un mensaje");
//					}
//					break;
//
//				case 2:
//
//					System.out.println("Mostrando mensajes recibidos al numero" + persona.getNumTelefono());
//					System.out.print("\n");
//					agenda1.verMensajesNumConcreto(persona.getNumTelefono());
//					System.out.print("\n");
//					break;
//
//				case 3:
//					System.out.println("Introduce un numero de telefono para ver todos sus mensajes");
//					int verMensajesConcreto=sc.nextInt();
//					agenda1.verMensajesNumConcreto(verMensajesConcreto);
//					break;
//				case 4:
//					System.out.println("Borrando contacto de la agenda, introduce su numero de telefono");
//					int borrarContactoDesdeAdmin=sc.nextInt();
//					try {
//					agenda1.borrarContacto(borrarContactoDesdeAdmin);
//					}catch(ErrorAlBorrar exc) {
//						System.err.println("Ha ocurrido un error al borrar el contacto");
//					}
//					break;
//				case 5:
//
//					System.out.println("Elige el mensaje que quieres borrar, indicando el numero de telefono del emisor:");
//					System.out.print("\n");
//					int borrarMensajeDesdeAdmin=sc.nextInt();
//					agenda1.verMensajesNumConcreto(borrarMensajeDesdeAdmin);
//					System.out.print("\n");
//					int numParaBorrar = sc.nextInt();
//					try {
//						agenda1.borrarMensaje(numParaBorrar);
//					} catch (ErrorAlBorrar exc) {
//						System.err.println("Se ha producido un error al borrar el mensaje");
//					}
//					break;
//				default:
//					System.err.println("Funcion no reconocida.");
//
//					break;
//				}
//			Administrador.menuAdmin();
//				eleccionAdmin = sc.nextInt();
//				System.out.print("\n");
//			}
//			if (eleccionAdmin == 6) {
//				System.out.println("Saliendo del menu administrador");
//			}
//		}else {
//			System.err.println("Error en el login, en el int a devolver");
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
