package com.worldNavigator;

import java.io.*;
import java.net.*;

import javafx.application.Platform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "server", urlPatterns = "/server")
public class Server extends HttpServlet {
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    Menu menu;

    public Server(Menu menu) {
        this.menu = menu;
    }

    public Server() {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Step 1: set content type
        response.setContentType("text/html");

        String command = request.getParameter("command");

        // Step 3: generate the HTML content
        java.io.PrintWriter out = response.getWriter();

        out.println("<html><body>");

        out.println("command is: "
                + command);
        out.println("<form action=\"CommandsServer\" method=\"GET\">\n" +
                "\n" +
                "    Type your command: <input type=\"text\" name=\"command\"/>\n" +
                "\n" +
                "    <br/><br/>\n" +
                "\n" +
                "    <input type=\"submit\" value=\"Submit\"/>\n" +
                "\n" +
                "    <p>try4</p>\n" +
                "\n" +
                "</form>");

        out.println("</body></html>");

        System.out.println("command "+command);
    }
}