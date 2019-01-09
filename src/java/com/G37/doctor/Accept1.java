/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.doctor;

import com.G37.pappointment.Pappointment;
import com.G37.pappointment.Pappointmentdao;
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
public class Accept1 extends HttpServlet {
   
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

            RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
            rd.include(request, response);
             doctorbean bean1=new doctorbean();
            doctordaos dao=new doctordaos();
             bean1=dao.authenticate(users, pass);


            out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bean1.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"dlogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");

 RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
            r.include(request, response);
         
            String id=request.getParameter("id");
            int id1=Integer.parseInt(id);
            Pappointment b=new Pappointment();
            Pappointmentdao d=new Pappointmentdao();
      
           b=d.find(id1);
            out.println("<html>");
            out.println("<head>");

            out.println("<title>Servlet Accept1</title>");
               out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            MainMailAndSms mail=new   MainMailAndSms();

            //out.println("<h1>Servlet Accept1 at " +b.getEmail()+b.getMobile()+"</h1>");
            out.println("<form name=\"myform\" method=\"post\" action=\"sms?id="+id1+"\">"
                    + "<table align=\"center\"><tr><td><input type=\"hidden\" name=\"mobile\" value="+b.getMobile()+"></td></tr>"
                    + "<tr><th>message</th><td><textarea name=\"msg\" rows=\"5\" cols=\"18\">Date:"+b.getDate()+""
                    + " And Time:</textarea>"
                    + "<input type=\"hidden\" name=\"email\" value="+b.getEmail()+">");
          
             out.println("<tr><td><input type=\"submit\" value=\"Send\"/></td></tr></table>");
              RequestDispatcher rds=request.getRequestDispatcher("/Design/footer.jsp");
            rds.include(request, response);
            out.println("</body>");
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
