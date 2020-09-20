<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*"
    pageEncoding="ISO-8859-1" import="naytwebapp.User" import="naytwebapp.Canzone"%>
    <!DOCTYPE html>
    <html lang="it">
    <head>
        <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Utente - NaytUnofficial</title>
    <!--======= style and javascript link ========-->
    <link rel="stylesheet" href="./css/user.css">
    <link rel="stylesheet" href="./css/utili.css">
    <link rel="stylesheet" href="./css/errore.css">
    <link rel="shortcut icon" href="./img/LOGO.png" type="image/x-icon">
    <!--======== bootstrap =========-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
    <!--========= line icons ======-->
    <link rel="stylesheet" href="https://cdn.lineicons.com/1.0.1/LineIcons.min.css">
    <!--========= font awesome =======-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
        integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <!--===== JQUERY LINK ======-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
    </head>
    <body>
        <nav class="navbar navbar-expand-lg" id="navbar">
            <button class="navbar-toggler" id="btnLogo" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <img src="./img/LOGOBLACK.png" width="32px" height="32px">
              </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item" id="home">
                        <a class="nav-link" href="index.html">Home</a>
                    </li>
                    <li class="nav-item" id="bio">
                        <a class="nav-link" href="biografia.html">Biografia</a>
                    </li>
                    <li class="nav-item" id="frasi">
                        <a class="nav-link" href="frasi.html">Frasi</a>
                    </li>
                    <li class="nav-item" id="altro">
                        <form action="commenti" method="get">
                            <button type="submit" class="nav-link nav-btn" style="margin: auto !important">Altro</button>
                        </form>
                    </li>
                    <li class="nav-item" id="user">
                        <a class="nav-link" href="user.html">Login</a>
                    </li>
                     <li class="nav-item" id="pag_utente">
                        	<form action="login" method="post">
	                           <button type="submit" class="nav-btn nav-link" style="margin: auto !important" name="btnLog" value="1">Utente</button>
                        	</form>
                        </li>
                </ul>
            </div>
            <a class="brand" style="margin: 0; float: none; text-align:center; display: none !important" href="index.html">
                <img src="./img/LOGOBLACK.png" width="50px" height="50px">
              </a>
        </nav>
        
        
        
         <div class="container-fluid" style="margin-top: 20px !important;">
         <p class="titolo_dati">INFORMAZIONI UTENTE	</p>
            <div class="row" style="margin-top: 20px !important; text-align: center;">
            <%
            User u;
            u= (User)request.getAttribute("dati_utente");
            out.println("<div class='col-lg-6 col-md-12 col-sm-12'>");
                out.println("<p class='like'>Nome:<span class='gold'> " + u.getNome() + "</span></p>");
                out.println("<p class='like'>Cognome:<span class='gold'> " + u.getCognome() + "</span></p>");
                out.println("<p class='like'>Email: <span class='gold'>" + u.getEmail() + "</span></p></div>");
            out.println("<div class='col-lg-6 col-md-12 col-sm-12'>");
                out.println("<p class='like'>Username:<span class='gold'> " + u.getUsername() + "</span></p>");
                out.println("<p class='like'>Password:<span class='gold'> " + u.getPass() + "</span></p></div>");
                %>
            </div>
         </div>
         
         		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12">
					
					<%
					out.println("<p class='titolo_dati'> ULTIMI LIKE CHE HAI MESSO</p>");
							int i;
							Vector <Canzone> like = new Vector();
							like = (Vector)request.getAttribute("ultimi_like");
							for(i=0;i<like.size();i++){
								out.println("<p class='like'>" + like.elementAt(i).getNome_canzone() + " di " + like.elementAt(i).getArtista() + "</p>");
							}
		
		
					%>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12">
				<%
					out.println("<p class='titolo_dati'> Canzoni con pi&Uacute; like</p>");
							int h;
							Vector <Canzone> nlike = new Vector();
							nlike = (Vector)request.getAttribute("nlike");
							for(h=0;h<nlike.size();h++){
								out.println("<p class='like'>" + nlike.elementAt(h).getNome_canzone() + " di " + nlike.elementAt(h).getArtista() + ", " + "<i class='lni lni-heart-filled'></i>" + nlike.elementAt(h).getNlike() +"</p>");
							}
		
		
					%>
				</div>
			</div>
			 <div class="bottoni">
                	<form action="login" method="get">
                   		<button type="submit" class="btnUser">Logout</button>
                 	</form>
                </div>
			
		</div>
		
    <!-- FOOTER-->
    <div class="container-fluid">
        <section style="height:80px;"></section>
        <!----------- Footer ------------>
        <footer class="footer-bs">
            <div class="row">
                <div class="col-md-3 footer-brand animated fadeInLeft">
                    <h5>info sul sito <i class="lni-pulse"></i></h5>
                    <p>Questo sito nasce principalmente dalla passione per Nayt.
                         è stato creato anche per facilitare l'utenza a trovare frasi o informazioni su di lui e sulla sua carriera.
                         Inoltre il sito può essere un buon inizio per chi ha appena conosciuto Nayt.
                    </p>
                </div>
                <div class="col-md-4 footer-nav animated fadeInUp">
                    <h4>Nayt <i class="lni-pulse"></i></h4>
                    <div class="col-md-6">
                        <ul class="pages">
                            <li><a href="">Home</a></li>
                            <li><a href="biografia.html">Biografia</a></li>
                            <li><a href="frasi.html">Frasi</a></li>
                            <li><a href="altro.php">Altro</a></li>
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <ul class="list">
                            <li><a href="https://www.instagram.com/nayt/" target="_blank"><i
                                        class="fab fa-instagram"></i></a>
                                <a href="https://open.spotify.com/artist/7tmTvmqgTBcX88ZrSHByrD?si=cwXaBLUNTMuZ7Zyk1bj47g" target="_blank"><i
                                        class="fab fa-spotify"></i></a>
                                    <a href="https://twitter.com/nayt1ne" target="_blank"><i
                                                class="fab fa-twitter"></i></a>
                                <a href="https://www.youtube.com/user/torredicontrollo21/videos" target="_blank"><i
                                        class="fab fa-youtube"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-2 footer-social animated fadeInDown">
                    <h4>Seguimi <i class="lni-pulse"></i></h4>
                    <ul>
                        <li><a href="https://www.instagram.com/naytunofficialsite/" target="_blank">Nayt Unofficial</a></li>
                        <li><a href="https://www.instagram.com/dna.iele/" target="_blank">Daniele</a></li>
                    </ul>
                </div>
                <div class="col-md-3 footer-ns animated fadeInRight">
                    <h4>Informazioni</h4>
                    <p>Questo sito non ha scopo di lucro. Al suo interno non sono inserite pubblicità e non ci sono
                        cookie attivi. In caso di problemi o domande non esitate a contattarmi via email.</p>
                        <p><a href="mailto:naytunofficial@gmail.com"><i class="far fa-envelope"></i></a></p>
                </div>
            </div>
        </footer>
    </div>
         
         
         
         
         
    </body>
    </html>