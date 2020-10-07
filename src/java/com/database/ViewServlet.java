/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kirty
 */
@WebServlet(name = "ViewServlet", urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        List<Emp> list = DbConnection.viewData();
        
        out.println("<br><br><div align='center'><h1>All Employee List </h1></div><br><br>");
        
        out.print("<table border = '4' width=100%>");
        out.print("<tr align='center'><td>ID</td><td>NAME</td><td>EMAIL</td><td>PASSWORD</td><td>Country</td><td>EDIT</td><td>DELETE</td></tr>");
        
        for(Emp e : list){
            out.print("<tr><td>" +e.getId()+ "</td><td>" +e.getName() +"</td><td>"+e.getEmail() +"</td><td>"+e.getPassword() +"</td><td>"+e.getCountry() +"</td>");
            out.print("<td><a href='EditServlet?id="+e.getId() +"'> Edit </a></td>");
            out.print("<td><a href='DeleteServlet?id="+e.getId()+"'> Delete </a></td></tr>");
        }
        out.println("</table");
        out.println("<br><br><br><br>");
        
        out.println("<div align='center'><a href='index.html'>Add New Employee</a></div>");
        
    }

}
