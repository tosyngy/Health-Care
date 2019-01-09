/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

import com.G37.doctor.doctorbean;
import com.G37.doctor.doctordaos;
import com.G37.patient.patientbean;
import com.G37.patient.patientdao;
import com.G37.utilities.ConnectionPool;
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
public class rhome extends HttpServlet {
   
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
           HttpSession httpSession = request.getSession();

           


        try {
 String users=(String) session.getAttribute("username");
           String pass=(String) session.getAttribute("password");
            if( (users==null) && (pass==null)){
              response.sendRedirect("alogin.jsp");
           }

            out.println("<html>");
            out.println("<head>");
           out.println("<script>");
              out.println("function abc(id)");
            out.println("{");
            out.println("var a=confirm(\"Are u sure u want to delete It\")");
            out.println("if(a)");
            out.println("{");
            out.println("document.thisform.id.value=id;"
                    + "document.thisform.opn.value='Delete';"
                    + "document.thisform.action=\"delete\";"
                    + "document.thisform.submit();");
            out.println("}");
            out.println("}");
                     out.println("</script>");

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

            out.println("<title>phome</title>");
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

            record bean=new record();
            recorddaos dao=new recorddaos();
           //bean=dao.authenticate(users, pass);

       

          RequestDispatcher r=request.getRequestDispatcher("/Design/page.jsp");
          r.include(request, response);
String m=request.getParameter("msg");
if(m!=null)
{
    out.println("   <center>  <i> <font size=\"5\" color=\"blue\"><b> !!! Message has been send SuccessFully   !!!</b></font></i></center>");
}

String m1=request.getParameter("msg1");
if(m1!=null)
{
    out.println("   <center>  <i> <font size=\"5\" color=\"blue\"><b> !!! Report Has been Uploaded Successfully   !!!</b></font></i></center>");
}

    out.println("<center><font  color=orange size=12><b><i>Lab Report</i></b></font></center>");
             out.println("<form name=\"myform\" method=\"post\" action=\"ReportForm?opn=Add\" enctype=\"multipart/form-data\" onSubmit=\"return validate(this);\">");
            out.println("<table border=\"5\" align=\"center\" width=\"40%\" height=\"30%\">");
                   
                  //  + "<tr><th>Name :</th><td><input type=\"text\" name=\"name\"></td></tr>");
                        //  patientbean b2=new patientbean();
           patientdao d2=new  patientdao();
out.println("<tr><th>Name</th><td>");
           out.println("<select id=\"Field9\" name=\"pid\" class=\"field select addr\" tabindex=\"20\" >");
            ArrayList<patientbean> ale=d2.findAll();
                        for(patientbean b2:ale){

            out.println("<option value="+b2.getId()+">"+b2.getName()+"</option>");

            }
                         for(patientbean b2:ale){
                           out.println("<input type=\"hidden\" name=\"name\" value="+b2.getId()+">");
                            }
 out.println("</select></td></tr>");


                     out.println("<tr><th>Age:</th><td><input type=\"text\" name=\"age\"></td></tr>"

                             + "<tr><th>Sex</th>");
              out.println("<td><input  name=\"sex\" type=\"Radio\" value=\"male\">male"
                      + "&nbsp;"
                      + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input  name=\"sex\" type=\"Radio\" value=\"female\" tabindex=\"10\" />Female");
           out.println("</td></tr>"
                             
                             + "<tr><th>Mobile  :</th><td><input type=\"text\" name=\"mobile\"></td></tr>");

                              doctorbean b1=new doctorbean();
           doctordaos daoa=new doctordaos();
out.println("<tr><th>Doctor</th><td>");
           out.println("<select id=\"Field9\" name=\"did\" class=\"field select addr\" tabindex=\"11\" >");
            ArrayList<doctorbean> al=daoa.findAll();
                        for(doctorbean b:al){

            out.println("<option value="+b.getId()+">Dr."+b.getName()+"("+b.getSpecilization()+")</option>");

            }
                            for(doctorbean b:al){
                           out.println("<input type=\"hidden\" name=\"doctor\" value="+b.getId()+">");
                            }
 out.println("</select></td></tr>");

                     out.println("<tr><th>Test :</th><td><input type=\"text\" name=\"test\"></td></tr>"
                             + "<tr><th>Report :</th><td><input type=\"file\" name=\"uploadfile\"/></td></tr>"
                             + " <input type=\"hidden\" name=\"todo\" value=\"upload\"/>"
                             + "<tr><th>Date :</th><td><input type=\"text\" name=\"date\" id=\"popup_container1\"></td></tr>"
                             + "<tr><th>Remark :</th><td><input type=\"text\" name=\"remark\"></td></tr>"
                              + "<tr><td colspan=\"2\"><input type=\"submit\" name=\"sub\" value=\"Add\"><input type=\"reset\" name=\"rst\" value=\"Cancel\"></td></tr>"
                              //+ "<input name=\"id\"  type=\"hidden\" value=\"3\">"
                              //+ "<input name=\"pid\"  type=\"hidden\"  value=\"2\" >"
                             + "<input name=\"aid\"  type=\"hidden\"  value="+bean1.getId()+">"
                             //+ "<input name=\"did\"  type=\"hidden\"  value=\"1\">"
                              + "</table></form>");


                     out.println("<form name=\"thisform\">");
           
        //   out.println("<input name=\"opn\" type=\"hidden\"> value=\"Add\">");
out.println("<input name=\"id\"  type=\"hidden\">");
           out.println("<input name=\"opn\" type=\"hidden\">");
                     out.println("<table align=\"center\" border=\"5\">");
                    out.println("<tr bgcolor=\"brown\"><th>Name</th><th>Age</th><th>Sex</th><th>Test</th> <th>Report</th><th>Date</th><th>Remark</th><th>Edit</th><th>Delete</th><th>sms for patient</th></tr>");
                     recorddaos daos=new recorddaos();
                    ArrayList<record> a=daos.findAllRecordadwise(bean1.getId());
                    for(record c:a){
                    out.println("<tr><td>"+c.getName()+"</td>"

                            + "<td bgcolor=\"green\">"+c.getAge()+"</td>"
                            + "<td bgcolor=\"purple\">"+c.getSex()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getTest()+"</td>"
                           + "<td bgcolor=\"blue\"><a href=\"image?id="+c.getId()+"\">"+c.getReport()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getDate()+"</td>"
                            + "<td bgcolor=\"blue\">"+c.getRemark()+"</td>");
                          
                       out.println("<td bgcolor=\"green\"><a href=\"view?id="+c.getId()+"\">ViewReport</a></td>"
                        + "<td bgcolor=\"purple\"><a onclick=\"abc("+c.getId()+")\">Delete</a></td>"
                        + "<td bgcolor=\"purple\"><a href=\"Rsms?id="+c.getId()+"\">Send Sms</a></td></tr>");
                }
                     out.println("</table></form>");

                      RequestDispatcher ra=request.getRequestDispatcher("/Design/footer.jsp");
          ra.include(request, response);
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
