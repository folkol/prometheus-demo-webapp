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
        LOGGER.info("Minor event, no throwable");
        if (Math.random() < BROKENNESS) {
            LOGGER.severe("Major event, no throwable");
        }
        if (Math.random() < BROKENNESS) {
            LOGGER.log(Level.WARNING, "Mumble", new IllegalArgumentException("No!"));
        }
        if (Math.random() < BROKENNESS) {
            LOGGER.log(Level.SEVERE, "Deep shit! :(",
                new RuntimeException("Exceptional!",
                    new Exception("Oh noes!",
                        new IOException("Out of disk space"))));
        }
        response.getWriter().println("Hello, world!");
    }
}
