package com.example;

import java.io.IOException;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class BillCalculatorServlet extends HttpServlet {

    @EJB
    private BillCalculatorBean calculatorBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the calculator.jsp page
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String unitsStr = request.getParameter("units");
        int units = Integer.parseInt(unitsStr);
        
        double billAmount = calculatorBean.calculateBill(units);
        
        request.setAttribute("units", units);
        request.setAttribute("billAmount", billAmount);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}