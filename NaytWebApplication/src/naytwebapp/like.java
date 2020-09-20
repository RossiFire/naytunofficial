package naytwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class like
 */
@WebServlet("/like")
public class like extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public like() {
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
		String frase ="frase mai cambiata, impossibile";
		//METTERE MI PIACE
		
		HttpSession session= request.getSession();
		
		//utente appena entrato nel sito non può mettere like
		if(session.isNew()) {
			frase = "Per mettere mi piace devi prima fare il login, oppure registrati cliccando <a href='user.html'>Qui</a>" ;
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("/Errori.jsp").forward(request, response);
		}
		
		//utente gia nel sito ma non ancora loggato/registrato
		if(session.getAttribute("user_session")==null) {
			frase = "Per mettere mi piace devi prima fare il login, oppure registrati cliccando <a href='user.html'>Qui</a>" ;
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("/Errori.jsp").forward(request, response);
		}else {
			//utente loggato e quindi può mettere mi piace
			String btnCanzone = request.getParameter("btnLike");
			int id_utente = Integer.parseInt(session.getAttribute("user_id").toString());
			PreparedStatement s;
			try {
				//ricerca dell'id della canzone a cui si sta mettendo like
				s = con.prepareStatement("SELECT id_canzone FROM canzoni WHERE nome_canzone=?");
				s.setString(1, btnCanzone);
				ResultSet res = s.executeQuery();
				int id_canzone=-1;
				while(res.next()) {
					id_canzone = res.getInt("id_canzone");					
				}
				//controllo se esiste gia il like
				s = con.prepareStatement("select fk_canzone, fk_utente FROM mipiace, canzoni, utenti WHERE fk_utente=? AND fk_canzone=? AND fk_utente=utenti.id AND fk_canzone=id_canzone");
				s.setInt(1, id_utente);
				s.setInt(2, id_canzone);
				res = s.executeQuery();
				
					
				if(res.isBeforeFirst()) {
					
					/*LIKE GIA ESISTENTE*/
					frase= "Hai gia messo mi piace a questa canzone";
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
				}else {
					
					//aggiunta like
					s = con.prepareStatement("INSERT INTO mipiace (fk_canzone, fk_utente) VALUES (?,?)");
					s.setInt(1, id_canzone);
					s.setInt(2, id_utente);
					int row= s.executeUpdate();
					if(row<=0) {
						frase = "Oops, non ha messo like" ;
					}else {
						frase = "Hai messo mi piace alla canzone";
					}
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
					
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				frase = "non so che errore possa trovare qua" ;
				request.setAttribute("frase", frase);
				request.getRequestDispatcher("/Errori.jsp").forward(request, response);
			}		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
