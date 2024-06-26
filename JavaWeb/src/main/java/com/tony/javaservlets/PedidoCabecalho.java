package com.tony.javaservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
public class PedidoCabecalho extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"pt\">");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<title>" + this.getServletName() + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + this.getServletName() + "</h2>");
        out.println("<table border=\"1\">");
        out.println("<tr><th>Header name</th><th>Header value</th></tr>");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String headerName = (String) headers.nextElement();
            out.println("<tr><td>" + headerName + "</td><td>" + request.getHeader(headerName) + "</td></tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}