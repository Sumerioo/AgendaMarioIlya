package clasesAgenda;

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
	public abstract Mensaje enviarMensaje(int num);
	

	//GETTERSySETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getN_Telefono() {
		return numTelefono;
	}

	public void setN_Telefono(int n_Telefono) {
		this.numTelefono = n_Telefono;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", numTelefono=" + numTelefono + "]";
	}
	
	
	
	
	
}
