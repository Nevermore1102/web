package com.controller;

import com.dao.HealthCodeDao;
import com.model.Student;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.StreamSupport;

@WebServlet({"/TeacherQueryServlet"})
public class TeacherQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HealthCodeDao dao = new HealthCodeDao();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        String college = request.getParameter("college");
        teachers = dao.teacherInfoQuery(college);
        request.setAttribute("teacher",teachers);
        RequestDispatcher rd = request.getRequestDispatcher("/JSP/ShowQueryTeacehrInfo.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}