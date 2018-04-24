package org.rb.booklib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BookDTO;
import service.IBooksBeanRemote;

/**
 *
 * @author raitis
 */
@WebServlet(name = "BooksServlet", urlPatterns = {"/lib","/addbook"})
public class BooksServlet extends HttpServlet {

    @EJB
    IBooksBeanRemote booksEjb;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String path = request.getServletPath();
        if(path.equals("/lib")){
            List<BookDTO> books = booksEjb.r_findAll();
            request.setAttribute("books", books);
            request.getRequestDispatcher("WEB-INF/view/books.jsp").forward(request, response);
            return;        
        }
        if(path.equals("/addbook")){
            BookDTO book = new BookDTO("", "", 0);
            request.setAttribute("book", book);
            request.getRequestDispatcher("WEB-INF/view/addbook.jsp").forward(request, response);
            return;        
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String path = request.getServletPath();
        if(path.equals("/lib")){
             //BookDTO book_a = (BookDTO) request.getAttribute("book");
                       
             BookDTO book = new BookDTO();
             book.setTitle(request.getParameter("title"));
              book.setAuthor(request.getParameter("author"));
               book.setPages(Integer.parseInt(request.getParameter("pages")));
             if(book!=null){
             booksEjb.r_create(book);
             }
             response.sendRedirect("lib");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
