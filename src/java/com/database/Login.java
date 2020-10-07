/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author kirty
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("uname");
        String password =req.getParameter("pass");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        
        Emp e = new Emp();
        e.setName(name);
        e.setCountry(country);
        e.setEmail(email);
        e.setPassword(password);
        
        int result = DbConnection.save(e);
        if(result>0){
            out.println("<h1>Record Added Successfully</h1><br<br>");
             
            req.getRequestDispatcher("index.html").include(req, res);  
        }
        else
            out.println("Error");
        
        out.close();
    }

}
