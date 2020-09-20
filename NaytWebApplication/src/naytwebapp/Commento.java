package naytwebapp;

public class Commento implements java.io.Serializable{
	
	private String nomeUtente;
	private String commento;
	private String dataCommento;
	
	
	
	public Commento() {}



	public String getNomeUtente() {
		return nomeUtente;
	}



	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}



	public String getCommento() {
		return commento;
	}



	public void setCommento(String commento) {
		this.commento = commento;
	}



	public String getDataCommento() {
		return dataCommento;
	}



	public void setDataCommento(String dataCommento) {
		this.dataCommento = dataCommento;
	}
	
	
	
	
	
	
	
}
