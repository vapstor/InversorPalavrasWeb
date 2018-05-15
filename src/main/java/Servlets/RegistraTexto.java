/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.appController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author vapstor
 */

@WebServlet(name="servletTexto", urlPatterns = "/RegistraTexto")
public class RegistraTexto extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private RequestDispatcher requestDispatcher;
    
//    @EJB
//    private <ArrayList>Palavra listaPalavras;
    
    public RegistraTexto() {
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String texto = request.getParameter("inputTexto");
        String textoInvertido = inverteTexto(texto);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        
        request.setAttribute("texto", texto);
        request.setAttribute("textoInvertido", textoInvertido);
        
        if(!texto.equals("")) {
            try {
                appController.salvaTextoBD(texto, textoInvertido);
            } 
            catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RegistraTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.setContentType("text/html");  
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        } else {
            String erro = "A String não pode ser nula!";
            request.setAttribute("erro", erro);
            response.setContentType("text/html");  
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }

        out.close();   
    }
    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }

    private String inverteTexto(String palavra) {
        return appController.inverteString(palavra).getTexto();
    }

}
