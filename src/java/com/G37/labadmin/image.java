/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

import com.G37.doctor.doctorbean;
import com.G37.doctor.doctordaos;
import com.G37.utilities.ConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vikas
 */
public class image extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession();
        String users=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
           //Integer id=(Integer)session.getAttribute("id");
        try {
            if( (users==null) && (pass==null)){
                response.sendRedirect("login.jsp");
            }
             out.println("<html><head>"); 
             out.println("<title>Image</title>");

          out.println("<script> function A()");
out.println("{window.print();}");

out.println("</script>");
 out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");

           out.println("</head><body>");
              RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
            rd.include(request, response);
            doctorbean bean1=new doctorbean();
            doctordaos dao=new doctordaos();
             bean1=dao.authenticate(users, pass);

 out.println("<div id=\"menu\"><ul><li><a></a></li>");
        
          out.println("<table align=right><tr><td><li ><a href=\"dlogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");
            
            record p = new record();
            recorddaos daos=new recorddaos();
                             ConnectionPool conn = ConnectionPool.getInstance();
                                String str = conn.getPath();
                                String id=request.getParameter("id");
                                    int id1=Integer.parseInt(id);
                             //   out.println("id="+id1);
                            p = daos.find(id1);
                       out.println("<table align=\"center\"><br><br><br>");
                                out.println("<tr><td><img src=\"photo/"+p.getReport()+"\" width=\"500px\" height=\"500px\"/></td><tr>");
                              out.println("<tr><td><a href=\"JavaScript:A();\"><input type=\"button\"  value=\"print this page\"></a></td></tr>");
       out.println("</table>");
                              RequestDispatcher r=request.getRequestDispatcher("/Design/footer.jsp");
          r.include(request, response);

                              out.println("</body></html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
