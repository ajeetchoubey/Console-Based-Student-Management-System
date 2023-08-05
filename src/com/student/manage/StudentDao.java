package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean insertStudentToDB(Student st){
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "insert into students(sname, sphone, scity) values(?, ?, ?)";

           PreparedStatement pstmt = con.prepareStatement(q);
           pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            pstmt.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "delete from students where sid = ?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, userId);

            pstmt.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void showAllStudent() {
        try {
            Connection con = CP.createC();
            String q = "select * from students";

           Statement stmt = con.createStatement();
           ResultSet set = stmt.executeQuery(q);

           while (set.next()){
               int id = set.getInt(1);
               String name = set.getString(2);
               String phone = set.getString(3);
               String city = set.getString(4);

               System.out.println("ID : " + id);
               System.out.println("NAME : " + name);
               System.out.println("PHONE No. : " + phone);
               System.out.println("CITY : " + city);
               System.out.println("++++++++++++++++++++++++++++++");
           }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean updateName(int stuID, String newName) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "update students set sname = ? where sid = ?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, newName);
            pstmt.setInt(2, stuID);

            pstmt.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean updatePhone(int stuID, String newPhone) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "update students set sphone = ? where sid = ?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, newPhone);
            pstmt.setInt(2, stuID);

            pstmt.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean updateCity(int stuID, String newCity) {
        boolean f = false;
        try {
            Connection con = CP.createC();
            String q = "update students set scity = ? where sid = ?";

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, newCity);
            pstmt.setInt(2, stuID);

            pstmt.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
