package clasesAgenda;
import java.util.*;

import java.io.*;
/**
 * Clase que crea MMS , extiende de Mensajes.
 * @see Mensaje
 * @author Mario e Ilya
 * @version 1.0
 * @since 30-05-2023
 */
public class MMS extends Mensaje{
	
	
	//Atributos
	
	private boolean tieneImagen;
	
	//Constructor
	
	public MMS(int telfEmisor, int telfReceptor, String texto, boolean tieneImagen) {
		super(telfEmisor,telfReceptor,texto);
		this.tieneImagen=tieneImagen;
	}
}
