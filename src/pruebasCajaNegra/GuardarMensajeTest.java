package pruebasCajaNegra;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GuardarMensajeTest {

ArrayList<String>telf=new ArrayList<String>();
ArrayList<String>nombre=new ArrayList<String>();
	
	public void TelfNombreNuevo() {
		
		
		telf.add("666777888");
		telf.add("666555444");
		nombre.add("Mario");
		nombre.add("Ilya");
		
		}
	
	
	@Test
	public void guardarContactoRepetido() {
		String telf="666777888";
		TelfNombreNuevo();
		boolean res=false;
		for(String e:this.telf) {
			if(telf.equals(e)) {
				assertFalse(res);
				break;
			}else {
				res=true;
				assertFalse(res);
			}
		}
		 
	}
	@Test
	public void guardarContactoNulo() {
		String telf=null;
		TelfNombreNuevo();
		assertNull(telf);
	}
	
	@Test
	public void guardarContatcoCorrecto() {
		String telf = "666789789";
		String nom="Jacinto";
		TelfNombreNuevo();
		boolean res = false;
		for (String e : this.telf) {
			if (telf.equals(e)) {
				assertTrue(res);
				break;
			} else {
				res = true;
				assertTrue(res);
			}
		}
		this.telf.add(telf);
		this.nombre.add(nom);
		}
	}
