package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection(){
        try {
            if (conn == null) {
                Properties ps = loadPropiedades();
                String url = ps.getProperty("dburl");
                conn = DriverManager.getConnection(url, ps);
            }
        }
        catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }


    private static Properties loadPropiedades(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties ps = new Properties();
            ps.load(fs);
            return ps;
        }
        catch (IOException e){
            throw new DBException(e.getMessage());
        }
    }
}
