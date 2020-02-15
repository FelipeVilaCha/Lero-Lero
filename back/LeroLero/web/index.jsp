<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt" class="no-js">
  <head>
    <!-- Mobile Specific Meta -->
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <!-- Favicon -->
    <link rel="shortcut icon" href="img/fav.png" />
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
    <link rel="stylesheet" href="css/linearicons.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="css/magnific-popup.css" />
    <link rel="stylesheet" href="css/owl.carousel.css" />
    <link rel="stylesheet" href="css/nice-select.css" />
    <link rel="stylesheet" href="css/hexagons.min.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css"
    />
    <link rel="stylesheet" href="css/main.css" />
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
              <li><a href="about.jsp">Sobre</a></li>
              <li><a href="http://localhost:8080/LeroLero/ListagemCursosDisponiveis">Cursos</a></li>
              <li><a href="http://localhost:8080/LeroLero/VisualizarInstrutores">Instrutores</a></li>
              <li><a href="http://localhost:8080/LeroLero/ListaComentarios">Comentários</a></li>
              <li>
                <a
                  class="text-white"
                  style="cursor: pointer"
                  data-toggle="modal"
                  data-target="#register"
                  >Registrar</a
                >
              </li>
              <li>
                <a
                  class="text-white"
                  style="cursor: pointer"
                  data-toggle="modal"
                  data-target="#login"
                  >Login</a
                >
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
    <!-- ================ End Header Area ================= -->

    <!-- ================ Start Login Modal ================= -->
    <div
      class="modal fade"
      id="login"
      tabindex="-1"
      role="dialog"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="card">
            <article class="card-body">
              <h4 class="card-title mb-4 mt-1">Login</h4>
              <form method="POST" action="http://localhost:8080/LeroLero/ProcessaLogin">
                <div class="form-group">
                  <label>Login</label>
                  <input
                    name="login"
                    class="form-control"
                    placeholder="Login"
                    type="text"
                    required
                  />
                </div>
                <!-- form-group// -->
                <div class="form-group">
                  <a class="float-right" href="#">Esqueceu sua senha?</a>
                  <label>Senha</label>
                  <input
                    name = "senha"
                    class="form-control"
                    placeholder="******"
                    minlength="3"
                    type="password"
                    required
                  />
                </div>
                <!-- form-group// -->
                <div class="form-group">
                    <div class="d-flex justify-content-between">
                        <label> <input type="radio" name="permissao" value="alunos"/> Alunos </label>
                        <label> <input type="radio" name="permissao" value="instrutores"/> Instrutores </label>
                        <label> <input type="radio" name="permissao" value="administrador"/> Administrador </label>
                  <!-- checkbox .// -->
                    </div>
                </div>
                <!-- form-group// -->
                <div class="form-group">
                  <button type="submit" class="btn btn-primary btn-block">
                    Entrar
                  </button>
                </div>
                <!-- form-group// -->
              </form>
            </article>
          </div>
        </div>
      </div>
    </div>
    <!-- ================ End Login Modal ================= -->

    <!-- ================ Start Register Modal ================= -->
    <div
      class="modal fade"
      id="register"
      tabindex="-1"
      role="dialog"
      aria-labelledby="exampleModalLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="card">
            <article class="card-body">
              <h4 class="card-title mb-4 mt-1">Registrar</h4>
              <form method="POST" action="http://localhost:8080/LeroLero/CadastraAluno">
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Nome</label>
                    <input
                      name="nome"
                      class="form-control"
                      minlength="3"
                      placeholder="Nome"
                      type="text"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>E-mail</label>
                    <input
                      name="email"
                      class="form-control"
                      placeholder="Email"
                      type="email"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>CPF</label>
                    <input
                      name="cpf"
                      class="form-control"
                      minlength="11"
                      maxlength="11"
                      placeholder="999.999.999-99"
                      type="text"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Celular</label>
                    <input
                      name="celular"
                      class="form-control"
                      placeholder="99 999 99999999"
                      minlength="14"
                      maxlength="14"
                      type="text"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>CEP</label>
                    <input
                      name="cep"
                      class="form-control"
                      minlength="8"
                      maxlength="8"
                      placeholder="21930150"
                      type="text"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Endereço</label>
                    <input
                      name="endereco"
                      class="form-control"
                      placeholder="Estrada do Galeão, 10"
                      type="text"
                      minlength="3"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Cidade</label>
                    <input
                      name="cidade"
                      class="form-control"
                      placeholder="Rio de Janeiro"
                      type="text"
                      minlength="3"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Bairro</label>
                    <input
                      name="bairro"
                      class="form-control"
                      placeholder="Rio de Janeiro"
                      type="text"
                      minlength="3"
                      required
                    />
                  </div>
                </div>
                <div class="form-group">
                    <label>Login</label>
                    <input
                      name="login"
                      class="form-control"
                      minlength="3"
                      placeholder="Login"
                      type="text"
                      required
                    />
                </div>
                <!-- form-group// -->
                <div class="form-group">
                  <label>Senha</label>
                  <input
                    name="senha"
                    class="form-control"
                    placeholder="******"
                    type="password"
                    minlength="3"
                    required
                  />
                </div>
                <div class="form-group">
                  <label>Confirmar senha</label>
                  <input
                    class="form-control"
                    placeholder="******"
                    minlength="3"
                    type="password"
                    required
                  />
                </div>
                <!-- form-group// -->

                <!-- form-group// -->
                <div class="form-group">
                  <button type="submit" class="btn btn-primary btn-block">
                    Cadastrar
                  </button>
                </div>
                <!-- form-group// -->
              </form>
            </article>
          </div>
        </div>
      </div>
    </div>
    <!-- ================ End Registrar Modal ================= -->

    <!-- ================ start banner Area ================= -->
    <section class="home-banner-area">
      <div class="container">
        <div class="row justify-content-center fullscreen align-items-center">
          <div class="col-lg-5 col-md-8 home-banner-left">
            <h1 class="text-white">
              Aprenda as melhores tecnologias
            </h1>
            <p class="mx-auto text-white  mt-20 mb-40">
              Imagine você dominando as mesmas tecnologias adotadas pelos
              melhores times do mundo, construindo aplicações de alta
              performance e se destacando entre os maiores programadores.
            </p>
          </div>
          <div class="offset-lg-2 col-lg-5 col-md-12 home-banner-right">
            <img class="img-fluid" src="img/header-img.png" alt="" />
          </div>
        </div>
      </div>
    </section>
    <!-- ================ End banner Area ================= -->

    <!-- ================ Start Feature Area ================= -->
    <section class="feature-area">
      <div class="container-fluid">
        <div class="feature-inner row">
          <div class="col-lg-2 col-md-6">
            <div class="feature-item d-flex">
              <i class="ti-book"></i>
              <div class="ml-20">
                <h4>Novas turmas</h4>
                <p>
                  A cada dia aumentando oportunidades.
                </p>
              </div>
            </div>
          </div>
          <div class="col-lg-2 col-md-6">
            <div class="feature-item d-flex">
              <i class="ti-cup"></i>
              <div class="ml-20">
                <h4>Novos Cursos</h4>
                <p>
                  Inove, se atualize. O que diferencia é o diferencial.
                </p>
              </div>
            </div>
          </div>
          <div class="col-lg-2 col-md-6">
            <div class="feature-item d-flex border-right-0">
              <i class="ti-desktop"></i>
              <div class="ml-20">
                <h4>E-Books</h4>
                <p>
                  Não há como não chegarmos até você, vem com a gente.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- ================ End Feature Area ================= -->

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

    <script src="js/vendor/jquery-2.2.4.min.js"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
      integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
      crossorigin="anonymous"
    ></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script
      type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"
    ></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/parallax.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    <script src="js/hexagons.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/main.js"></script>
            
  </body>
</html>
