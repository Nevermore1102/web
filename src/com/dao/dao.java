package com.dao;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
public class dao {
    DataSource dataSource;
    public dao(){
        try{

            Context context = new InitialContext();
            dataSource =
                    (DataSource)context.lookup("java:comp/env/jdbc/webstoreDS");
        }catch (NamingException ne){
            System.out.println("Exception:"+ne);
        }
    }
    public Connection getConnection()throws Exception{
        return dataSource.getConnection();
    }
}
