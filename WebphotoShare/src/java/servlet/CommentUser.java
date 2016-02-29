/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import bean.entity.TblComment;
import bean.entity.TblImage;
import bean.entity.TblUser;
import bean.session.TblCommentFacadeRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CommentUser extends HttpServlet {
   
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
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        HttpSession session=request.getSession();
        String user=session.getAttribute("username").toString();
        TblComment comment=new TblComment();
        comment.setImageID(new TblImage(new Integer(session.getAttribute("imageid").toString())));
        comment.setCommentTitle(title);
        comment.setCommentContent(content);
        comment.setCommentTimeCreate( new Date());
        comment.setUserID(new TblUser(user));
        InitialContext ict=new InitialContext();
        TblCommentFacadeRemote cremote=(TblCommentFacadeRemote)ict.lookup("java:global/WebphotoShare/TblCommentFacade");
        cremote.create(comment);
        RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("/detailsImage.jsp?iid="+(session.getAttribute("imageid").toString()));
        dispatcher.forward(request, response);
        }
        catch(Exception e)
        {
        System.out.println("Error when crete comment");
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
