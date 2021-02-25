package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        getPage(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getPage(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        String born = "";
        String petName = "";

        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";

        switch(lang){
            case "en":
                msg = "Hello! Welcome, ";
                born = "You were born between ";
                petName = "Your pet's name is ";
                break;
            case "fr":
                msg = "Bonjour! Bienvenue, ";
                born = "Tu es né entre ";
                petName = "Le nom de votre animal est ";
                break;
            case "de":
                msg = "Hallo! Herzlich willkommen, ";
                born = "Du wurdest zwischen geboren ";
                petName = "Der Name Ihres Haustieres ist ";
                break;
            default:
                msg = "Olá! Boas vindas, ";
                born = "Você nasceu entre ";
                petName = "O nome do seu pet é ";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome == null || nome.length() == 0)
            nome = "Fulano";
        
        String sobrenome = request.getParameter("sobrenome");

        if (sobrenome == null)
            sobrenome = "de Tal";

        msg = msg + nome + " " + sobrenome + "!";

        String idadeString = request.getParameter("idade");

        String periodoNascimento = "";

        if (idadeString != null && isParseIntPossible(idadeString)){
            int idade = Integer.parseInt(idadeString);
            periodoNascimento = born + (2021 - idade) + " & " + (2020 - idade) + "." ;
        }

        String pet = request.getParameter("pet");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            if (periodoNascimento != "")
                out.println("<p>" + periodoNascimento + "</p>");
            if (pet != null && pet != "")
                out.println("<p>" + petName + pet + "." + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private boolean isParseIntPossible(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
