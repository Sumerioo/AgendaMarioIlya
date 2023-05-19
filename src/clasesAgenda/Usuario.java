package clasesAgenda;

public class Usuario extends Persona{
	int quitar;
	//Constructor
	public Usuario (String nombre, int numTelefono) {
		super(nombre,numTelefono);
	}
	//Metodos abstractos
	public void enviarMensaje() {
		
	}
	public void recibirMensaje() {
		
	}
}
