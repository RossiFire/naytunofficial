package naytwebapp;

public class User {

	private String nome;
	private String cognome;
	private String email;
	private String username;
	private String pass;
	
	public User() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
			return pass;
		}

	public void setPass(String pass) {
		String vera = pass;
		pass = "";
		for(int i=0;i<vera.length();i++) {
			pass = pass + "*";
		}
		this.pass = pass;
	}
	
	
}
