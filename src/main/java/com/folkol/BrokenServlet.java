package com.folkol;

import javax.servlet.ServletException;
import java.io.IOException;

public class BrokenServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        if(Math.random() < 0.5) {
            throw new RuntimeException("Oh noews :(");
        } else {
            throw new ServletException("Oh shit :((");
        }
    }
}
