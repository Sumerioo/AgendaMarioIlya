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
	
	//SINCRONIZACION FICHERO CON ARRAYLISTS
	
	public static void updateARLCnt(ArrayList<Persona> agenda) {
		System.out.println("Sincronizando repositorios con ArrayList Contatos...");
		try {
			reader=new BufferedReader(new FileReader(RUTACONTACTOS));
			//writer=new BufferedWriter(new FileWriter(RUTACONTACTOS));
			String salida=reader.readLine();
			while(salida!=null) {
				String [] extractos=salida.split(";");
				int numero=Integer.parseInt(extractos[1]);
				agenda.add(new Usuario(extractos[0],numero)); //FALTA METER SI ES ADMIN O USU DE ALGUNA MANERA
				salida=reader.readLine();
			}
		}catch(IOException exc) {
			System.err.println("Problem encountered while updating ArrayLists.");
		}
	}
	
	public static void updateARLMsg(ArrayList<Mensaje> mensajes) {
		System.out.println("Sincronizando repositorios con ArrayList Mensajes...");
		try {
			reader=new BufferedReader(new FileReader(RUTAMENSAJES));
			String salida=reader.readLine();
			while(salida!=null) {
				String[]extractos=salida.split(";");
				int numEmi=Integer.parseInt(extractos[0]);
				int numRece=Integer.parseInt(extractos[1]);
				mensajes.add(new SMS(numEmi,numRece,extractos[2])); //FALTA LO MISMO QUE ANTRES, DIFERENCIAR SMS Y MMS
			}
		}catch(IOException exc) {
			System.err.println("Problem encountered while updating ArrayLists.");
		}
	}
	
	public static void deleteARLCnt(ArrayList<Persona> agenda, int posicion) {
		System.out.println("Borrando campo en repositorio de contatos...");
		try {
			writer=new BufferedWriter(new FileWriter(RUTACONTACTOS)); //Mirar si necesita append
			int contador=0;
			while(contador!=posicion) {
				writer.newLine(); ///NO FUNCIONA, HACER CON READER
				contador++;
			}
			if(contador==posicion) {
				writer.write("");   //Mirar si borra la linea o mete un espacio en blanco que cuente como otra linea
			}else {						// HACER CON IDEA DE CRISTINA DE QUE SIMPLEMENTE NO DEVUELVA LA LINEA 
				System.err.println("Error al encontrar puntero");
			}
			writer.close();
		}catch(IOException exc) {
			System.err.println("Problem encountered while deleting fields at repositories.");
		}
	}
	
	public static void deleteARLMsg(ArrayList<Mensaje> mensajes, int posicion) {
		
	}
	
	
	
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
	

