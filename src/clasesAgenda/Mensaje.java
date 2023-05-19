package clasesAgenda;

public abstract class Mensaje {
	//Atributos
	private int telfEmisor;
	private int telfReceptor;
	private String texto;
	int quitar;
	
	//Constructor
	public Mensaje(int telfEmisor, int telfReceptor, String texto) {
		this.telfEmisor=telfEmisor;
		this.telfReceptor=telfReceptor;
		this.texto=texto;
	}
	
	
}
