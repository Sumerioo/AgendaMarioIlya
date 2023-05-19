package clasesAgenda;

public class Administrador extends Persona{
	//Constructor
	public Administrador (String nombre, int numTelefono) {
		super(nombre,numTelefono);
	}

	// Metodos abstractos
	public void enviarMensaje() {

	}

	public void recibirMensaje() {

	}
	
	//Metodos normales
	public void verMensajeEnviado(Persona per) {
		
	}
	public void verMensajeRecibido(Persona per) {
		
	}
}
