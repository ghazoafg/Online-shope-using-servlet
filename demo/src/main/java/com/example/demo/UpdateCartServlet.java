package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<Product>();
            session.setAttribute("cart", cart);
        }

        int product_id = Integer.parseInt(request.getParameter("id"));
        int new_quantity = Integer.parseInt(request.getParameter("quantity"));

        Product updated_product = cart.get(product_id);

        if (new_quantity <= 0) {
            cart.remove(product_id);
        } else {
            updated_product.setQuantity(new_quantity);
            cart.add(product_id, updated_product);
        }

        response.sendRedirect("Cart.jsp");
    }
}
