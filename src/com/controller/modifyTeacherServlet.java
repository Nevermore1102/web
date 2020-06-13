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

@WebServlet(name = "modifyTeacherServlet")
public class modifyTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HealthCodeDao dao = new HealthCodeDao();
        Teacher teacher = new Teacher();
        String message = null;
        try{
            teacher.setName(request.getParameter("name"));
            teacher.setId(request.getParameter("id"));
            teacher.setSchool_id(request.getParameter("school_id"));
            teacher.setCollege(new String(request.getParameter("college").getBytes("iso-8859-1"), "UTF-8"));
            teacher.setRole(new String(request.getParameter("major").getBytes("iso-8859-1"), "UTF-8"));
            teacher.setAttendenceRecord(request.getParameter("attendenceRecord"));
            teacher.setPassword(request.getParameter("password"));
            teacher.setHealthday(Integer.parseInt(request.getParameter("healthday")));
            teacher.setHealthcode((request.getParameter("healthycode")));
            boolean success = dao.modifyTeacher(teacher);
            if (success) {
                message = "<li>修改成功！</li>";
            } else {
                message = "<li>修改失败</li>";
            }
        }catch (Exception e){
            e.printStackTrace();
            message = "<li>出现异常</li>";
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modifyTeacherResult.jsp");//删除页面
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
