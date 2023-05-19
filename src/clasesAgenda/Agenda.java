package clasesAgenda;
import java.util.*;
import java.io.*;
public class Agenda {

	private ArrayList<Persona>agenda;
	private ArrayList<Mensaje>mensajes;
	
	public Agenda() {
		agenda=new ArrayList<Persona>();
		mensajes=new ArrayList<Mensaje>();
	}
	//Metodos Agenda
	public void mostrarAgenda() {
		for(Persona p:agenda) {
			System.out.println(p.toString());
		}
	}
	public void guardarContacto(Persona per) {
		agenda.add(per);
	}
	public void guardarMensaje(Mensaje men) {
		mensajes.add(men);
	}
	
	public void borrarContacto(Persona per) {
		
	}
	public void borrarMensaje(Mensaje men) {
		
	}
	public void verMensajesNumConcreto(int numTelf) {
		for(Mensaje men: mensajes) {
			if(men.getTelfReceptor()==numTelf) {
				System.out.println(men.toString());
			}
		}
	}

	//METODO CREACION PERSONA
	public void crearPersona(String tipo, String nombre, int numTelf) {
		
		if(tipo.equalsIgnoreCase("Admin")||tipo.equalsIgnoreCase("Administrador")) {
			Administrador nuevoAdmin =new Administrador(nombre,numTelf);
			agenda.add(nuevoAdmin);
		}else if(tipo.equalsIgnoreCase("Usuario")) {
			Usuario nuevoUsu = new Usuario(nombre,numTelf);
			agenda.add(nuevoUsu);
		}
	}
	
	
	
	//METODO LOG IN
	
	public void logIn(int numTelf) throws ErrorLogIn {
		int posicionAgenda=0;
		while(posicionAgenda<agenda.size()&&agenda.get(posicionAgenda).getN_Telefono()!=numTelf) {
			posicionAgenda++;
		}
		if(posicionAgenda==agenda.size()) {
			throw new ErrorLogIn();
			//System.err.println("Error, usuario no encontrado");
		}else {
			System.out.println("Usuario encontrado.\nNombre: "+agenda.get(posicionAgenda).getNombre()+"\nNumero de Telefono: "+agenda.get(posicionAgenda).getN_Telefono());
			System.out.println("Comprobando si es Usuario o Administrador..");
			instancePersona(posicionAgenda);
		}
		
	}
	
	private void instancePersona(int posicionAgenda) {
		if(agenda.get(posicionAgenda) instanceof Administrador) {
			System.out.println("Eres un administrador, puedes acceder a todas las funciones");
			
		}else if(agenda.get(posicionAgenda) instanceof Usuario) {
			System.out.println("Eres un usuario, puedes acceder a funciones simples");
		}
	}
	
}
