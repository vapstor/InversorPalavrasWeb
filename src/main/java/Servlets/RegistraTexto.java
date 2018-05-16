/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.appController;
import Model.Texto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "servletTexto", urlPatterns = "/RegistraTexto")
public class RegistraTexto extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RequestDispatcher requestDispatcher;
    private List listaTextos;
//    @EJB
//    private <ArrayList>Palavra listaPalavras;
    public RegistraTexto() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //! Instancia (ou recebe) os parametros
        String texto = request.getParameter("inputTexto");
        String textoInvertido = inverteTexto(texto);
        
        //! Seta Conteúdo da Resposta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //! Seta palavras
        request.setAttribute("texto", texto);
        request.setAttribute("textoInvertido", textoInvertido);

        //! Confere se não é nulo a entrada
        if (!texto.equals("")) {
            try {
                //! Salva no BD
                appController.salvaTextoBD(texto, textoInvertido);

                //! Recupera Lista Texto
                this.listaTextos = appController.todosOsTextos();
                
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RegistraTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ArrayList<Texto> list = (ArrayList<Texto>) this.listaTextos;
            
            //! Seta na Request a lista de palavras
            request.setAttribute("list", list);

            //! Seta Conteúdo da Resposta
            response.setContentType("text/html");

            //! Seta container Sucesso
            String sucesso = "Texto Invertido com Sucesso!";
            request.setAttribute("sucesso", sucesso);

            //Define o que fazer na sequencia
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);

        } else {
            try {
                //! Recupera Lista Texto
                this.listaTextos = appController.todosOsTextos();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(RegistraTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //! Emite erro se for nulo
            String erro = "O texto não pode ser nulo!";
            request.setAttribute("erro", erro);

            ArrayList<Texto> list = (ArrayList<Texto>) this.listaTextos;
            
            //! Seta na Request a lista de palavras
            request.setAttribute("list", list);
            
            response.setContentType("text/html");
            requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
        }

        //! Fecha Printer
        out.close();
    }

    
    private String inverteTexto(String palavra) {
        return appController.inverteString(palavra);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/Bridge/index.jsp");
    }
    

}
