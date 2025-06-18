package ConexionBD;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL implements AutoCloseable{ 
    Connection conn; 
    public Connection open(){ 
        String user = "admin";
        String password = "Lirzk834dM2qegZ";
        String url = "jdbc:mysql:biblioteca-utl.cji824u8mpow.us-east-2.rds.amazonaws.com:3306/AWS_BD";
        String parametros = "?useSSL=false&useUnicode=true&characterEncoding=utf-8"; 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(url+parametros, user, password); 
            return conn; 
        } catch (Exception e) { 
            e.printStackTrace(); 
            throw new RuntimeException(e); 
        } 
    } 
    public void close(){ 
        if (conn != null) { 
            try { 
                conn.close(); 
            } catch (Exception e) { 
                e.printStackTrace(); 
                throw new RuntimeException("Error cerrando conexión", e);
               } 
        } 
    } 
} 