package org.apache.jsp.modules.admin.tables;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.uff.model.Instrutores;
import br.uff.model.Turmas;
import br.uff.model.Cursos;
import java.util.List;

public final class cursos_002dinstrutores_002dtable_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  @Override
  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zxx\" class=\"no-js\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <!-- Mobile Specific Meta -->\r\n");
      out.write("    <meta\r\n");
      out.write("      name=\"viewport\"\r\n");
      out.write("      content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"\r\n");
      out.write("    />\r\n");
      out.write("    <!-- Favicon -->\r\n");
      out.write("    <link rel=\"shortcut icon\" href=\"../../../img/fav.png\" />\r\n");
      out.write("    <!-- Author Meta -->\r\n");
      out.write("    <meta name=\"author\" content=\"colorlib\" />\r\n");
      out.write("    <!-- Meta Description -->\r\n");
      out.write("    <meta name=\"description\" content=\"\" />\r\n");
      out.write("    <!-- Meta Keyword -->\r\n");
      out.write("    <meta name=\"keywords\" content=\"\" />\r\n");
      out.write("    <!-- meta character set -->\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <!-- Site Title -->\r\n");
      out.write("    <title>LeroLero - Cursos de TI online</title>\r\n");
      out.write("\r\n");
      out.write("    <link\r\n");
      out.write("      href=\"https://fonts.googleapis.com/css?family=Playfair+Display:900|Roboto:400,400i,500,700\"\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("    />\r\n");
      out.write("    <!--\r\n");
      out.write("      CSS\r\n");
      out.write("      =============================================\r\n");
      out.write("    -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/linearicons.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/font-awesome.min.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/magnific-popup.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/owl.carousel.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/nice-select.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/hexagons.min.css\" />\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://cdn.jsdelivr.net/themify-icons/0.1.2/css/themify-icons.css\"\r\n");
      out.write("    />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../../../css/main.css\" />\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
      out.write("    <!-- ================ Start Header Area ================= -->\r\n");
      out.write("    <header class=\"default-header\">\r\n");
      out.write("      <nav class=\"navbar navbar-expand-lg  navbar-light\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("          <a class=\"navbar-brand text-white\" href=\"index.jsp\">\r\n");
      out.write("            LeroLero\r\n");
      out.write("          </a>\r\n");
      out.write("          <button\r\n");
      out.write("            class=\"navbar-toggler\"\r\n");
      out.write("            type=\"button\"\r\n");
      out.write("            data-toggle=\"collapse\"\r\n");
      out.write("            data-target=\"#navbarSupportedContent\"\r\n");
      out.write("            aria-controls=\"navbarSupportedContent\"\r\n");
      out.write("            aria-expanded=\"false\"\r\n");
      out.write("            aria-label=\"Toggle navigation\"\r\n");
      out.write("          >\r\n");
      out.write("            <span class=\"lnr lnr-menu\"></span>\r\n");
      out.write("          </button>\r\n");
      out.write("\r\n");
      out.write("          <div\r\n");
      out.write("            class=\"collapse navbar-collapse justify-content-end align-items-center\"\r\n");
      out.write("            id=\"navbarSupportedContent\"\r\n");
      out.write("          >\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("              <li><a href=\"../index.jsp\">Painel Administrativo</a></li>\r\n");
      out.write("              <li><a href=\"http://localhost:8080/LeroLero/ListaSolicitacoes\">Novos Registros</a></li>\r\n");
      out.write("              <li><a href=\"http://localhost:8080/LeroLero/ProcessaLogout\">Logout</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("    <!-- ================ End Header Area ================= -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ================ start banner Area ================= -->\r\n");
      out.write("    <section class=\"banner-area\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row justify-content-center align-items-center\">\r\n");
      out.write("          <div class=\"col-lg-12 banner-right\">\r\n");
      out.write("            <h1 class=\"text-white\">\r\n");
      out.write("              Admin\r\n");
      out.write("            </h1>\r\n");
      out.write("            <p class=\"mx-auto text-white  mt-20 mb-40\">\r\n");
      out.write("              Listagem de cursos de cada instrutor\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- ================ End banner Area ================= -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ================- Start Table Area ================= -->\r\n");
      out.write("    <section class=\"about-area section-gap\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"row \">\r\n");
      out.write("          <div class=\"col-lg-12\">\r\n");
      out.write("            <div class=\"d-flex mb-4 mt-1 justify-content-between\">\r\n");
      out.write("              <h4 class=\"card-title\">Cursos e Instrutores</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <table id=\"mytable\" class=\"table table-bordred table-striped\">\r\n");
      out.write("              <thead>\r\n");
      out.write("                <th>ID Curso</th>\r\n");
      out.write("                <th>Cursos</th>\r\n");
      out.write("                <th>Instrutor</th>\r\n");
      out.write("                <th>Salário Total</th>\r\n");
      out.write("              </thead>\r\n");
      out.write("              <tbody>\r\n");
      out.write("                  ");
      for (int i = 0; i < ((List<Cursos>) session.getAttribute("listaCursos")).size(); i++){
            for (int j = 0; j < ((List<Turmas>) session.getAttribute("listaTurmas")).size(); j++){
                if(((List<Cursos>) session.getAttribute("listaCursos")).get(i).getId() == ((List<Turmas>) session.getAttribute("listaTurmas")).get(j).getCursos_id()){
                    for (int k = 0; k < ((List<Instrutores>) session.getAttribute("listaInstrutores")).size(); k++){
                        out.println("<tr>");
                        out.println("<td>" + ((List<Cursos>) session.getAttribute("listaCursos")).get(i).getId() + "</td>");
                        out.println("<td>" + ((List<Instrutores>) session.getAttribute("listaInstrutores")).get(k).getNome() + "</td>");
                        out.println("<td>" + ((List<Cursos>) session.getAttribute("listaCursos")).get(i).getCarga_horaria() * ((List<Instrutores>) session.getAttribute("listaInstrutores")).get(k).getValor_hora()+ "</td>");
                        out.println("</tr>");
                    }
                }
            }
        }
                
      out.write("\r\n");
      out.write("              </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    <!-- ================- End Table Area ================= -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ================ start footer Area ================= -->\r\n");
      out.write("    <footer class=\"footer-area section-gap\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"footer-bottom row align-items-center\">\r\n");
      out.write("          <p class=\"footer-text m-0 col-lg-8 col-md-12\">\r\n");
      out.write("            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("            Copyright &copy;\r\n");
      out.write("            <script>\r\n");
      out.write("              document.write(new Date().getFullYear());\r\n");
      out.write("            </script>\r\n");
      out.write("            Desenvolvido\r\n");
      out.write("            <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> por\r\n");
      out.write("            <a href=\"#\" target=\"_blank\">Nicholas e Felipe</a>\r\n");
      out.write("            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\r\n");
      out.write("          </p>\r\n");
      out.write("          <div class=\"col-lg-4 col-md-12 footer-social\">\r\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\r\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\r\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-dribbble\"></i></a>\r\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-behance\"></i></a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>\r\n");
      out.write("    <!-- ================ End footer Area ================= -->\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("      $(document).ready(function() {\r\n");
      out.write("        $(\"#mytable #checkall\").click(function() {\r\n");
      out.write("          if ($(\"#mytable #checkall\").is(\":checked\")) {\r\n");
      out.write("            $(\"#mytable input[type=checkbox]\").each(function() {\r\n");
      out.write("              $(this).prop(\"checked\", true);\r\n");
      out.write("            });\r\n");
      out.write("          } else {\r\n");
      out.write("            $(\"#mytable input[type=checkbox]\").each(function() {\r\n");
      out.write("              $(this).prop(\"checked\", false);\r\n");
      out.write("            });\r\n");
      out.write("          }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        $(\"[data-toggle=tooltip]\").tooltip();\r\n");
      out.write("      });\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"../../../js/vendor/jquery-2.2.4.min.js\"></script>\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js\"\r\n");
      out.write("      integrity=\"sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    <script src=\"../../../js/vendor/bootstrap.min.js\"></script>\r\n");
      out.write("    <script\r\n");
      out.write("      type=\"text/javascript\"\r\n");
      out.write("      src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    <script src=\"../../../js/jquery.ajaxchimp.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/jquery.magnific-popup.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/parallax.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/owl.carousel.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/jquery.sticky.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/hexagons.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/jquery.counterup.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/waypoints.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/jquery.nice-select.min.js\"></script>\r\n");
      out.write("    <script src=\"../../../js/main.js\"></script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
