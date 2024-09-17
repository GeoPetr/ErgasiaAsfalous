package org.mpsp2334.ergasiaJava;

import java.sql.*;

public class CreateDB {
    public static void createNewDatabase(String DBname, String DBtype) {    //Δημιουργία βάσης δεδομένων

        String url = "jdbc:"+DBtype+":"+DBname+".db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /*public static void connect(String DBname, String DBtype) {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:"+DBtype+":"+DBname+".db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }*/
    public static void createTable(String DBname, String DBtype , String Tablename,String Fieldname) {
        String url = "jdbc:"+DBtype+":"+DBname+".db";
        Connection conn = null;
        try {                                                                       //Εγγραφή πίνακα σε βάση δεδομένων
            conn = DriverManager.getConnection(url);
            ////////////////////////////////////////////////////////Δημιουργία πίνακα
            String sql_CreateTable = "CREATE TABLE IF NOT EXISTS " +Tablename+"("+Fieldname+" INTEGER PRIMARY KEY);";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql_CreateTable);
            stmt.close();

        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
