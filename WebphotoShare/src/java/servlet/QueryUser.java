/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import bean.entity.TblQuery;
import bean.entity.TblUser;
import bean.session.TblQueryFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class QueryUser extends HttpServlet {
   
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
        try {
            String content=request.getParameter("content");
            String username=session.getAttribute("username").toString();
            InitialContext ict=new InitialContext();
            TblQueryFacadeRemote qremote=(TblQueryFacadeRemote)ict.lookup("java:global/WebphotoShare/TblQueryFacade");
            TblQuery query=new TblQuery();
            query.setUserID(new TblUser(username));
            query.setDateCreate(new Date());
            query.setQueryContent(content);
            qremote.create(query);
            request.setAttribute("status", "Send Question Success!");
            RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher("/FQAs.jsp");
            dispatcher.forward(request, response);
        }
        catch(NamingException e)
        {
            System.out.println("Error when lookup in query servlet");
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
