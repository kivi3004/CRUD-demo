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
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h1>Update Employee</h1>");  
        
        int id = Integer.parseInt(req.getParameter("id"));      
        
        Emp e = DbConnection.getDataById(id);
        
        out.print("<form action='EditResponse' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
        out.print("<tr><td> NAME : </td><td><input type='text' name='uname' value='"+e.getName()+"' /></td></tr>");
        out.print("<tr><td> PASSWORD :</td><td> <input type='password' name='pass' value='"+e.getPassword()+" '/></td></tr>");
        out.print("<tr><td> EMAIL : </td><td> <input type='text' name='email' value='"+e.getEmail()+" '/></td></tr>");
        out.print("<tr><td> COUNTRY : </td><td> <input type='text' name='country' value='"+e.getCountry()+"'/></td></tr>");
        out.print("<tr><td colspan=2><input type='submit' value='Edit and Save'  /></td></tr>");
        out.print("</table></form>");
        out.close();
        
    }

}
