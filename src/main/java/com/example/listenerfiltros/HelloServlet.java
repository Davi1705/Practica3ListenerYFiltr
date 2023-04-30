package com.example.listenerfiltros;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msgReq = (String) req.getAttribute("msg");
        String msgApp = (String) req.getServletContext().getAttribute("msg");
        System.out.println(msgReq);
        System.out.println(msgApp);
    }
}