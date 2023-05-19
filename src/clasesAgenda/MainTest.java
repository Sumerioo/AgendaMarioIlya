package clasesAgenda;
import java.util.*;
import java.io.*;
public class MainTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Agenda agenda1=new Agenda();
		//Creacion usuarios 
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
		//METODO VER AGENDA
		
		agenda1.mostrarAgenda();
		
		
		//LOG IN USERS/ADMINS
		
		System.out.println("Introduce tu telefono para hacer Log In en la aplicación");
		
		int numLogIn=0;
		try {
			agenda1.logIn(numLogIn);
		} catch (ErrorLogIn exc) {
			System.err.println("ERROR AL LOGEAR");
		}
		
		
		
		System.out.println("Hola! Esta es la agenda de Mario e Ilya, por favor haz Log In.");
		Usuario user1=new Usuario("Boinas",101);
		//Usuario user2=new Usuario("SorakaBoinas",102);
		System.out.println("Siendo usuario puedes acceder a las siguientes funciones, que deseas?\n1.Enviar Mensaje.\n2.Ver mensajes recibidos.\n3.Salir del programa.");
		int eleccion=sc.nextInt();
		while(eleccion<3) {
		switch(eleccion) {
			case 1:
				System.out.println("Introduce el numero de telefono del destinatario");
				;
				agenda1.guardarMensaje(user1.enviarMensaje(sc.nextInt()));
				System.out.print("\n");
				break;
			case 2:
				System.out.println("Mostrando mensajes recibidos al numero"+user1.getN_Telefono());
				System.out.print("\n");
				agenda1.verMensajesNumConcreto(user1.getN_Telefono());
				System.out.print("\n");
				break;
			default: System.err.println("Funcion no reconocida.");
			break;
		}
		System.out.println("Siendo usuario puedes acceder a las siguientes funciones, que deseas?\n1.Enviar Mensaje.\n2.Ver mensajes recibidos.\n3.Salir del programa.");
		eleccion=sc.nextInt();
		System.out.print("\n");
		}
		
		
		sc.close();
	}

}
