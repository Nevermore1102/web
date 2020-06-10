package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.healthyCodeDao;
import com.model.Student;

public class loginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        healthyCodeDao dao = new healthyCodeDao();
        Student student=new Student();
        String message = null;
        student.setName(request.getParameter("name"));
        student.setSchool_id(request.getParameter("school_id"));
        student.setId(request.getParameter("id"));

        try {
            if(dao.login1(student.getName(), student.getId(), student.getSchool_id())==true)
            {
                RequestDispatcher rd = request.getRequestDispatcher("/HealthyCode.jsp");
                rd.forward(request,response);
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request,response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
