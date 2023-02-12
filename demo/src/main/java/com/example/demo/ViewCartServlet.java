package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>View Cart</title></head><body>");
        out.println("<h1>View Cart</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Quantity</th>");
        out.println("<th>Price</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        for (Product product : cart) {
            out.println("<tr>");
            out.println("<td>" + product.getId() + "</td>");
            out.println("<td>" + product.getName() + "</td>");
            out.println("<td>" + product.getQuantity() + "</td>");
            out.println("<td>" + product.getPrice() + "</td>");
            out.println("<td>");
            out.println("<a href='RemoveFromCartServlet?id=" + product.getId() + "'>Remove</a>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br>");
        out.println("<a href='CheckoutServlet'>Checkout</a>");
        out.println("<br>");
        out.println("<a href='ProductListServlet'>Back to Product List</a>");
        out.println("<br>");
        out.println("<a href='LogoutServlet'>Logout</a>");
        out.println("</body></html>");
    }
}
