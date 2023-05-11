package pruebasCajaNegra;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class VerAgendaTest {

	ArrayList<String>agenda=new ArrayList<String>();
	
	public void Agenda() {
		
		
		agenda.add("666777888");
		agenda.add("666555444");
		}
	
	@Test
	public void verContactoIncorrecto() {
		String telf="777888999";
		Agenda();
		boolean res=false;
		for( String e:agenda) {
			if(telf.equals(e)) {
				res=true;
			}else {
				res=false;
			}
		}
		assertFalse(res);
	}
	
	@Test
	public void verContactoCorrecto() {
		String telf="666777888";
		Agenda();
		boolean res=false;
		for( String e:agenda) {
			if(telf.equals(e)) {
				res=true;
				break;
			}else {
				res=false;
			}
		}
		assertTrue(res);
	}


}
