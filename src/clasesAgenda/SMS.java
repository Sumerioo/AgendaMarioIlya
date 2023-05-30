package clasesAgenda;
import java.util.*;
/**
 * Clase que crea SMS , extiende de Mensajes.
 * @see Mensaje
 * @author Mario e Ilya
 * @version 1.0
 * @since 30-05-2023
 */
import java.io.*;
public class SMS extends Mensaje{
	
	//Constructor
	public SMS(int telfEmisor, int telfReceptor, String texto) {
		super(telfEmisor,telfReceptor,texto);
	}
	
}
