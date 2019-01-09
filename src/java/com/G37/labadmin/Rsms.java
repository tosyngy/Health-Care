/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

import com.G37.doctor.MainMailAndSms;
import com.G37.doctor.sendsms;
import com.G37.patient.patientbean;
import com.G37.patient.patientdao;
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
public class Rsms extends HttpServlet {
   
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
              response.sendRedirect("alogin.jsp");
           }
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Rsms</title>");  
            out.println("</head>");
            out.println("<body>");
             out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
           RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
          rd.include(request, response);
            labbean bean1=new labbean();
            labdios d=new labdios();
             bean1=d.authenticate(users, pass);

//out.println(bean1.getId());
          out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bean1.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"llogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");
RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
            r.include(request, response);
         
            String id=request.getParameter("id");
            int id1=Integer.parseInt(id);
            
            out.println("<html>");
            out.println("<head>");
record b=new record();
recorddaos dd=new recorddaos();
b=dd.find(id1);
            out.println("<title>Servlet Accept1</title>");
               out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet Accept1 at " +b.getEmail()+b.getMobile()+"</h1>");
            
                  String mobile=b.getMobile();
                String    message="your Lab test result for "+b.getTest()+" is  updated on your portal account plz visit your account to check your report From !Healthcare web portal!@Thankyou@";
                      int pid=b.getPid();
                      
               patientbean  bn=new patientbean();
               patientdao ddd=new patientdao();
               bn=ddd.find(pid);

               MainMailAndSms mail=new   MainMailAndSms();
 String email= bn.getEmail();
//out.println("mail="+email);

               mail.sendMail(email, "Lab result",message);
                sendsms sms=new sendsms();
                sms.sendSms(mobile, message);

           response.sendRedirect("rhome?msg=vikas");
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
