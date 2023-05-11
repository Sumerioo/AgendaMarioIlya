package pruebasCajaNegra;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class EnviarMensajeTest {

	private ArrayList<Mensaje>mensajes=new ArrayList<Mensaje>();
	
	public void mensajeNoMMSnulo() {

		Mensaje mensaje = new Mensaje("666777888", "666555444", null,false);
		mensajes.add(mensaje);

	}
	
	public void mensajeNoMMS() {

		Mensaje mensaje = new Mensaje("666777888", "666555444", "Hola son las 7 de la mañana aqui ando programando",false);
		mensajes.add(mensaje);

	}
	
	public void mensajeMMS() {

		Mensaje mensaje = new Mensaje("666777888", "666555444", "Hola son las 7 de la mañana aqui ando programando",true);
		mensajes.add(mensaje);

	}
	
	@Test
	public void mensajesinSMSniMMS() {
		Mensaje  nuevo= new Mensaje("999888777","444555666",null,false);
		if( nuevo.isEsMMS()==false&&nuevo.getTexto()==null) {
			assertNull(nuevo.getTexto());
		}
		//Falta probar que tenga una foto, pero con el codigo actual es imposible.
	}
	
	@Test
	public void enviarMensajeSinContenido() {
		mensajeNoMMSnulo();
		
		for (Mensaje e:mensajes) {
			assertNull(e.getTexto());
		}
		
	}

	@Test
	public void enviarMensajeANumeroNoExistente() {
		mensajeMMS();
		Mensaje nuevo=new Mensaje("555666777","252233367","hola pepsi cola", false);
		mensajes.add(nuevo);
		boolean res=true;
		for(Mensaje e:mensajes) {
			if(!(nuevo.getTelfReceptor().equals(e.getTelfEmisor()))) {
				assertTrue(res);
			}else {
				res=false;
				assertTrue(res);
			}
		}
	}
	@Test 
	public void enviarMensajeCorrecto() {
		
		 // con el modelo actual no se puede hacer de la manera mas correcta, pero basicamente se le pregunta al usuario si sera un mms o un sms
		 // y comprobamos si es falso o verdadero el booleano de mms
		
		// Es un MMS? si
		
		Mensaje nuevo=new Mensaje("555666778","252233368","me fantas la pasa", true);
		
		assertTrue(nuevo.isEsMMS());
		
		//Se le pasa un true como que es un mms, en caso de ser falso la prueba dara fallo. ( X azul )
		
		
	}
	
}
