package clasesAgenda;

public abstract class Mensaje {
	//Atributos
	private int telfEmisor;
	private int telfReceptor;
	private String texto;
	
	
	//Constructor
	public Mensaje(int telfEmisor, int telfReceptor, String texto) {
		this.telfEmisor=telfEmisor;
		this.telfReceptor=telfReceptor;
		this.texto=texto;
	}

	//GETTERSySETTERS

	public int getTelfEmisor() {
		return telfEmisor;
	}


	public void setTelfEmisor(int telfEmisor) {
		this.telfEmisor = telfEmisor;
	}


	public int getTelfReceptor() {
		return telfReceptor;
	}


	public void setTelfReceptor(int telfReceptor) {
		this.telfReceptor = telfReceptor;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Mensaje [telfEmisor=" + telfEmisor + ", telfReceptor=" + telfReceptor + ", texto=" + texto + "]";
	}
	
	
}
