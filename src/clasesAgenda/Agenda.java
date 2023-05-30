package clasesAgenda;
import baulErrores.*;

import java.util.*;
import java.io.*;

/**
 * Clase gestora de la agenda 
 * @author Mario e Ilya
 * @version 1.0
 * @since 30-05-2023
 */
public class Agenda {

	private ArrayList<Persona>agenda;
	private ArrayList<Mensaje>mensajes;
	private int adminOusu;
	
	public Agenda() {
		agenda=new ArrayList<Persona>();
		mensajes=new ArrayList<Mensaje>();
	}
	
	
	//METODOS MOSTRAR ARRAYLISTS
	/**
	 * Devuelve toda la agenda de contactos.
	 * @return Muesta la agenda de contactos completa.
	 */
	public void mostrarAgenda() {
		for(Persona p:agenda) {
			System.out.println(p.toString());
		}
	}
	/**
	 * Devuelve todos los mensajes almacenados
	 * @return Muestra todos los mensajes ya sean enviados o recibidos
	 */
	public void mostrarMensajes() {
		for(Mensaje m: mensajes) {
			System.out.println(m.toString());
		}
	}
	
	// METODO LOG IN  
	
	/**
	 * Devuelve numero entero que saca del metodo instancePersona para saber si es un Administrador o un Usuario.
	 * @param numTelf Numero de telefono
	 * @return Tipo de usuario para sacar su respectivo menu.
	 * @throws ErrorLogIn
	 */

	public int logIn(int numTelf) throws ErrorLogIn {
		int posicionAgenda = 0;
		while (posicionAgenda < agenda.size() && agenda.get(posicionAgenda).getNumTelefono() != numTelf) {
			posicionAgenda++;
		}
		if (posicionAgenda == agenda.size()) {
			throw new ErrorLogIn();
		} else {
			System.out.println("Numero encontrado.\nNombre: " + agenda.get(posicionAgenda).getNombre()
					+ "\nNumero de Telefono: " + agenda.get(posicionAgenda).getNumTelefono());
			System.out.println("Comprobando si es Usuario o Administrador..");
			try {
			return adminOusu=instancePersona(posicionAgenda);
			}catch(ErrorInstanceOf exc) {
				System.out.println("Error al devolver el tipo de contacto.");
			}
			
		}
		return 2;
	}
	/**
	 * Metodo que devuelve un numero entero dependiendo del tipo de usuario que saca de la coleccion con la posicion de la agenda.
	 * @param posicionAgenda Posicion en la coleccion.
	 * @return  Numero entero.1=Administrador, 0=Usuario.
	 * @throws ErrorInstanceOf
	 */
	private int instancePersona(int posicionAgenda) throws ErrorInstanceOf{
		if (agenda.get(posicionAgenda) instanceof Administrador) {
			System.out.println("Bienvenido "+agenda.get(posicionAgenda).getNombre());
			System.out.println("Eres un administrador, puedes acceder a todas las funciones");
			return 1;

		} else if (agenda.get(posicionAgenda) instanceof Usuario) {
			System.out.println("Bienvenido "+agenda.get(posicionAgenda).getNombre());
			System.out.println("Eres un usuario, puedes acceder a funciones simples");
			return 0;
		}else {
			throw new ErrorInstanceOf();
		}
	}
	/**
	 * Devuelve una Persona sacada de la colecion y buscada con el numero de telefono indicado.
	 * @param numTelf Numero de telefono.
	 * @return Objeto persona sacada de la coleccion.
	 */
	public Persona sacarPersona(int numTelf) {
		int posicionAgenda = 0;
		while (posicionAgenda < agenda.size() && agenda.get(posicionAgenda).getNumTelefono() != numTelf) {
			posicionAgenda++;
		}
		if (posicionAgenda == agenda.size()) {
			 System.err.println("Error en metodo sacarPersona");
		} else {	
			return agenda.get(posicionAgenda);
		}
		return null;
	}

	// METODO CREACION PERSONA
	/**
	 * Crea un nuevo Administrador/Usuario.
	 * @param tipo Tipo de Persona a crear
	 * @param nombre Nombre de la persona a crear.
	 * @param numTelf Numero de telefono.
	 */
	public void crearPersona(String tipo, String nombre, int numTelf) {
		
		if (tipo.equalsIgnoreCase("Admin") || tipo.equalsIgnoreCase("Administrador")) {
			Administrador nuevoAdmin = new Administrador(nombre, numTelf);
			agenda.add(nuevoAdmin);
			AccesoFicheros.escribirFicheroContactos(nuevoAdmin.getNombre()+";"+nuevoAdmin.getNumTelefono());
		} else if (tipo.equalsIgnoreCase("Usuario")) {
			Usuario nuevoUsu = new Usuario(nombre, numTelf);
			agenda.add(nuevoUsu);
			AccesoFicheros.escribirFicheroContactos(nuevoUsu.getNombre()+";"+nuevoUsu.getNumTelefono());
		}
	}
		
