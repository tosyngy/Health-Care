/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.doctor;

import com.G37.phrmesctics.Product;
import com.G37.phrmesctics.Productdaos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class stock extends HttpServlet {
   
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
        try {
             HttpSession session=request.getSession();
            String users=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
            if( (users==null) && (pass==null)){
                response.sendRedirect("login.jsp");
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>dhome</title>");
             out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
            rd.include(request, response);
             doctorbean bean1=new doctorbean();
            doctordaos dao=new doctordaos();
             bean1=dao.authenticate(users, pass);


            out.println("<div id=\"menu\"><ul><li><a>Welcome\t Dr. "+bean1.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"dlogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");
          //  RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
          //r.include(request, response);
          RequestDispatcher rps=request.getRequestDispatcher("/Design/page.jsp");
          rps.include(request, response);
           out.println("<form name=\"thisform\">");
            //out.println("<input name=\"id\"  type=\"hidden\">");
           //out.println("<input name=\"opn\" type=\"hidden\">");
 out.println("<center><font  color=orange size=12><b><i>Stock Details</i></b></font></center>");
                     out.println("<table align=\"center\" border=\"5\">");
                    out.println("<tr bgcolor=\"brown\"><th>Medicine Name</th><th>Price</th><th>Stock in Hand</th><th>DangerLevel</th></tr>");
                     Productdaos daos=new Productdaos();
                    ArrayList<Product> ale=daos.findAll();
                    for(Product c:ale){
                    out.println("<tr><td>"+c.getPname()+"</td>"

                            + "<td bgcolor=\"green\">"+c.getP_price()+"Rs only</td>"
                            + "<td bgcolor=\"purple\">"+c.getStockinhand()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getDangerlevel()+"</td>");

                           
                }
                     out.println("</table></form>");
                      out.println("</body>");
              RequestDispatcher ra=request.getRequestDispatcher("/Design/footer.jsp");
          ra.include(request, response);
            out.println("</html>");

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
