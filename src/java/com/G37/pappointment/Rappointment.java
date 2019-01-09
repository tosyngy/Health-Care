/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.pappointment;

import com.G37.doctor.doctorbean;
import com.G37.doctor.doctordaos;
import com.G37.patient.patientbean;
import com.G37.patient.patientdao;
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
public class Rappointment extends HttpServlet {
   
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
                response.sendRedirect("plogin.jsp");
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Rappointment</title>");
         out.println("<link href=\"css/structure1.css\" rel=\"stylesheet\">");
         out.println("<link href=\"css/form.css\" rel=\"stylesheet\">");
         out.println("<link href=\"Design/default.css\" rel=\"stylesheet\" type=\"text/css\" />");
         //<!-- JavaScript -->
         out.println("<script src=\"scripts/wufoo.js\"></script>");
         out.println("<script src=\"http://html5shiv.googlecode.com/svn/trunk/html5.js\"></script>");
         out.println("");
         out.println("");
         out.println("");
            
out.println("<link rel=\"stylesheet\" href=\"images/calender.css\" type=\"text/css\" />");
            out.println("<link rel=\"stylesheet\" href=\"images/epoch_styles.css\" type=\"text/css\" />");
            out.println("<script language=\"JavaScript\">");
            RequestDispatcher dispatcher1 = request.getRequestDispatcher("/WEB-INF/validate.js");
            dispatcher1.include(request, response);
            out.println("</script>");
            out.println("<script language=\"JavaScript\">");
            out.println("var dp_cal1");
            out.println("var dp_cal2");
            out.println("window.onload = function () {");
            out.println(" dp_cal1  = new Epoch('epoch_popup','popup',document.getElementById('popup_container1'));");
            out.println(" dp_cal2  = new Epoch('epoch_popup','popup',document.getElementById('popup_container2'));};");
            RequestDispatcher dispatcher3 = request.getRequestDispatcher("/WEB-INF/validate.js");
            dispatcher3.include(request, response);
            dispatcher3 = request.getRequestDispatcher("/images/epoch_classes.js");
            dispatcher3.include(request, response);
            out.println("</script>");


            out.println("</head>");
            out.println("<body id=\"public\">");
            RequestDispatcher rd=request.getRequestDispatcher("Design/header.jsp");
            rd.include(request, response);
          
             patientbean bean=new patientbean();
            patientdao daose=new patientdao();
             bean=daose.authenticate(users, pass);

          out.println("<div id=\"menu\"><ul><li><a>Welcome\t"+bean.getName()+"</a></li>");
          out.println("<table align=right><tr><td><li ><a href=\"plogout\">Logout</a></li></td></tr></table>");
          out.println("</ul></div>");
             
             RequestDispatcher rs=request.getRequestDispatcher("Design/page.jsp");
            rs.include(request, response);
           
           out.println("<div id=\"container\" class=\"ltr\">");

  out.println("<center><font  color=orange size=12><b><i>Appointment Request</i></b></font></center>");
           
           
             
           out.println("<form id=\"form16\" name=\"form16\" action=\"Appoint1?opn=Add\"  method=\"post\" class=\"wufoo  page\"  autocomplete=\"off\">");
           out.println("<ul>");

           out.println("<li id=\"foli0\" class=\"name notranslate \">");
           out.println("<label class=\"desc\" id=\"title0\" for=\"Field0\">Name</label>");
           out.println("<span><input id=\"Field0\" name=\"name\" type=\"text\" class=\"field text\" placeholder=\"Username\" size=\"30\" tabindex=\"10\" /></span></li>");

           out.println("<label class=\"desc\" id=\"title0\" for=\"Field0\">image</label>");
           out.println("<span><input id=\"Field0\" name=\"uploadfile\" type=\"file\" class=\"field text\" placeholder=\"Username\" size=\"30\" tabindex=\"10\" /></span></li>");


           out.println("<label class=\"desc\" id=\"title0\" for=\"Field0\"></label>");
           out.println("<span><input id=\"Field0\" name=\"todo\" type=\"hidden\" value=\"upload\" class=\"field text\" placeholder=\"Username\" size=\"30\" tabindex=\"10\" /></span></li>");


           out.println(" <li id=\"foli0\" class=\"name notranslate \">");
           out.println("<label class=\"desc\" id=\"title0\" for=\"Field0\">Age</label>");
           out.println("<span> <input id=\"Field0\" name=\"age\" type=\"text\" class=\"field text\" placeholder=\"Age\" size=\"30\" maxlength=\"3\" tabindex=\"10\" />");
           


