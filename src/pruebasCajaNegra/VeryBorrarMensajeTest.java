package pruebasCajaNegra;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VeryBorrarMensajeTest {

	private ArrayList<Mensaje>mensajes=new ArrayList<Mensaje>();
	
	
	public void mensajeNoMMS() {
		
		Mensaje mensaje= new Mensaje("666777888","666555444","Hola son las 7 de la mañana aqui ando programando",false);
		mensajes.add(mensaje);
		
	}
	
	
	
	@Test
	public void borrarMensajeYaBorrado () {
		mensajeNoMMS();
		
		mensajes.remove(0);
		String telf="666777888";
		
		for(Mensaje e:mensajes) { ///TODO
			
			assertNull(e);
			
		}
	}
	
	@Test
	public void borrarMensajeContactoNoExiste() {
		mensajeNoMMS();
		String telf="666344566";
		boolean res=false;
		for(Mensaje e:mensajes) {
			if(telf.equals(e.getTelfEmisor())||telf.equals(e.getTelfReceptor())){
				mensajes.remove(e);
				res=true;
				assertFalse(res);
			}
		}
	}
	
	@Test
	public void borrarMensajeCorrecto() {
		mensajeNoMMS();
		String telf="666777888";
		boolean res=false;
		
		for(Mensaje e:mensajes) {
			
			if(telf.equals(e.getTelfEmisor())||telf.equals(e.getTelfReceptor())){
				mensajes.remove(e);
				res=true;
				assertTrue(res);
				break;
			}
			
		}
	}
	

}
