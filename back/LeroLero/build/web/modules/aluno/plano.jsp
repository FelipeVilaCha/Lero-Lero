<%@page import="br.uff.model.PlanoEstudos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
  <head>
    <!-- Mobile Specific Meta -->
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Favicon -->
    <link rel="shortcut icon" href="../../img/fav.png" />
    <!-- Author Meta -->
    <meta name="author" content="colorlib" />
    <!-- Meta Description -->
    <meta name="description" content="" />
    <!-- Meta Keyword -->
    <meta name="keywords" content="" />
    <!-- meta character set -->
    <meta charset="UTF-8" />
    <!-- Site Title -->
    <title>LeroLero - Cursos de TI online</title>

    <link
      href="https://fonts.googleapis.com/css?family=Playfair+Display:900|Roboto:400,400i,500,700"
      rel="stylesheet"
    />
    <!--
      CSS
      =============================================
    -->
    <link rel="stylesheet" href="../../css/linearicons.css" />
    <link rel="stylesheet" href="../../css/font-awesome.min.css" />
    <link rel="stylesheet" href="../../css/bootstrap.css" />
    <link rel="stylesheet" href="../../css/magnific-popup.css" />
    <link rel="stylesheet" href="../../css/owl.carousel.css" />
    <link rel="stylesheet" href="../../css/nice-select.css" />
    <link rel="stylesheet" href="../../css/hexagons.min.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css"
    />
    <link rel="stylesheet" href="../../css/main.css" />
  </head>

  <body>
    <!-- ================ Start Header Area ================= -->
    <header class="default-header">
      <nav class="navbar navbar-expand-lg  navbar-light">
        <div class="container">
          <a class="navbar-brand text-white" href="index.jsp">
            LeroLero
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="lnr lnr-menu"></span>
          </button>

          <div
            class="collapse navbar-collapse justify-content-end align-items-center"
            id="navbarSupportedContent"
          >
            <ul class="navbar-nav">
              <li><a href="index.jsp">Home</a></li>
              <li><a href="http://localhost:8080/LeroLero/MontaPlanoDeEstudos">Plano atual</a></li>
              <li><a href="http://localhost:8080/LeroLero/CursosTurmasDisponiveis">Cursos Disponíveis</a></li>
              <li><a href="info-pessoal.jsp">Informações pessoais</a></li>
              <li><a href="http://localhost:8080/LeroLero/ProcessaLogout">Logout</a></li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    <!-- ================ End Header Area ================= -->

    <!-- ================ start banner Area ================= -->
    <section class="banner-area">
      <div class="container">
        <div class="row justify-content-center align-items-center">
          <div class="col-lg-12 banner-right">
            <h4 class="text-white">
              Meus cursos
            </h4>
            <p class="mx-auto text-white  mt-20 mb-40">
              Saiba como está sua performance ou a nota dos seus cursos
            </p>
          </div>
        </div>
      </div>
    </section>
    <!-- ================ End banner Area ================= -->

    <!-- ================ Plano Estudos Area ================= -->
    <section class="popular-course-area section-gap">
      <div class="container-fluid">
        <div class="row justify-content-center section-title">
          <div class="col-lg-12">
            <h2>Meus cursos <br /></h2>
            <p>
              Seus cursos disponíveis estão te esperando
            </p>
          </div>
        </div>

        <div class="container">
          <div class="row align-items-center">
            <% for(int i = 0; i < ((List<PlanoEstudos>) session.getAttribute("planoEstudos")).size(); i++){
                    out.println("<div class=\"col-lg-4\">");
                    out.println("<div class=\"card\" style=\"width: 18rem;\">");
                    out.println("<img class=\"f-img img-fluid mx-auto\" src=\"../../img/popular-course/p4.jpg\" alt=\"\" />");
                    out.println("<div class=\"card-body\">");
                    out.println("<div class=\"d-flex justify-content-between mb-20\">");
                    out.println("<h5> " + ((List<PlanoEstudos>) session.getAttribute("planoEstudos")).get(i).getNome_curso() + " </h5>");
                    out.println("</div>");
                    out.println("<p>    Professor: " + ((List<PlanoEstudos>) session.getAttribute("planoEstudos")).get(i).getNome_professor() + "</p>");
                    out.println("<p>    Carga Horária: " + ((List<PlanoEstudos>) session.getAttribute("planoEstudos")).get(i).getCarga_horaria() + "</p>");
                    out.println("<a href=\"http://localhost:8080/LeroLero/MontaPlanoDeEstudos\" class=\"btn btn-primary mt-3\">Comece agora</a>");
                    out.println("<button type=\"button\" class=\"btn btn-primary mt-3\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-nota=\""+ ((List<PlanoEstudos>) session.getAttribute("planoEstudos")).get(i).getNota() +"\">");
                    out.println("Ver nota</button>");
                    out.println("</div> </div> </div>");
            }%>
                </div>
              </div>
            </div>
    </section>
    <!-- ================ End Plano Estudos Area ================= -->
    
    <!-- ================ Historico Area================= -->
    <section class="popular-course-area section-gap">
      <div class="container-fluid">
        <div class="row justify-content-center section-title">
          <div class="col-lg-12">
            <h2>Já finalizados <br /></h2>
            <p>
              Esses cursos já foram finalizados.
            </p>
          </div>
        </div>

        <div class="container">
          <div class="row align-items-center">
            <% for(int i = 0; i < ((List<PlanoEstudos>) session.getAttribute("historico")).size(); i++){
                    out.println("<div class=\"col-lg-4\">");
                    out.println("<div class=\"card\" style=\"width: 18rem;\">");
                    out.println("<img class=\"f-img img-fluid mx-auto\" src=\"../../img/popular-course/p4.jpg\" alt=\"\" />");
                    out.println("<div class=\"card-body\">");
                    out.println("<div class=\"d-flex justify-content-between mb-20\">");
                    out.println("<h5> " + ((List<PlanoEstudos>) session.getAttribute("historico")).get(i).getNome_curso() + " </h5>");
                    out.println("</div>");
                    out.println("<p>    Professor: " + ((List<PlanoEstudos>) session.getAttribute("historico")).get(i).getNome_professor() + "</p>");
                    out.println("<p>    Carga Horária: " + ((List<PlanoEstudos>) session.getAttribute("historico")).get(i).getCarga_horaria() + "</p>");
                    out.println("<a href=\"http://localhost:8080/LeroLero/MontaPlanoDeEstudos\" class=\"btn btn-primary mt-3\">Comece agora</a>");
                    out.println("<button type=\"button\" class=\"btn btn-primary mt-3\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-nota=\""+ ((List<PlanoEstudos>) session.getAttribute("historico")).get(i).getNota() +"\">");
                    out.println("Ver nota</button>");
                    out.println("</div> </div> </div>");
            }%>
                </div>
              </div>
            </div>
    </section>
    <!-- ================ End Historico Area ================= -->
    <!-- Modal de nota -->
    <div
      class="modal fade"
      id="exampleModal"
      tabindex="-1"
      role="dialog"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Sua nota</h5>
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-label="Close"
            >
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
              <div class="form-group">
                  <label> Nota </label>
                  <input type="number" class="form-control" id="nota" readonly />
                  </div>
                    <div class="form-group">
                        <label> Avaliação do curso </label>
                        <form action="http://localhost:8080/LeroLero/ProcessaComentarios" method="POST">
                            <input type="text" class="form-control" rows="2" id="comment" name="comentario" placeholder="Aprendi tudo o que eu sei sobre javascript aqui, enorme gratidão a plataforma LeroLero." >
                    </div>
                    <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal" > Fechar </button>
                    <input type="submit" class="btn btn-primary" value="Salvar alterações" />
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- ================ start footer Area ================= -->
    <footer class="footer-area section-gap">
      <div class="container">
        <div class="footer-bottom row align-items-center">
          <p class="footer-text m-0 col-lg-8 col-md-12">
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
            Copyright &copy;
            <script>
              document.write(new Date().getFullYear());
            </script>
            Desenvolvido
            <i class="fa fa-heart-o" aria-hidden="true"></i> por
            <a href="#" target="_blank">Nicholas e Felipe</a>
            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
          </p>
          <div class="col-lg-4 col-md-12 footer-social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-dribbble"></i></a>
            <a href="#"><i class="fa fa-behance"></i></a>
          </div>
        </div>
      </div>
    </footer>
    <!-- ================ End footer Area ================= -->

    <script src="../../js/vendor/jquery-2.2.4.min.js"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
      integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
      crossorigin="anonymous"
    ></script>
    <script src="../../js/vendor/bootstrap.min.js"></script>
    <script
      type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"
    ></script>
    <script src="../../js/jquery.ajaxchimp.min.js"></script>
    <script src="../../js/jquery.magnific-popup.min.js"></script>
    <script src="../../js/parallax.min.js"></script>
    <script src="../../js/owl.carousel.min.js"></script>
    <script src="../../js/jquery.sticky.js"></script>
    <script src="../../js/hexagons.min.js"></script>
    <script src="../../js/jquery.counterup.min.js"></script>
    <script src="../../js/waypoints.min.js"></script>
    <script src="../../js/jquery.nice-select.min.js"></script>
    <script src="../../js/main.js"></script>
    <script>
        $(function () {
            $('#exampleModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            var nota = button.data('nota'); // Extract info from data-* attributes
            var modal = $(this);
            modal.find('#nota').val(nota);
            });
        });
    </script>
  </body>
</html>
