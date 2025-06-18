package edu.utl.aws.controlador;

import edu.utl.aws.modelo.Libro;
import edu.utl.aws.conexionBD.ConexionSQL;
import java.sql.*;

public class ControladorLibro{
    public void insertarLibro (Libro l) throws SQLException{
        String query = "";
        
        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            
            pstm.setInt(1, l.getId());
            pstm.setString(2, l.getTitulo());
            pstm.setInt(3, l.getEditorial().getId());

            pstm.execute();
            System.out.println("Registro exitoso");
            pstm.close();
            connMysql.close();
        }catch(SQLException e){
            e.getStackTrace();
        }
    }
}