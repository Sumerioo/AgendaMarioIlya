package pruebasCajaNegra;

import java.util.ArrayList;

public class Mensaje {

	
	private String telfEmisor;
	private String telfReceptor;
	private String texto;
	private boolean esMMS;  // De momento hacemos que sea MMS como un booleano de si lo es o no, en el programa real seran subclases
	
	
	public Mensaje() {
		
	}
	
	public Mensaje(String emi, String recep, String text, boolean esMMS){
		
		telfEmisor=emi;
		telfReceptor=recep;
		texto=text;
		this.esMMS=esMMS;
		
	}


	public String getTelfEmisor() {
		return telfEmisor;
	}


	public void setTelfEmisor(String telfEmisor) {
		this.telfEmisor = telfEmisor;
	}


	public String getTelfReceptor() {
		return telfReceptor;
	}


	public void setTelfReceptor(String telfReceptor) {
		this.telfReceptor = telfReceptor;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public boolean isEsMMS() {
		return esMMS;
	}


	public void setEsMMS(boolean esMMS) {
		this.esMMS = esMMS;
	}
	
}
