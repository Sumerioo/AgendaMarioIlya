package pruebasCajaNegra;

import static org.junit.Assert.*;

import org.junit.Test;

public class LogInTest {

	
	public boolean logIn(String telf) {
		
		return telf.matches(".*[0-9].*")&&telf.length()<=9;	
		
	}

	@Test
    public void logInNumIncorrecto() {
        String telf = "1234567891"; // teléfono incorrecto
      
        boolean result = logIn(telf);
        
        assertFalse(result); // el resultado debería ser falso
    }
    
    @Test
    public void logInNumOlvidado() {
        String telf = null; // teléfono no proporcionado
        
        assertNull(telf); // el resultado debería ser falso
    }
    
    @Test
    public void logInCorrecto() {
        String telf = "555555555"; // teléfono correcto
        
        boolean result = logIn(telf);
        
        assertTrue(result); // el resultado debería ser verdadero
    }
   
}
