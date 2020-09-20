package naytwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
 * Servlet implementation class registrazione
 */
@WebServlet("/registrazione")
public class registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrazione() {
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
	String frase;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Vector<String> user_disponibili = new Vector();
		HttpSession session = request.getSession();
		String nome = request.getParameter("name");
		String cognome = request.getParameter("surname");
		String mail = request.getParameter("mail");
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");

		// REGISTRAZIONE

		if (session.getAttribute("user_session") != null) {
			frase = "c'è gia un utente loggato al momento";
			request.setAttribute("frase", frase);
			request.getRequestDispatcher("/Errori.jsp").forward(request, response);
		}

		PreparedStatement s;
		try {
			// controllo se esiste gia quel nome
			s = con.prepareStatement("select username from utenti where username=?");
			s.setString(1, username);
			ResultSet confronto = s.executeQuery();

			// se gia esiste gliene suggerisco altri
			if (confronto.isBeforeFirst()) {
				frase = "Username gia esistente, sono disponibili i seguenti";
				int count = 0;
				int rnd;
				String disponibili;
				while (count < 3) {
					rnd = (int) (Math.random() * (200 - 1)) + 1;
					disponibili = username + rnd;
					s = con.prepareStatement("SELECT username FROM utenti WHERE username=?");
					s.setString(1, disponibili);
					confronto = s.executeQuery();
					if (!confronto.isBeforeFirst()) {
						user_disponibili.add(disponibili);
						count = count + 1;
					}
				}
				request.setAttribute("frase", frase);
				request.setAttribute("nomi_consigliati", user_disponibili);
				request.getRequestDispatcher("nomiConsigliati.jsp").forward(request, response);
			} else {

				// dopo aver controllato che non esiste lo aggiungo
				s = con.prepareStatement("INSERT INTO utenti (nome, cognome, email, username,pass) VALUES (?,?,?,?,?)");
				s.setString(1, nome);
				s.setString(2, cognome);
				s.setString(3, mail);
				s.setString(4, username);
				s.setString(5, password);
				int row = s.executeUpdate();
				// controllo errore
				if (row <= 0) {
					frase = "PROBABILMENTE ERRORE DI TIPO DI VALORE O ALTRO";
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
				}

				// aggiunta username alla sessione
				session.setAttribute("user_session", username);
				// query per recupero id per la sessione
				s = con.prepareStatement("SELECT id FROM utenti WHERE username=? AND pass=?");
				s.setString(1, username);
				s.setString(2, password);
				ResultSet res = s.executeQuery();

				// recupero id dell'utente appena inserito
				if (!res.isBeforeFirst()) {
					frase = "Errore, non so come si possa avere sto errore ma ok";
					request.setAttribute("frase", frase);
					request.getRequestDispatcher("/Errori.jsp").forward(request, response);
				} else {
					while (res.next()) {
						session.setAttribute("user_id", res.getString("id"));
					}
					response.sendRedirect("index.html");
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
