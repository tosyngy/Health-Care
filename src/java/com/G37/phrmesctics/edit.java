/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.phrmesctics;

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
public class edit extends HttpServlet {
   
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
        try {    HttpSession session=request.getSession();
            String users=(String) session.getAttribute("username");
           String pass=(String) session.getAttribute("password");
           if( (users==null) && (pass==null)){
              response.sendRedirect("phlogin.jsp");
            }
            String id=request.getParameter("id");
            int id1=Integer.parseInt(id);
            Productdaos d=new Productdaos();
            Product bean=new Product();
            bean=d.find(id1);
            out.println("<html><head><title>phome</title>");
             out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
           RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
          rd.include(request, response);
            pbean bn=new pbean();
            pdaos dao=new pdaos();
           bn=dao.authenticate(users, pass);

        out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bn.getName()+"</a></li>");
        out.println("<table align=right><tr><td><li ><a href=\"phlogout\">Logout</a></li></td></tr></table>");
         out.println("</ul></div>");


          RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
          r.include(request, response);


             out.println("<form name=\"myform\" method=\"post\" action=\"ProductForm?opn=update\" onSubmit=\"return validate(this);\">");
            out.println("<table border=\"5\" align=\"center\" width=\"40%\" height=\"30%\">"
                    + "<h1 align=\"center\">Stock Details</h1><br>"
                       + "<input type=\"hidden\" name=\"id\" value="+bean.getPid()+">"
                    + "<tr><th>Medicine Name:</th><td><input type=\"text\" name=\"name\" value="+bean.getPname()+"></td></tr>");
                 

                     out.println("<tr><th>Price:</th><td><input type=\"text\" name=\"price\" value="+bean.getP_price()+"></td></tr>"
                             + "<tr><th>Stock in Hand</th><td><input type=\"text\" name=\"stock\" value="+bean.getStockinhand()+"></td></tr>"
                             + "<tr><th>Danger Level:</th><td><input type=\"text\" name=\"danger\" value="+bean.getDangerlevel()+"></td></tr>"
                              + "<tr><td colspan=\"2\"><input type=\"submit\" name=\"sub\" value=\"Update\"></td></tr></table></form>");

 RequestDispatcher ra=request.getRequestDispatcher("/Design/footer.jsp");
          ra.include(request, response);
          out.println("</body></html>");
           // out.println("<input name=\"id\"  type=\"hidden\">");
         //  out.println("<input name=\"opn\" type=\"hidden\">");
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
