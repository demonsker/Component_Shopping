/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USER
 */
public class AddtoShoppingCartServlet extends HttpServlet {

    private static String PRODUCT_NAME = "prodName"; // User input
    private static String PRODUCT_QTY = "prodQty"; // User input
    private static String DVD = "dvd";
    private static String CART = "cart";
    private static String ShowShoppingCart_JSP = "ShowShoppingCart.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String prod_Name = request.getParameter(PRODUCT_NAME);
            String prod_QtyStr = request.getParameter(PRODUCT_QTY);
            Integer prod_Qty = Integer.parseInt(prod_QtyStr == "" ? "0" : prod_QtyStr);
            
            Integer stock_Qoh, cart_Qoh, newStock_Qoh;
            // DVD dvdObj = new DVD();
            // CART cartObj = new CART();
            HttpSession session = request.getSession();
            Random rand = new Random();
            
            synchronized(getServletContext()) {
            
            stock_Qoh = 0;// DVD.getStockQoh
            cart_Qoh = 0; // ShoppingCart.getCartQoh
            newStock_Qoh = (stock_Qoh - prod_Qty) <= 0 ? 0: stock_Qoh - prod_Qty;
            
            //dvdObj.setStock_Qoh() 
            //getServletContext().setAttribute(DVD, dvdObj);
            
//            Thread.sleep((rand.nextInt(10)+1) * 500);
            
            // SHOW CART
            //getServletContext().setAttribute(CART, cartObj.getTotalQty);
//            request.getRequestDispatcher(ShowShoppingCart_JSP).forward(request, response);
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckOutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutServlet at " + prod_Name + prod_Qty + "    =>stock " + newStock_Qoh+ "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception e) {}
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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