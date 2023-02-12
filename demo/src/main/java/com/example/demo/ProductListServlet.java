package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Product 1", 10.0,1));
        productList.add(new Product(2, "Product 2", 20.0,1));
        productList.add(new Product(3, "Product 3", 30.0,1));
        productList.add(new Product(4, "Product 4", 40.0,1));
        productList.add(new Product(5, "Product 5", 50.0,1));

        session.setAttribute("productList", productList);
        response.sendRedirect("productList.jsp");
    }
}
