package clasesAgenda;
import java.io.*;
import java.util.*;
public class AccesoFicheros {

	private static BufferedReader reader;
	private BufferedWriter writer;
	private static final String RUTACONTACTOS="E:/FicherosAgenda/DataBaseContactosAgenda.txt";
	
	//Constructor ( MIRAR SI HACE FALTA)
//	public AccesoFicheros(String ruta) {
//		this.ruta=ruta;
//		try {
//			
//			writer = new BufferedWriter(new FileWriter(ruta));
//		} catch (IOException exc) {
//			System.err.println("Error critico al crear el acceso al fichero");
//		}
//	}
	
	//METODO LECTURA DEL FICHERO
	public static void leerFicheroContactos() {
		try {
			reader = new BufferedReader(new FileReader(RUTACONTACTOS));
			String salida=reader.readLine();
			while(salida!=null) {
				System.out.println(salida);
				salida=reader.readLine();
			}
		}catch(IOException exc) {
			
		}
		
	}
}
