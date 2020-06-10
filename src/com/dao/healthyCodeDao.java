package com.dao;

import com.model.Student;
import com.model.Teacher;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class healthyCodeDao extends dao{
    //登录验证
    public boolean login1(String name,String id,String school_id) throws Exception
    {
        String sql="SELECT name,id,school_id FROM students WHERE school_id=?";
        boolean success=false;
        try(Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, school_id);
            try(ResultSet rst = pstmt.executeQuery()){
                while(rst.next()){
                    if(name==rst.getString(name))
                    {
                        return true;
                    }
                }
            }
        }
        return false;

    }
}
