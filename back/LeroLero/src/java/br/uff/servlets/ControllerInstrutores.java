/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author FelipeVilaChadosSant
 */
public class ControllerInstrutores extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Instrutor </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Instrutor </h1>");
            out.println("<a href=\"http://localhost:8080/LeroLero/DadosInstrutores\"> Dados Pessoais </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/AtribuicaoNotas\"> Atribuição de notas </a> </br>");
            out.println("<a href=\"http://localhost:8080/LeroLero/Pagamento\"> Visualizar Pagamento </a> </br>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}