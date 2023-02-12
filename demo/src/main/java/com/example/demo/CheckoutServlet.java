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

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
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
        if (cart.isEmpty()) {
            response.sendRedirect("ProductListServlet");
            return;
        }

        session.removeAttribute("cart");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Checkout</title></head><body>");
        out.println("<h1>Checkout</h1>");
        out.println("<p>Your payment has been processed successfully.</p>");
        out.println("<p>Your cart is now empty.</p>");
        out.println("<p><a href='ProductListServlet'>Back to product list</a></p>");
        out.println("</body></html>");
    }
}

