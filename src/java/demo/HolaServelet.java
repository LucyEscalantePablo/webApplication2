/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package demo;


import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


/**
 *
 * @author LUCY
 */
@WebServlet(name = "HolaServelet", urlPatterns = {"/HolaServelet"})
public class HolaServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/saludo_bd";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "lucy";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        
        
        String nombre = request.getParameter("nombre");
        // agregado codigo
        String codigo = request.getParameter("codigo");
        
        // agregado carrera
        String carrera = request.getParameter("carrera");

        
        if (nombre == null || nombre.isEmpty()){
            nombre = "Visitante";
        }
        
        
        // agregado codigo
        if (codigo == null){
            codigo = "";
        } 
        // agregado carrera
        if (carrera == null){
            carrera = "";
        }
        
        
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            /* TODO output your page here. You may use following sample code. */
                String sql = "INSERT INTO nombres (nombre, codigo, carrera) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, nombre);
                    // agregado
                    stmt.setString(2, codigo);
                    stmt.setString(3, carrera);

                     
                    stmt.executeUpdate();
                    System.out.println("Nombre: "+nombre + ", Codigo: "+codigo + ", Carrera: "+carrera);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
       
        }
        
        
        // Enviar el parametro al JSP
        request.setAttribute("nombreUsuario", nombre);
        
        // agregado
        request.setAttribute("codigoUsuario", codigo);
        request.setAttribute("carreraUsuario", carrera);

        

        // redirigir al JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("saludo.jsp");
        dispatcher.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
        
        
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

}
