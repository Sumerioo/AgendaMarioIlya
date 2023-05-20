package clasesAgenda;
import baulErrores.*;
import java.util.*;
import java.io.*;
public class Agenda {

	private ArrayList<Persona>agenda;
	private ArrayList<Mensaje>mensajes;
	
	public Agenda() {
		agenda=new ArrayList<Persona>();
		mensajes=new ArrayList<Mensaje>();
	}
	
	
	//METODOS MOSTRAR ARRAYLISTS
	
	public void mostrarAgenda() {
		for(Persona p:agenda) {
			System.out.println(p.toString());
		}
	}
	public void mostrarMensajes() {
		for(Mensaje m: mensajes) {
			System.out.println(m.toString());
		}
	}
	
	// METODO LOG IN  // TODO pensar como devolver el tipo de persona, o como hacer que acceda a unas funciones u otras

	public void logIn(int numTelf) throws ErrorLogIn {
		int posicionAgenda = 0;
		while (posicionAgenda < agenda.size() && agenda.get(posicionAgenda).getNumTelefono() != numTelf) {
			posicionAgenda++;
		}
		if (posicionAgenda == agenda.size()) {
			throw new ErrorLogIn();
			// System.err.println("Error, usuario no encontrado");
		} else {
			System.out.println("Usuario encontrado.\nNombre: " + agenda.get(posicionAgenda).getNombre()
					+ "\nNumero de Telefono: " + agenda.get(posicionAgenda).getNumTelefono());
			System.out.println("Comprobando si es Usuario o Administrador..");
			instancePersona(posicionAgenda);
			//return agenda.get(posicionAgenda);
		}

	}

	private void instancePersona(int posicionAgenda) {
		if (agenda.get(posicionAgenda) instanceof Administrador) {
			System.out.println("Bienvenido "+agenda.get(posicionAgenda).getNombre());
			System.out.println("Eres un administrador, puedes acceder a todas las funciones");

		} else if (agenda.get(posicionAgenda) instanceof Usuario) {
			System.out.println("Bienvenido "+agenda.get(posicionAgenda).getNombre());
			System.out.println("Eres un usuario, puedes acceder a funciones simples");
		}
	}

	// METODO CREACION PERSONA
	
	public void crearPersona(String tipo, String nombre, int numTelf) {

		if (tipo.equalsIgnoreCase("Admin") || tipo.equalsIgnoreCase("Administrador")) {
			Administrador nuevoAdmin = new Administrador(nombre, numTelf);
			agenda.add(nuevoAdmin);
		} else if (tipo.equalsIgnoreCase("Usuario")) {
			Usuario nuevoUsu = new Usuario(nombre, numTelf);
			agenda.add(nuevoUsu);
		}
	}
		
	//METODOS GUARDAR CONTACTO/MENSAJE
	
	public void guardarContacto(Persona per) {
		agenda.add(per);
	}
	
	public void guardarMensaje(Mensaje men) {
		mensajes.add(men);
	}
	
	//METODOS BORRAR CONTACTO/MENSAJE (SOBRECARGANDO METODOS CON OBJETO Y TIPO DE DATO)
	
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
	
	public void verMensajesNumConcreto(int numTelf) {
		for(Mensaje men: mensajes) {
			if(men.getTelfReceptor()==numTelf) {
				System.out.println(men.toString());
			}
		}
	}

	
	
	
	
	
	
}
