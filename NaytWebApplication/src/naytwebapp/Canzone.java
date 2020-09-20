package naytwebapp;

public class Canzone implements java.io.Serializable{
	String nome_canzone;
	String artista;
	int nlike;
	
	
	public Canzone() {
		
	}

	public String getNome_canzone() {
		return nome_canzone;
	}


	public void setNome_canzone(String nome_canzone) {
		this.nome_canzone = nome_canzone;
	}


	public String getArtista() {
		return artista;
	}


	public void setArtista(String artista) {
		this.artista = artista;
	}

	
	public void setNlike(int nlike){
		this.nlike = nlike;
	}
	
	public int getNlike() {
		return nlike;
	}
	
	
	
	
	
	
}
