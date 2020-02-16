package br.uff.servlets;
 
import br.uff.model.Alunos;
import br.uff.model.Instrutores;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 


public class UploadFoto extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        int id = 0;
        String pasta = "";
        String page = "";
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("instrutorLogado") != null){
            id = ((Instrutores) session.getAttribute("instrutorLogado")).getId();
            pasta = "instrutores";
            page = "instrutor";
        } else if (session.getAttribute("alunoLogado") != null){
            id = ((Alunos) session.getAttribute("alunoLogado")).getId();
            pasta = "alunos";
            page = "aluno";
            }
        
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
 
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        if(new File(request.getServletContext().getRealPath("img")+ File.separator + pasta + File.separator + id + ".jpg").exists()){
                            File oldFile = new File(request.getServletContext().getRealPath("img")+ File.separator + pasta + File.separator + id + ".jpg");
                            oldFile.delete();
                        }
                        item.write(new File(request.getServletContext().getRealPath("img")+ File.separator + pasta + File.separator + id + ".jpg"));
                    }
                }
 
            } catch (Exception ex) {
                request.setAttribute("message", "Upload de arquivo falhou devido a "+ ex);
                request.getRequestDispatcher("/erro.jsp").forward(request, response);
            }
        }
        response.sendRedirect("http://localhost:8080/LeroLero/modules/" + page + "/info-pessoal.jsp");
    }
}