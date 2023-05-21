package clasesAgenda;
import java.io.*;
import java.util.*;
public class AccesoFicheros {

	private static BufferedReader reader;
	private static BufferedWriter writer;
	private static final String RUTACONTACTOS="E:/FicherosAgenda/DataBaseContactosAgenda.txt";
	private static final String RUTAMENSAJES="E:/FicherosAgenda/DataBaseMensajesAgenda.txt";
	
	//Constructor ( MIRAR SI HACE FALTA)
	
	public AccesoFicheros() {
	}
	
//	public AccesoFicheros(String ruta) {
//		this.ruta=ruta;
//		try {
//			
//			writer = new BufferedWriter(new FileWriter(ruta));
//		} catch (IOException exc) {
//			System.err.println("Error critico al crear el acceso al fichero");
//		}
//	}
	
	//METODO LECTURA DE FICHEROS
	
	public static void leerFicheroContactos() {
		System.out.println("Mostrando base de datos de contactos...");
		try {
			reader = new BufferedReader(new FileReader(RUTACONTACTOS));
			String salida=reader.readLine();
			while(salida!=null) {
				System.out.println(salida);
				salida=reader.readLine();
			}
			reader.close();
		}catch(IOException exc) {
			System.err.println("Error al leer el fichero de contactos");		
		}
	}
	
	public static void leerFicheroMensajes() {
		System.out.println("Mostrando base de datos de mensajes...");
		try {
			reader = new BufferedReader(new FileReader(RUTAMENSAJES));
			String salida=reader.readLine();
			while(salida!=null) {
				System.out.println(salida);
				salida=reader.readLine();
			}
			reader.close();
		}catch(IOException exc) {
			System.err.println("Error al leer el fichero de mensajes");		
		}
	}
	
	//METODO ESCRITURA EN FICHEROS
	
	public static void escribirFicheroContactos(String contactoNuevo) {
		try {
			writer=new BufferedWriter(new FileWriter(RUTACONTACTOS,true)); // Añadido Append
			writer.write(contactoNuevo);
			writer.newLine();
			writer.close();
		}catch(IOException exc) {
			System.err.println("Error al escribir en el fichero de contactos");
		}
	}
	
	public static void escribirFicheroMensajes(String mensajeNuevo) {
		try {
			writer=new BufferedWriter(new FileWriter(RUTACONTACTOS,true)); //Añadido Append
			writer.write(mensajeNuevo);
			writer.newLine();
			
			writer.close();
		}catch(IOException exc) {
			System.err.println("Error al escribir en el fichero de mensajes");
		}
	}
	
	//METODOS BORRADO DE BASE DE DATOS EN FICHERO 
	
	public static void borradoFicheroContactos() {
		try {
			writer = new BufferedWriter(new FileWriter(RUTACONTACTOS));
			writer.write("");
			writer.close();
		} catch (IOException exc) {
			System.err.println("Error al borrar la base de datos");
		}
	}
	
	public static void borradoFicheroMensajes() {
		try {
			writer = new BufferedWriter(new FileWriter(RUTAMENSAJES));
			writer.write("");
			writer.close();
		} catch (IOException exc) {
			System.err.println("Error al borrar la base de datos");
		}
	}
	
	
}
	

