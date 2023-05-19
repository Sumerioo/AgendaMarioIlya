package clasesAgenda;
import java.util.*;
import java.io.*;
public class MMS extends Mensaje{
	
	
	//Atributos
	
	private boolean tieneImagen;
	
	//Constructor
	
	public MMS(int telfEmisor, int telfReceptor, String texto, boolean tieneImagen) {
		super(telfEmisor,telfReceptor,texto);
		this.tieneImagen=tieneImagen;
	}
}
