<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="naytwebapp.Commento"%>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Nayt | Altro</title>
      <!--======= style and javascript link ========-->
      <link rel="stylesheet" href="./css/altro.css">
      <link rel="stylesheet" href="./css/utili.css">
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
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
          <!--===== JQUERY LINK ======-->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
          <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
      
    <script src="./btn.js"></script>
</head> 
<body>

        <nav class="navbar navbar-expand-lg" id="navbar">
        <button class="navbar-toggler" id="btnLogo" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <img src="./img/LOGOBLACK.png" width="32px" height="32px">
              </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active" id="home">
                        <a class="nav-link" href="index.html">Home</a>
                    </li>
                    <li class="nav-item" id="bio">
                        <a class="nav-link" href="biografia.html">Biografia</a>
                    </li>
                    <li class="nav-item" id="frasi">
                        <a class="nav-link" href="frasi.html">Frasi</a>
                    </li>
                    <li class="nav-item" id="altro">
                        <form action="commenti" method="get" style="margin: 0 !important">
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
                <a class="brand" style="margin: 0; float: none; text-align:center; display: none !important" href="index.html" >
                    <img src="./img/LOGOBLACK.png" width="50px" height="50px">
                  </a>
            </div>
        </nav>


    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6 col-md-6-col-sm-12">
                    <h1 class="titolo_dati">Link Utili</h1>
                    <div class="row" style="text-align:center;margin-top:50px">
                            <div class="col-lg-6 col-md-6 col-sm-12">
                              
                            

        <!-- single item -->
        <div class="item">
            <img src="./img/maglia_nayt.jpeg" alt="item" />
             <h2 class="card_txt">Shop ufficiale Nayt</h2>
            <button id="shop" type="button"><a href="https://nayt.bigcartel.com/" target="_blank">Visita il Sito</a></button>
        </div>
        <!--/ single item -->



                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12">
  <!-- single item -->
  <div class="item">
            <img src="./img/jive_logo.jpg" alt="item" />
             <h2 class="card_txt">Informazioni su Jive</h2>
            <button id="shop" type="button"><a href="https://nayt.bigcartel.com/" target="_blank">Visita il Sito</a></button>
        </div>
        <!--/ single item -->
                            </div>
                    </div>

            </div>
            <div class="col-lg-6 col-md-6-col-sm-12" style="text-align: center;">
            <h1 class="titolo_dati">NOTIZIE</h1>
            <div class="box_notizie">
                    <div class="w3-panel">
                        <div class="row">
                            <div class="col-lg-2 col-sm-3">
                                <p>15-03-20</p>
                            </div>
                            <div class="col-lg-10 col-sm-9">
                                <p>Nayt si unisce all'iniziativa con il suo <a href="https://www.instagram.com/p/B9u4ItiqJNs/"><b>Covid Freestyle</b></a></p>
                            </div>
                        </div>
                      </div>
                    <div class="w3-panel">
                        <div class="row">
                            <div class="col-lg-2 col-sm-3">
                                <p>13-03-20</p>
                            </div>
                            <div class="col-lg-10 col-sm-9">
                                <p>Nayt partecipa nella
                                    canzone del giovane rapper Nicola Siciliano, dal titolo <b>Trip</b></p>
                            </div>
                        </div>
                      </div>
                      <div class="w3-panel">
                        <div class="row">
                            <div class="col-lg-2 col-sm-3">
                                <p>28-02-20</p>
                            </div>
                            <div class="col-lg-10 col-sm-9">
                                <p>Dopo Black Bloc, ecco una
                                    nuova collaborazione di Nayt con Il Tre, nel singolo chiamato <b>FIGHT!</b></p>
                            </div>
                        </div>
                      </div>
                      <div class="w3-panel">
                        <div class="row">
                            <div class="col-lg-2 col-sm-3">
                                <p>7-02-20</p>
                            </div>
                            <div class="col-lg-10 col-sm-9">
                                <p>Nayt partecipa nel nuovo
                                    brano di Jamil, chiamato <b>Come me</b></p>
                            </div>
                        </div>
                      </div>
                </div>
        </div>
    </div>
    
    <%
    
    	Vector <Commento> commenti = new Vector();
    	commenti =(Vector) request.getAttribute("commenti");
    
    %>
    
                <div class="row">
                        <div class="col-lg-6 col-md-12 col-sm-12">
                            <h1 class="titolo_dati"><a data-toggle="modal" data-target="#exampleModal" style="cursor:pointer;">Dicci la TUA</a></h1>
                            <!--box per gli utenti-->
                            <div class="accordion">
                        <div class="card">
                            <div id="raptus2" class="collapse show">
                                <div class="card-body">
                                
                                <%	int i;
                                	for(i=0; i<commenti.size(); i++){
                                		out.println("<div class='plx-card gold'>");
                                		out.println("<div class='pxc-bg'>  </div>");
                                		out.println(" <div class='pxc-stopper'></div>");
                                		out.println(" <div class='pxc-subcard'>");
                                		out.println(" <div class='pxc-title'>" + commenti.elementAt(i).getNomeUtente() +"</div>");
                                		out.println(" <div class='pxc-sub'>" + commenti.elementAt(i).getDataCommento() +"</div>");
                                		out.println(" <div class='pxc-feats'>" + commenti.elementAt(i).getCommento() +"</div>");
                                		out.println("</div></div>");
                                	}
                                
                                %>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    <div class="col-lg-6 col-md-12 col-sm-12">
                    <h1 class="titolo_dati">ALTRE INFO</h1>
                    <p class="informazioni">Ci tengo a precisare che il sito non contiene ne <b>Cookies</b> ne <b>pubblicit&agrave;†</b>. <br>
                        io non guadagno <b>niente</b> da questo sito e anzi devo anche pagarne l'hosting. <br>Per problemi riguardanti l'utilizzo illecito di immagini o alto, contattatemi e io provveder√≤
                        a controllare e in caso modificare il sito. </p>
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
                            &egrave stato creato anche per facilitare l'utenza a trovare frasi o informazioni su di lui e sulla sua carriera.
                            Inoltre il sito pu&ograve; essere un buon inizio per chi ha appena conosciuto Nayt.
                        </p>
                    </div>
                    <div class="col-md-4 footer-nav animated fadeInUp">
                        <h4>Nayt <i class="lni-pulse"></i></h4>
                        <div class="col-md-6">
                            <ul class="pages">
                                <li><a href="index.html">Home</a></li>
                                <li><a href="biografia.html">Biografia</a></li>
                                <li><a href="frasi.html">Frasi</a></li>
                                <li><a href="">Altro</a></li>
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
                        <p>Questo sito non ha scopo di lucro. Al suo interno non sono inserite pubblicit&agrave e non ci sono
                            cookie attivi. In caso di problemi o domande non esitate a contattarci via email.</p>
                            <p><a href="mailto:naytunofficial@gmail.com"><i class="far fa-envelope"></i></a></p>
                    </div>
                </div>
            </footer>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="far fa-times-circle" style="color: black !important;"></i></span>
                  </button>
                </div>
                <div class="modal-body">
        
                    <form class="form" action="commenti" method="post" id="comment_form">
                        <h2>Dicci la tua su Nayt</h2>
                        <p type="Commento:"><textarea name="commento" id="txtarea" cols="30" rows="10" id="commento" required></textarea></p>
                        <input type="reset" name="btn_reset" class="btnSend" value="Resetta">
                        <button type="submit" name="btn_commento" class="btnSend" style="width: 100% !important" id="btnComm">Invia</button>
                      </form>
        
                </div>
              </div>
            </div>
          </div>
</body>



</html>