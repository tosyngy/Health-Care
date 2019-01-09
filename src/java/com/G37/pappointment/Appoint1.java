/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.pappointment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vikas
 */
public class Appoint1 extends HttpServlet {
   
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
        String name=request.getParameter("name");
        String age=request.getParameter("age");
       // String sex=request.getParameter("sex");
        String address=request.getParameter("address");
        String mobile= request.getParameter("mobile");
       String email=request.getParameter("email");
       String doctor=request.getParameter("doctor");
       String date=request.getParameter("date");
       String did=request.getParameter("did");
       String symtoms=request.getParameter("symtoms");
       String image=request.getParameter("uploadfile");
       String sex=new String();
            Enumeration e=request.getParameterNames();
            while(e.hasMoreElements()){
                String pname=(String)e.nextElement();
                String pvalues[]=request.getParameterValues(pname);
                if (pname.equals("sex")) {
                    sex = pvalues[0];
                }}
          Pappointment bean= new Pappointment();
           Pappointmentdao dao=new Pappointmentdao();
            
 if(name!=null && age!=null && sex!=null && address!=null && email!=null   && mobile!=null && doctor!=null && date!=null && symtoms!=null && image!=null )
           {
     
               bean.setName(name);
               bean.setAge(age);
               bean.setSex(sex);
               bean.setAddress(address);
               bean.setMobile(mobile);
               bean.setEmail(email);
               bean.setDoctor(doctor);
               bean.setDate(date);
               bean.setSymtoms(symtoms);
               bean.setDid(Integer.parseInt(did));
               bean.setImage(image);
}
  try {

          String opn=request.getParameter("opn");

        
          if(opn.equals("Add"))
          {
    
             dao.create(bean);
          }
         response.sendRedirect("phome?msg=vikas");

            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet regis</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet regis at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        }
         finally { 
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
