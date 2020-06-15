package com.controller;

import com.dao.HealthCodeDao;
import com.model.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/LoginAdministratorsServlet"})
public class LoginAdministratorsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HealthCodeDao dao = new HealthCodeDao();
        Teacher teacher = new Teacher();
        String school_id = request.getParameter("school_id");
//        System.out.println(school_id);
        String password = request.getParameter("password");
//        System.out.println(password);
        teacher = dao.findTeacherInfo(school_id);
//        System.out.println(teacher.getSchool_id());
//        System.out.println(teacher.getPassword());
        if(teacher==null){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/error2.jsp");
            rd.forward(request,response);
        }
        else if(!password.equals(teacher.getPassword())){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/error2.jsp");
            rd.forward(request,response);
        }
        else if(password.equals((teacher.getPassword())) && teacher.getRole().equals("校级管理员")){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/SchoolAdministrators.jsp");
            rd.forward(request,response);
        }
        else if(password.equals((teacher.getPassword())) && teacher.getRole().equals("院级管理员")){

            request.setAttribute("college",teacher.getCollege());
            System.out.println("aaaaaaaaaaaa"+teacher.getCollege());
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/majorAdministrators.jsp");
            rd.forward(request,response);
        }
        else if(password.equals((teacher.getPassword())) && teacher.getRole().equals("系统管理员")){
            RequestDispatcher rd = request.getRequestDispatcher("/JSP/allAdministrators.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}