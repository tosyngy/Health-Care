/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.patient;

import com.G37.labadmin.record;
import com.G37.labadmin.recorddaos;
import com.G37.pappointment.Pappointment;
import com.G37.pappointment.Pappointmentdao;
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
public class Lrecord extends HttpServlet {
   
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
        try {  HttpSession session=request.getSession();
            String users=(String) session.getAttribute("username");
            String pass=(String) session.getAttribute("password");
             Integer id=(Integer)session.getAttribute("id");
            if( (users==null) && (pass==null)){
                response.sendRedirect("plogin.jsp");
            }
            
            out.println("<html>");
            out.println("<head>");

            out.println("<title>Servlet Lrecord</title>");
            out.println("<link rel=\"stylesheet\" href=\"Design/default.css\" type=\"text/css\" />");
            out.println("</head>");
            out.println("<body>");
                 RequestDispatcher rd=request.getRequestDispatcher("/Design/header.jsp");
            rd.include(request, response);
             patientbean bean=new patientbean();
            patientdao dao=new patientdao();
             bean=dao.authenticate(users, pass);

          out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bean.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"plogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");


              RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
          r.include(request, response);

             Pappointment p=new Pappointment();
       Pappointmentdao d=new Pappointmentdao();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet history</title>");
            out.println("</head>");
            out.println("<body>");
              out.println("<center><font  color=orange size=12><b><i>Lab Record</i></b></font></center>");
                 out.println("<form name=\"thisform\">");

        //   out.println("<input name=\"opn\" type=\"hidden\"> value=\"Add\">");
out.println("<input name=\"id\"  type=\"hidden\">");
           out.println("<input name=\"opn\" type=\"hidden\">");
                     out.println("<table align=\"center\" border=\"5\">");
                    out.println("<tr bgcolor=\"brown\"><th>Name</th><th>Age</th><th>Sex</th><th>Test</th> <th>Report</th><th>Date</th><th>Remark</th><th>Record</th></tr>");
                     recorddaos daos=new recorddaos();
                    ArrayList<record> ale=daos.findAllRecordpwise(id);
                    for(record c:ale){
                    out.println("<tr><td>"+c.getName()+"</td>"

                            + "<td bgcolor=\"green\">"+c.getAge()+"</td>"
                            + "<td bgcolor=\"purple\">"+c.getSex()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getTest()+"</td>"
                            + "<td bgcolor=\"blue\"><a href=\"image?id="+c.getId()+"\">"+c.getReport()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getDate()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getRemark()+"</td>");

                       out.println("<td bgcolor=\"green\"><a href=\"view?id="+c.getId()+"\">ViewReport</a></td>");
                  //      + "<td bgcolor=\"purple\"><a onclick=\"abc("+c.getId()+")\">Delete</a></td></tr>");
                }
                     out.println("</table></form>");
                    RequestDispatcher rps=request.getRequestDispatcher("/Design/footer.jsp");
          rps.include(request, response);
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
