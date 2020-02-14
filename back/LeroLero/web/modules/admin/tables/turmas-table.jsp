<%@page import="br.uff.model.Turmas"%>
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
    <link rel="shortcut icon" href="../../../img/fav.png" />
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
    <link rel="stylesheet" href="../../../css/linearicons.css" />
    <link rel="stylesheet" href="../../../css/font-awesome.min.css" />
    <link rel="stylesheet" href="../../../css/bootstrap.css" />
    <link rel="stylesheet" href="../../../css/magnific-popup.css" />
    <link rel="stylesheet" href="../../../css/owl.carousel.css" />
    <link rel="stylesheet" href="../../../css/nice-select.css" />
    <link rel="stylesheet" href="../../../css/hexagons.min.css" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css"
    />
    <link rel="stylesheet" href="../../../css/main.css" />
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
              <li><a href="../index.jsp">Painel Administrativo</a></li>
              <li><a href="../registrar.jsp">Novos Registros</a></li>
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
            <h1 class="text-white">
              Admin
            </h1>
            <p class="mx-auto text-white  mt-20 mb-40">
              Turmas
            </p>
          </div>
        </div>
      </div>
    </section>
    <!-- ================ End banner Area ================= -->

    <!-- ================- Start Table Area ================= -->
    <section class="about-area section-gap">
      <div class="container">
        <div class="row ">
          <div class="col-lg-12">
            <div class="d-flex mb-4 mt-1 justify-content-between">
              <h4 class="card-title">Turmas</h4>
              <button
                class="btn btn-primary btn-xs"
                data-title="Inclui"
                data-toggle="modal"
                data-target="#inclui"
              >
                Incluir
              </button>
            </div>
            <table id="mytable" class="table table-bordred table-striped">
              <thead>
                <th>ID</th>
                <th>InstrutoresID</th>
                <th>CursosID</th>
                <th>Data inicio</th>
                <th>Data final</th>
                <th>Carga horária</th>
              </thead>
              <tbody>
                   <% for (int i = 0; i < ((List<Turmas>) session.getAttribute("listaTurmas")).size(); i++){
                            out.println("<tr>");
                            out.println("<td> " + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getId() + " </td>");
                            out.println("<td> " + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getInstrutores_id() + " </td>");
                            out.println("<td> " + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getCursos_id() + " </td>");
                            out.println("<td> " + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getData_inicio() + " </td>");
                            out.println("<td> " + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getData_final() + " </td>");
                            out.println("<td> " + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getCarga_horaria() + " </td>");
                            out.println("<td> <p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Edit\">");
                            out.println("<button class=\"btn btn-primary btn-xs\" data-title=\"Edit\" data-toggle=\"modal\" data-target=\"#edit\" data-id=\"" + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getId() + "\">Editar</button>");
                            out.println("</p></td>");
                            out.println("<td> <p data-placement=\"top\" data-toggle=\"tooltip\" title=\"Delete\">");
                            out.println("<button class=\"btn btn-danger btn-xs\" data-title=\"Delete\" data-toggle=\"modal\" data-target=\"#delete\" data-id=\"" + ((List<Turmas>) session.getAttribute("listaTurmas")).get(i).getId() + "\">Excluir</button>");
                            out.println("</p></td></tr>");
                 }%>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </section>
    <!-- ================- End Table Area ================= -->
    <!-- inclui modal -->