	//METODOS GUARDAR CONTACTO/MENSAJE
	/**
	 * Guarda un contacto en la agenda.
	 * @param per Persona a guardar
	 */
	public void guardarContacto(Persona per) {
		agenda.add(per);
	}
	/**
	 * Guarda un mensaje en la coleccion de mensajes.
	 * @param men Mensaje a guardar.
	 */
	public void guardarMensaje(Mensaje men) {
		mensajes.add(men);
		AccesoFicheros.escribirFicheroMensajes(men.getTelfEmisor()+";"+men.getTelfReceptor()+";"+men.getTexto());
	}
	
	//METODOS BORRAR CONTACTO/MENSAJE (SOBRECARGANDO METODOS CON OBJETO Y TIPO DE DATO)
	/**
	 * Borra un contacto en la coleccion.
	 * @param per Persona a borrar.
	 * @throws ErrorAlBorrar
	 */
	public void borrarContacto(Persona per) throws ErrorAlBorrar {
		int posicionAgenda = 0;
		while (posicionAgenda < agenda.size() && agenda.get(posicionAgenda) != per) {
			posicionAgenda++;
		}
		if (posicionAgenda == agenda.size()) {
			throw new ErrorAlBorrar();
		} else {
			agenda.remove(posicionAgenda);
			System.out.println("Contacto borrado correctamente!");
		}
	}
	/**
	 * Borra un contacto en la coleccion.
	 * @param numTelf Numero de telefono de la persona a borrar.
	 * @throws ErrorAlBorrar
	 */
	public void borrarContacto(int numTelf) throws ErrorAlBorrar {
		int posicionAgenda = 0;
		while (posicionAgenda < agenda.size() && agenda.get(posicionAgenda).getNumTelefono() != numTelf) {
			posicionAgenda++;
		}
		if (posicionAgenda == agenda.size()) {
			throw new ErrorAlBorrar();
		} else {
			agenda.remove(posicionAgenda);
			System.out.println("Contacto borrado correctamente!");
		}
	}
	/**
	 * Borra un mensaje en la coleccion.
	 * @param men Mensaje a borrar
	 * @throws ErrorAlBorrar
	 */
	public void borrarMensaje(Mensaje men) throws ErrorAlBorrar {
		int posicionAgenda = 0;
		while (posicionAgenda < mensajes.size() && mensajes.get(posicionAgenda) != men) {
			posicionAgenda++;
		}
		if (posicionAgenda == mensajes.size()) {
			throw new ErrorAlBorrar();
		} else {
			mensajes.remove(posicionAgenda);
			System.out.println("Mensaje borrado correctamente!");
		}
	}
	/**
	 * Borra un mensaje en la coleccion.
	 * @param numTelf Numero de telefono del emisor del mensaje a borrar.
	 * @throws ErrorAlBorrar
	 */
	public void borrarMensaje(int numTelf) throws ErrorAlBorrar {
		int posicionAgenda = 0;
		while (posicionAgenda < mensajes.size() && mensajes.get(posicionAgenda).getTelfEmisor() != numTelf) {
			posicionAgenda++;
		}
		if (posicionAgenda == mensajes.size()) {
			throw new ErrorAlBorrar();
		} else {
			mensajes.remove(posicionAgenda);
			System.out.println("Mensaje borrado correctamente!");
		}
	}
	
	//METODOS OBJETO CONCRETO
	/**
	 * Busca un mensaje de un numero de telefono en concreto y lo muestra.
	 * @param numTelf Numero de telefono a buscar.
	 */
	public void verMensajesNumConcreto(int numTelf) {
		for(Mensaje men: mensajes) {
			if(men.getTelfReceptor()==numTelf) {
				System.out.println(men.toString());
			}
		}
	}	
	
	//METODOS SINCRONIZADO ARL/FICH
	
	public void updateARLCnt() {
		AccesoFicheros.updateARLCnt(agenda);
	}
	
	public void updateARLMsg() {
		AccesoFicheros.updateARLMsg(mensajes);
	}
	
}
