package pruebasCajaNegra;
import clasesAgenda.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SacarPersonaTest {

	Agenda agenda =new Agenda();
	
	
	@Test
	public void sacarPersonaCorrecta() {
		int numTelf=101;
		boolean res=false;
		if(agenda.sacarPersona(numTelf) instanceof Persona) {
			res=true;
		}
		assertTrue(res);
	}

	@Test
	public void sacarPersonaIncorrecta() {
		int numTelf=102;
		boolean res=false;
		if(agenda.sacarPersona(numTelf) instanceof Persona) {
			res=true;
		}
		assertFalse(res);
	}
	
}
