package pruebasCajaNegra;
import clasesAgenda.*;
import baulErrores.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LogInTest {

	
	

	Agenda agenda =new Agenda();
	
	@Test(expected = ErrorLogIn.class)
	public void logInException() throws ErrorLogIn {
		
		int numTelf = 103;
		agenda.logIn(numTelf);
		
	}
	
	
	@Test(expected = ErrorLogIn.class)
    public void logInNumIncorrecto() throws ErrorLogIn {
        int numtelf = 1234567891; // teléfono incorrecto
      
        int i= agenda.logIn(numtelf);
        
        boolean result=false;
        if(i==2) {
        assertFalse(result);// el resultado debería ser falso
        }else {
        result=true;
        assertFalse(result);
        }
    }

    
    @Test(expected = ErrorLogIn.class)
    public void logInCorrecto() throws ErrorLogIn {
        int numTelf2=101; // teléfono correcto
        
        int i= agenda.logIn(numTelf2);
        boolean result=true;
        if(i==2) {
        assertTrue(result); // el resultado debería ser verdadero
        }else {
        result=false;
        assertTrue(result);
        }
       
    }
   
}