           out.println("<li id=\"foli0\" class=\"name notranslate \">");
           out.println("<fieldset><label class=\"desc\" id=\"title0\" for=\"Field0\"><legend>Sex</legend></label>");
              out.println("<span><input id=\"Field0\" name=\"sex\" type=\"Radio\" value=\"male\" class=\"field text\" placeholder=\"Name\" size=\"30\" tabindex=\"10\" />male"
                      + "&nbsp;"
                      + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id=\"Field0\" name=\"sex\" type=\"Radio\" value=\"female\"class=\"field text\" placeholder=\"Name\" size=\"30\" tabindex=\"10\" />Female");
           out.println("<label for=\"Field0\"></label></span></fieldset></li>");


           out.println("<li id=\"foli4\" class=\"complex notranslate \">");
           out.println("<label class=\"desc\" id=\"title4\" for=\"Field4\">Address</label>");
           out.println("<div><span class=\"full addr1\"><input id=\"Field4\" name=\"address\" type=\"text\" class=\"field text addr\" value=\"\" placeholder=\"Address\" tabindex=\"6\" />");
           out.println("<label for=\"Field6\"></label></span></div></li>");


           out.println("<li id=\"foli36\" class=\"phone notranslate \">");
           out.println("<label class=\"desc\" id=\"title36\" for=\"Field36\">mobile</label>");
           out.println("<span><input id=\"Field36\" name=\"mobile\" type=\"tel\" class=\"field text\" placeholder=\"Don't Include 0\" size=\"30\" maxlength=\"11\" tabindex=\"17\" />");
           out.println("<label for=\"Field36\"></label></span></li>");

           out.println("<li id=\"foli12\" class=\"notranslate \">");
           out.println("<label class=\"desc\" id=\"title12\" for=\"Field12\">Email Address</label>");
           out.println("<div><input id=\"Field12\" name=\"email\" type=\"email\" spellcheck=\"false\" class=\"field text medium\" value=\"\" placeholder=\"E-mail\" maxlength=\"255\" tabindex=\"13\" />");
           out.println("</div>");

           out.println("<li id=\"foli12\" class=\"notranslate \">");
           out.println("<label class=\"desc\" id=\"title36\" for=\"Field36\">Dcotors</label>");
           out.println("<span\">");
         doctorbean bean1=new doctorbean();
           doctordaos dao=new doctordaos();

           out.println("<select id=\"Field9\" name=\"did\" class=\"field select addr\" tabindex=\"11\" >");
            ArrayList<doctorbean> al=dao.findAll();
                        for(doctorbean b:al){
                          
            out.println("<option value="+b.getId()+">Dr."+b.getName()+"("+b.getSpecilization()+"  Specialist)</option>");
            
            }
                            for(doctorbean b:al){
                           out.println("<input type=\"hidden\" name=\"doctor\" value="+b.getId()+">");
                            }
 out.println("</select>");
           
           out.println("</span>");


           out.println("<tr><input type=\"hidden\" name=\"did\" value="+bean1.getId()+"></tr>");

           out.println("<li id=\"foli22\"  class=\"notranslate\">"
                   + "<label class=\"desc\" id=\"title22\" for=\"Field22\">");
           out.println("Appointment date");
           out.println("</label>");
           out.println("<span>");
           out.println("<input  name=\"date\" type=\"text\" id=\"popup_container1\" class=\"field text\" value=\"\" size=\"10\" maxlength=\"10\" tabindex=\"20\" />");
           out.println("<label for=\"Field21-1\">DD/MM/yyyy</label>");
           out.println("</span> ");


           out.println("<li id=\"foli22\"  class=\"notranslate\">"
                   + "<label class=\"desc\" id=\"title22\" for=\"Field22\">");
           out.println("Symtoms");
           out.println("</label>");


           out.println("<textarea id=\"Field22\" ");
           out.println("name=\"symtoms\" ");
           out.println("class=\"field textarea medium\" ");
           out.println("spellcheck=\"true\" ");
           out.println("rows=\"10\" cols=\"50\" ");
           out.println("tabindex=\"23\" ");
           out.println("onkeyup=\"\"");
           out.println("></textarea></div>");



           out.println("</li></div>");
           out.println("<li class=\"buttons\"><div>");
           out.println("<input id=\"saveForm\" name=\"saveForm\" class=\"btTxt submit\" type=\"submit\" value=\"Submit\"/></div>");
           out.println("</li>");
           out.println("</ul>");

           out.println("</form>");
           out.println("</div><!--container-->");

            out.println("</body>"); RequestDispatcher ra=request.getRequestDispatcher("/Design/footer.jsp");
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
