package br.uff.filters;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class LoginFilter implements Filter {    
    
    private ServletContext context;
    
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String nomeParametro = params.nextElement();
            String valorParametro = request.getParameter(nomeParametro);
            String homePage = "";

            if("permissao".equals(nomeParametro)) { 
                switch(valorParametro){
                        case "alunos":
                            homePage = "/LeroLero/ControllerAluno";
                            break;
                        case "instrutores":
                            homePage = "/LeroLero/ControllerInstrutores";
                            break;
                        case "administrador":
                            homePage = "/LeroLero/ControllerAdmin";
                            break;
                    }
                    res.sendRedirect(homePage);
                } else {
                    chain.doFilter(request, response);
                }
            }
        }

    @Override
	public void destroy() {}

}
