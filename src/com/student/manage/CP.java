package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {

    static Connection con;
    public static Connection createC(){
        try {
            String url = "jdbc:mysql://localhost:3306/student_manage";
            String user = "root";
            String password = "";

            con = DriverManager.getConnection(url, user, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
