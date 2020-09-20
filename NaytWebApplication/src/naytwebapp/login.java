package naytwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }
    Connection con;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/nayt_unofficial?serverTimezone=UTC", "root", "");
		} catch (SQLException e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		// LOGOUT
		
		//prima volta che la sessione viene creata
		if(session.isNew()) {
			frase = "Per effettuare il logout devi prima aver fatto il login <br> puoi fare il login cliccando <a href='user.html'>Qui</a>";
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("Errori.jsp").forward(request, response);
		}
		//l'utente è nel sito da un po' ma non è loggato
		if(session.getAttribute("user_session")==null) {
			frase = "Per effettuare il logout devi prima aver fatto il login <br> puoi fare il login cliccando <a href='user.html'>Qui</a>";
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("Errori.jsp").forward(request, response);
		}
		//avvenuta logout
		session.setAttribute("user_session", "");
		session.invalidate();
		frase = "Hai effettuato il logout con successo <br> puoi rifare il login cliccando <a href='user.html'>Qui</a>";
		request.setAttribute("frase", frase);
		request.getRequestDispatcher("Errori.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String frase;
	String username;
	String password;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// LOGIN
		ResultSet res = null;
		PreparedStatement s;
		PrintWriter pw = response.getWriter();
		HttpSession session= request.getSession();
		String btnLog=request.getParameter("btnLog");
		
		// CONTROLLO SE SI ACCEDE CON IL LOGIN
		if(btnLog.equals("0")) {
			 username = request.getParameter("username");
			 password = request.getParameter("password");
			
			//controllo se c'è gia un utente registrato loggato
			if(session.getAttribute("user_session")!=null) {
				frase = "c'è gia un utente loggato su questo pc, si prega di effettuare prima il logout";
				request.setAttribute("frase", frase);
				request.getRequestDispatcher("Errori.jsp").forward(request, response);
			}else {
				try {
					s = con.prepareStatement("SELECT id,nome,cognome,email,username,pass FROM utenti WHERE username=? AND pass=?");
					s.setString(1, username);
					s.setString(2, password);
					ResultSet r= s.executeQuery();
					res= r;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//CONTROLLO SE SI ACCEDE DAL MENù
		}else {
			// se è la prima volta che entri devi prima loggarti
			if(session.isNew()) {
				frase = "Per visualizzare questa pagine devi fare il login, cliccando <a href='user.html'>Qui</a>" ;
				request.setAttribute("frase", frase);
				request.getRequestDispatcher("/Errori.jsp").forward(request, response);
			}
				//utente gia nel sito ma non loggato
				if(session.getAttribute("user_session")==null) {
					frase = "Per visualizzare questa pagine devi fare il login, cliccando <a href='user.html'>Qui</a>" ;
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
				}
				String session_id = session.getAttribute("user_id").toString();
				try {
					s = con.prepareStatement("SELECT id,nome,cognome,email,username,pass FROM utenti WHERE id=?");
					s.setString(1, session_id);
					ResultSet r= s.executeQuery();
					res=r;
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
			
			//LOGIN 
			try {
				//utente non esistente
				if(!res.isBeforeFirst()) {
					frase = "Nessun utente Trovato, potresti aver sbagliato username o password" ;
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
				}else { 
					//acquisizione di username e id per la sessione
					while(res.next()) {
						User u= new User();
						u.setNome(res.getString("nome"));
						u.setCognome(res.getString("cognome"));
						u.setEmail(res.getString("email"));
						u.setUsername(res.getString("username"));
						u.setPass(res.getString("pass"));
						request.setAttribute("dati_utente", u);
						session.setAttribute("user_session", res.getString("username"));	
						session.setAttribute("user_id", res.getString("id"));
					}
					
					/*ultimi like che hai messo*/
					Vector <Canzone> ultimi_like= new Vector();
					Vector <Canzone> nlike= new Vector();
					frase= "Hai gia messo mi piace a questa canzone";
					s = con.prepareStatement("select canzoni.nome_canzone, artista from canzoni, utenti, mipiace WHERE canzoni.id_canzone=mipiace.fk_canzone AND utenti.id=mipiace.fk_utente AND fk_utente=?");
					s.setInt(1, Integer.parseInt(session.getAttribute("user_id").toString()));
					res = s.executeQuery();	
					while(res.next()) {
						Canzone c = new Canzone();
						c.setNome_canzone(res.getString("nome_canzone"));
						c.setArtista(res.getString("artista"));
						ultimi_like.add(c);
					}
					request.setAttribute("frase", frase);
					request.setAttribute("ultimi_like", ultimi_like);
					
					/*canzoni con più like*/
					s=con.prepareStatement("select nome_canzone, artista, COUNT(canzoni.nome_canzone) as num from canzoni, utenti, mipiace WHERE canzoni.id_canzone=mipiace.fk_canzone AND utenti.id=mipiace.fk_utente group by nome_canzone order by num desc");
					res = s.executeQuery();
					while(res.next()) {
						Canzone c= new Canzone();
						c.setNome_canzone(res.getString("nome_canzone"));
						c.setArtista(res.getString("artista"));
						c.setNlike(res.getInt("num"));
						nlike.add(c);
					}
					request.setAttribute("nlike", nlike);
					request.getRequestDispatcher("/pagina_utente.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	
		
		/*
		
			frase= "per visualizzare questa pagina devi fare il login, cliccando <a href='user.html'>qui</a>";
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("Errori.jsp").forward(request, response);
		*/
		
		
	}


