package com.dao;

import com.model.Student;
import com.model.Teacher;
import com.sun.org.apache.xml.internal.utils.StringToStringTable;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.servlet.ServletRequestListener;
import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class HealthCodeDao extends Basedao{
    //查找学生信息
    public Student findStudentInfo(String name){
        Student student = new Student();
        String sql = "SELECT * FROM students WHERE name=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            try(ResultSet rst =  pstmt.executeQuery()){
                while(rst.next()) {
                    student.setName(rst.getString("name"));
                    student.setSchool_id(rst.getString("school_id"));
                    student.setId(rst.getString("id"));
                    student.setClass1(rst.getString("class1"));
                    student.setCollege(rst.getString("college"));
                    student.setMajor(rst.getString("major"));
                    student.setAttendenceRecord(rst.getString("attendenceRecord"));
                }
            }
            return student;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //查找老师信息
    public Teacher findTeacherInfo(String school_id){
        Teacher teacher = new Teacher();
        String sql = "SELECT * FROM teachers WHERE school_id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,school_id);
            try(ResultSet rst =  pstmt.executeQuery()){
                while(rst.next()) {
                    teacher.setName(rst.getString("name"));
                    teacher.setSchool_id(rst.getString("school_id"));
                    teacher.setId(rst.getString("id"));
                    teacher.setRole(rst.getString("role"));
                    teacher.setCollege(rst.getString("college"));
                    teacher.setAttendenceRecord(rst.getString("attendenceRecord"));
                    teacher.setPassword(rst.getString("password"));
                }
            }
            return teacher;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //检索学生信息
    public ArrayList<Student> studentInfoQuery(String college, String major, String class1){
        ArrayList<Student>stuList = new ArrayList<Student>();

        String sql = "SELECT * FROM students WHERE college=? AND major=? AND class1=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,college);
            pstmt.setString(2,major);
            pstmt.setString(3,class1);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Student student = new Student();
                    student.setMajor(rst.getString("major"));
                    student.setCollege(rst.getString("college"));
                    student.setClass1(rst.getString("class1"));
                    student.setName(rst.getString("name"));
                    System.out.println(rst.getString("name"));
                    student.setId(rst.getString("id"));
                    student.setSchool_id(rst.getString("school_id"));
                    student.setAttendenceRecord(rst.getString("attendenceRecord"));
                    student.setHealthcode(rst.getString("healthcode"));
                    stuList.add(student);
                }
            }
            System.out.println(stuList.get(1).getName()+"dao");
            return stuList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //检索老师信息
    public ArrayList<Teacher> teacherInfoQuery(String college){
        ArrayList<Teacher>teaList = new ArrayList<Teacher>();

        String sql = "SELECT * FROM teachers WHERE college=? ";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,college);
            try(ResultSet rst = pstmt.executeQuery()){
                while (rst.next()){
                    Teacher teacher =new Teacher();
                    teacher.setAttendenceRecord(rst.getString("attendenceRecord"));
                    teacher.setPassword(rst.getString("Password"));
                    teacher.setRole(rst.getString("role"));
                    teacher.setCollege(rst.getString("college"));
                    teacher.setId(rst.getString("id"));
                    teacher.setSchool_id(rst.getString("school_id"));
                    teacher.setName(rst.getString("name"));
                    teacher.setHealthcode(rst.getString("healthcode"));
                    teacher.setHealthday(rst.getInt("healthday"));
                    teaList.add(teacher);
                }
            }

            return teaList;
        }catch (SQLException se){
            se.printStackTrace();
            return null;
        }
    }
    //删除老师
    public boolean deleteTeacher(String name){
        String sql = "DELETE FROM teachers WHERE name=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            if(pstmt.executeUpdate() > 0){
                return true;
            }
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
        return false;
    }
    //修改教师
    public boolean modifyTeacher(Teacher teacher){
        String sql = "UPDATE teachers SET id=?,school_id=?,college=?,role=?, attendenceRecord=?,password=?,healthday=?,healthcode=? WHERE name=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,teacher.getId());
            pstmt.setString(2,teacher.getSchool_id());
            pstmt.setString(3,teacher.getCollege());
            pstmt.setString(4,teacher.getRole());
            pstmt.setString(5,teacher.getAttendenceRecord());
            pstmt.setString(6,teacher.getPassword());
            pstmt.setInt(7,teacher.getHealthday());
            pstmt.setString(8,teacher.getHealthcode());
            pstmt.setString(9,teacher.getName());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
    public boolean addTeacher(Teacher teacher){
        String sql = "INSERT INTO teachers" + "(name,id,school_id,college,role,attendenceRecord,password,healthday,healthcode)VALUES(?,?,?,?,?)";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getId());
            pstmt.setString(3,teacher.getSchool_id());
            pstmt.setString(4,teacher.getCollege());
            pstmt.setString(5,teacher.getRole());
            pstmt.setString(6,teacher.getAttendenceRecord());
            pstmt.setString(7,teacher.getPassword());
            pstmt.setInt(8,teacher.getHealthday());
            pstmt.setString(9,teacher.getHealthcode());
            pstmt.executeUpdate();
            return true;
        }catch (SQLException se){
            se.printStackTrace();
            return false;
        }
    }
}