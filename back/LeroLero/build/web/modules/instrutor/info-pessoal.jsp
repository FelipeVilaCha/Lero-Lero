<%@page import="br.uff.util.Encriptador"%>
<%@page import="br.uff.model.Instrutores"%>
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
          <a class="navbar-brand text-white" href="homeInstrutor.jsp">
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
              <li><a href="turmas.jsp">Turmas</a></li>
              <li><a href="remuneracao.jsp">Remuneração</a></li>
              <li><a href="infoPessoal.jsp">Informações pessoais</a></li>
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
              Informações Pessoais
            </h4>
            <p class="mx-auto text-white  mt-20 mb-40">
              Adicione ou altere suas informações
            </p>
          </div>
        </div>
      </div>
    </section>
    <!-- ================ End banner Area ================= -->
    <section class="about-area section-gap">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-lg-5 col-md-6">
            <div class="card">
              <article class="card-body">
                <h4 class="card-title mb-1 mt-1">Perfil</h4>
                <button class="float-right" class="btn btn-primary" data-toggle="modal" data-target="#photo">Foto</button>
                <p class="card-title mb-4 mt-1">
                    Adicione ou altere informações pessoais
                </p>
                <form method="POST" action="http://localhost:8080/LeroLero/AtualizaInstrutor">
                  <div class="d-flex justify-content-between mt-2">
                    <div class="form-group">
                      <label>Nome</label>
                      <input
                        name="nome"
                        class="form-control"
                        minlength="3"
                        value="<%=((Instrutores) session.getAttribute("instrutorLogado")).getNome()%>"
                        type="text"
                      />
                    </div>
                    <div class="form-group">
                      <label>E-mail</label>
                      <input
                        name="email"
                        class="form-control"
                        value="<%=((Instrutores) session.getAttribute("instrutorLogado")).getEmail()%>"
                        type="email"
                      />
                    </div>
                  </div>
                  <div class="d-flex justify-content-between">
                    <div class="form-group">
                      <label>Valor cobrado por hora</label>
                      <input
                        name="valor_hora"
                        class="form-control"
                        value="<%=((Instrutores) session.getAttribute("instrutorLogado")).getValor_hora()%>"
                        type="number"
                      />
                    </div>
                    <div class="form-group">
                      <label>Experiencia</label>
                      <input
                        name="experiencia"
                        class="form-control"
                        value="<%=((Instrutores) session.getAttribute("instrutorLogado")).getExperiencia()%>"
                        type="number"
                      />
                    </div>
                  </div>
                  <!-- form-group// -->
                    <div class="form-group">
                      <label>Login</label>
                      <input
                        name="login"
                        class="form-control"
                        value="<%=((Instrutores) session.getAttribute("instrutorLogado")).getLogin()%>"
                        type="text"
                        minlength="3"
                      />
                    </div>
                    <div class="form-group">
                    <label>Senha</label>
                    <input
                      name="senha"
                      class="form-control"
                      value="<%= new Encriptador().desencripta(((Instrutores) session.getAttribute("instrutorLogado")).getSenha()).replaceAll(".", "*") %>"
                      minlength="3"
                      type="password"
                    />
                  </div>
                    <div class="form-group">
                    <label>Confirmar senha</label>
                    <input
                      class="form-control"
                      value="<%= new Encriptador().desencripta(((Instrutores) session.getAttribute("instrutorLogado")).getSenha()).replaceAll(".", "*") %>"
                      minlength="3"
                      type="password"
                    />
                  </div>
                  <!-- form-group// -->

                  <!-- form-group// -->
                  <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">
                      Salvar
                    </button>
                  </div>
                  <!-- form-group// -->
                </form>
              </article>
            </div>
            <!-- card.// -->
          </div>
        </div>
      </div>
    </section>
    <!--================= modal foto ======================== -->
    <div
      class="modal fade"
      id="photo"
      tabindex="-1"
      role="dialog"
      aria-labelledby="edit"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="card">
            <article class="card-body">
              <h4 class="card-title mb-4 mt-1">Incluir foto</h4>
              <form method="POST" action="http://localhost:8080/LeroLero/UploadFoto" enctype="multipart/form-data">
                  <div class="mb-2">Foto de Perfil</div>
                    <div class="input-group">
                      <div class="input-group-prepend">
                         <input type="submit" value="Upload" class="input-group-text" id="inputGroupFileAddon01">
                      </div>
                      <div class="custom-file">
                        <input
                            name="file"
                            type="file"
                            class="custom-file-input"
                            id="inputGroupFile01"
                            aria-describedby="inputGroupFileAddon01"
                      />
                      <label class="custom-file-label" for="inputGroupFile01">Escolha sua imagem</label>
                    </div>
                  </div>
              </form>
            </article>
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
  </body>
</html>
