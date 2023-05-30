package clasesAgenda;
import baulErrores.*;
/**
 * Clase padre de Usuarios y Administradores, abstracta.
 * @author Mario e Ilya
 * @version 1.0
 * @since 30-05-2023
 */
public abstract class Persona {
	
	//ATRIBUTOS
	private String nombre;
	private int numTelefono;


	public Persona(String nombre, int numTelefono) {
		this.nombre=nombre;
		this.numTelefono=numTelefono;
	}
	
	
	//METODOS
	//protected abstract void creacionPersona();
	
	/**
	 * Obliga a los hijos a implementar el metodo enviarMensaje
	 * @param num
	 * @return
	 * @throws ErrorEnMensaje
	 */
	public abstract Mensaje enviarMensaje(int num) throws ErrorEnMensaje;
	

	//GETTERSySETTERS
	/**
	 * Devuelve el nombre de la Persona.
	 * @return nombre el nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Cambia el nombre a la persona
	 * @param nombre nombre a cambiar
	 */
		
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el numero de telefono de la persona.
	 * @return numTelefono numero de telefono
	 */
	
	public int getNumTelefono() {
		return numTelefono;
	}

	/**
	 * Cambia el numero de telefono de la persona
	 * @param numTelf numero de telefono
	 */
	
	public void setNumTelefono(int numTelf) {
		this.numTelefono = numTelf;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", numTelefono=" + numTelefono + "]";
	}
	
	
	
	
	
}
