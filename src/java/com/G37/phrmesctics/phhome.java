/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.phrmesctics;

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
public class phhome extends HttpServlet {
   
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
              response.sendRedirect("phlogin.jsp");
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
              out.println("function aaa(id)");
            out.println("{");
            out.println("var a=confirm(\"Are u sure u want to delete It\")");
            out.println("if(a)");
            out.println("{");
            out.println("document.thisform.id.value=id;"
                    + "document.thisform.opn.value='Delete';"
                    + "document.thisform.action=\"ProductForm\";"
                    + "document.thisform.submit();");
            out.println("}");
            out.println("}");
                     out.println("</script>");
            out.println("<title>phome</title>");
             out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
           RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
          rd.include(request, response);
            pbean bean=new pbean();
            pdaos dao=new pdaos();
           bean=dao.authenticate(users, pass);

        out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bean.getName()+"</a></li>");
        out.println("<table align=right><tr><td><li ><a href=\"phlogout\">Logout</a></li></td></tr></table>");
         out.println("</ul></div>");


          RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
          r.include(request, response);
     

             out.println("<form name=\"myform\" method=\"post\" action=\"ProductForm?opn=Add\" onSubmit=\"return validate(this);\">");
            out.println("<table border=\"5\" align=\"center\" width=\"40%\" height=\"30%\">"
                    + "<h1 align=\"center\">Stock Details</h1><br>"
                    + "<tr><th>Medicine Name:</th><td><input type=\"text\" name=\"name\"></td></tr>");

                     out.println("<tr><th>Price:</th><td><input type=\"text\" name=\"price\"></td></tr></td></tr>"
                             + "<tr><th>Stock in Hand</th><td><input type=\"text\" name=\"stock\">"
                             + "</td></tr>"
                             + "<tr><th>Danger Level:</th><td><input type=\"text\" name=\"danger\"></td></tr></td></tr>"
                              + "<tr><td colspan=\"2\"><input type=\"submit\" name=\"sub\" value=\"Add\"><input type=\"reset\" name=\"rst\" value=\"Cancel\"></td></tr></table></form>");
out.println("<form name=\"thisform\">");
            out.println("<input name=\"id\"  type=\"hidden\">");
           out.println("<input name=\"opn\" type=\"hidden\">");

                     out.println("<table align=\"center\" border=\"5\">");
                    out.println("<tr bgcolor=\"brown\"><th>Medicine Name</th><th>Price</th><th>Stock in Hand</th><th>DangerLevel</th><th>Edit</th><th>Delete</th></tr>");
                     Productdaos daos=new Productdaos();
                    ArrayList<Product> ale=daos.findAll();
                    for(Product c:ale){
                    out.println("<tr><td>"+c.getPname()+"</td>"

                            + "<td bgcolor=\"green\">"+c.getP_price()+"</td>"
                            + "<td bgcolor=\"purple\">"+c.getStockinhand()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getDangerlevel()+"</td>"
                           
                            + "<td bgcolor=\"green\"><a href=\"edit?id="+c.getPid()+"\">Edit</a></td>"
                            + "<td bgcolor=\"purple\"><a onclick=\"aaa("+c.getPid()+")\">Delete</a></td></tr>");
                }
                     out.println("</table></table>");

 

           
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
