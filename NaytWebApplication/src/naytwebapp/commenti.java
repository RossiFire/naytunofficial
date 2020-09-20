package naytwebapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class commenti
 */
@WebServlet("/commenti")
public class commenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commenti() {
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
		// CARICAMENTO PAGINA DEL COMMENTO
		Vector <Commento> cm =new Vector();
		PreparedStatement s;
		try {
			s = con.prepareStatement("SELECT username, testo_commento, data_commento FROM commenti, utenti WHERE utenti.id=fk_utente ORDER BY data_commento desc limit 20");
			ResultSet res= s.executeQuery();
			while(res.next()) {
				Commento comm = new Commento();
				comm.setNomeUtente(res.getString("username"));				
				comm.setCommento(res.getString("testo_commento"));
				comm.setDataCommento(res.getString("data_commento"));
				cm.add(comm);
			}
			
			request.setAttribute("commenti", cm);
			request.getRequestDispatcher("altro.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	String frase;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		// AGGIUNTA COMMENTO 
		
		// se è la prima volta che entri devi prima loggarti
		if(session.isNew()) {
			frase = "Per commentare devi prima fare il login, oppure puoi registrarti cliccando <a href='user.html'>Qui</a>" ;
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("/Errori.jsp").forward(request, response);
		}
			//utente gia nel sito ma non loggato
			if(session.getAttribute("user_session")==null) {
				frase = "Per commentare devi prima fare il login, oppure puoi registrarti cliccando <a href='user.html'>Qui</a>" ;
				request.setAttribute("frase", frase);
				request.getRequestDispatcher("/Errori.jsp").forward(request, response);
			}else {
				//utente loggato e può commentare
				int idUtente = Integer.parseInt(session.getAttribute("user_id").toString());
				String testo = request.getParameter("commento");
				PreparedStatement s;
				try {
					s = con.prepareStatement("INSERT INTO commenti (fk_utente, testo_commento, data_commento) VALUES (?,?,?)");
					s.setInt(1, idUtente);
					s.setString(2, testo);
					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					s.setString(3, dtf.format(now).toString());
					int row= s.executeUpdate();
					if(row==0) {
						frase = "errore nell'inserimento dell'utente" ;
						request.setAttribute("frase", frase);
						request.getRequestDispatcher("/Errori.jsp").forward(request, response);
					}else {
						doGet(request, response);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					frase = "non so che errore ci possa essere ma ok" ;
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
				}		
			}
	}

}