<div
      class="modal fade"
      id="inclui"
      tabindex="-1"
      role="dialog"
      aria-labelledby="inclui"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="card">
            <article class="card-body">
              <h4 class="card-title mb-4 mt-1">Cadastrar</h4>
              <form method="POST" action="http://localhost:8080/LeroLero/AdicionaTurma">
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Instrutor ID</label>
                    <input
                      name="instrutores_id"
                      class="form-control"
                      minlength="3"
                      placeholder="ID do instrutor"
                      type="number"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Curso ID</label>
                    <input
                      name="cursos_id"
                      class="form-control"
                      placeholder="ID do curso"
                      type="number"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Data inicio</label>
                    <input
                      name="data_inicio"
                      class="form-control"
                      placeholder="YYYY-MM-dd"
                      type="text"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Data final</label>
                    <input
                      name="data_final"
                      class="form-control"
                      placeholder="yyyy-MM-dd"
                      type="text"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Carga horária</label>
                    <input
                      name="carga_horaria"
                      class="form-control"
                      placeholder="Horas"
                      type="number"
                      required
                    />
                  </div>
                </div>
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
    <!-- edit modal -->
    <div
      class="modal fade"
      id="edit"
      tabindex="-1"
      role="dialog"
      aria-labelledby="edit"
      aria-hidden="true"
    >
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="card">
            <article class="card-body">
              <h4 class="card-title mb-4 mt-1">Atualizar</h4>
              <form method="POST" action="http://localhost:8080/LeroLero/AtualizaTurma">
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Instrutor ID</label>
                    <input
                      name="instrutor_id"
                      class="form-control"
                      placeholder="ID do instrutor"
                      type="number"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Curso ID</label>
                    <input
                      name="cursos_id"
                      class="form-control"
                      placeholder="ID do curso"
                      type="number"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                    <label>Data inicio</label>
                    <input
                      name="data_inicio"
                      class="form-control"
                      placeholder="yyyy-MM-dd"
                      type="text"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <label>Data final</label>
                    <input
                      name="data_final"
                      class="form-control"
                      placeholder="yyyy-MM-dd"
                      type="text"
                      required
                    />
                  </div>
                </div>
                <div class="d-flex justify-content-between">
                  <div class="form-group">
                  <label>Carga Horária</label>
                  <input
                        name="carga_horaria"
                        class="form-control"
                        placeholder="Horas"
                        type="number"
                        minlength="3"
                        required
                  />
                </div>
                </div>
                <!-- form-group// -->
                <div class="form-group">
                    <input type="hidden" class="form-control" name="id" id="id" >  
                <button type="submit" class="btn btn-primary btn-block">
                    Atualizar
                </button>
                </div>
                <!-- form-group// -->
              </form>
            </article>
          </div>
        </div>
      </div>
    </div>
    <!-- delete modal -->
    <div
      class="modal fade"
      id="delete"
      tabindex="-1"
      role="dialog"
      aria-labelledby="edit"
      aria-hidden="true"
    >
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button
              type="button"
              class="close"
              data-dismiss="modal"
              aria-hidden="true"
            >
              <span
                class="glyphicon glyphicon-remove"
                aria-hidden="true"
              ></span>
            </button>
            <h4 class="modal-title" id="Heading">
              Excluir
            </h4>
          </div>
          <div class="modal-body">
            <form action="http://localhost:8080/LeroLero/DeletaTurma" method="POST">
                <input type="hidden" class="form-control" name="instrutorID" id="id" >
              <div class="alert alert-danger">
              <span class="glyphicon glyphicon-warning-sign"></span> Você tem
              certeza que deseja excluir?
            </div>
            <div class="modal-footer ">
            <input type="submit" value="Sim" class="btn btn-success">
            <button type="button" class="btn btn-default" data-dismiss="modal">
              <span class="glyphicon glyphicon-remove"></span> Não
            </button>
            </div>
            </form>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
    </div>
    <!-- ================ End footer Area ================= -->

    <script>
      $(document).ready(function() {
        $("#mytable #checkall").click(function() {
          if ($("#mytable #checkall").is(":checked")) {
            $("#mytable input[type=checkbox]").each(function() {
              $(this).prop("checked", true);
            });
          } else {
            $("#mytable input[type=checkbox]").each(function() {
              $(this).prop("checked", false);
            });
          }
        });

        $("[data-toggle=tooltip]").tooltip();
      });
    </script>

    <script src="../../../js/vendor/jquery-2.2.4.min.js"></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
      integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
      crossorigin="anonymous"
    ></script>
    <script src="../../../js/vendor/bootstrap.min.js"></script>
    <script
      type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"
    ></script>
    <script src="../../../js/jquery.ajaxchimp.min.js"></script>
    <script src="../../../js/jquery.magnific-popup.min.js"></script>
    <script src="../../../js/parallax.min.js"></script>
    <script src="../../../js/owl.carousel.min.js"></script>
    <script src="../../../js/jquery.sticky.js"></script>
    <script src="../../../js/hexagons.min.js"></script>
    <script src="../../../js/jquery.counterup.min.js"></script>
    <script src="../../../js/waypoints.min.js"></script>
    <script src="../../../js/jquery.nice-select.min.js"></script>
    <script src="../../../js/main.js"></script>
    <script>
        $(function () {
            $('#delete').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            var id = button.data('id'); // Extract info from data-* attributes
            var modal = $(this);
            modal.find('#id').val(id);
            });
        });
    </script>
    <script>
        $(function () {
            $('#edit').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            var id = button.data('id'); // Extract info from data-* attributes
            var modal = $(this);
            modal.find('#id').val(id);
            });
        });
    </script>
  </body>
</html>
