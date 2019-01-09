/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.phrmesctics;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vikas
 */
public class ProductForm extends HttpServlet {
   
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
        String price=request.getParameter("price");
        String stock=request.getParameter("stock");
        String danger=request.getParameter("danger");
        
int id1=0;
        Product bean=new Product();
        Productdaos dao=new Productdaos();
         if( name!=null && price!=null && stock!=null && danger!=null)
        {
            bean.setPname(name);
            bean.setP_price(Float.parseFloat(price));
            bean.setStockinhand(Integer.parseInt(stock));
            bean.setDangerlevel(Integer.parseInt(danger));
        }
        try {
          String opn=request.getParameter("opn");
          //out.println(opn);
          if(opn.equals("Add"))
          {
              dao.create(bean);
          }
            else if(opn.equals("update"))
          {
                out.println(name);
              bean.setPid(Integer.parseInt(request.getParameter("id")));
              
             dao.edit(bean);
        }

            else if(opn.equals("Delete"))
          {
                out.println(name);
              id1=(Integer.parseInt(request.getParameter("id")));
              out.println(id1);
           dao.remove(id1);
        }

         response.sendRedirect("phhome");
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
