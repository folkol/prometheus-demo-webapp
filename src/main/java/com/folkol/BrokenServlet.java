package com.folkol;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrokenServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(BrokenServlet.class.getName());
    private static final double BROKENNESS = 0.1;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        if (Math.random() < BROKENNESS) {
            throw new RuntimeException("Oh noes :(");
        }
        if (Math.random() < BROKENNESS) {
            LOGGER.log(Level.SEVERE, "Exceptional!", new Exception("Exceptional!"));
        }
        if (Math.random() < BROKENNESS) {
            LOGGER.severe("Oh crap!");
        }
        response.getWriter().println("Hello, world!");
    }
}
