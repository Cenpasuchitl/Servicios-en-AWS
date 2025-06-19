package edu.utl.aws.controlador;

import edu.utl.aws.modelo.Libro;
import edu.utl.aws.conexionBD.ConexionSQL;
import java.sql.*;

public class ControladorLibro{
    
    public void insertarLibro(Libro l) throws SQLException {
    // Consulta SQL corregida con AUTO_INCREMENT y nombres reales
    String query = "INSERT INTO libros (titulo, editorial_id) VALUES (?, ?)";

    try {
        ConexionSQL connMysql = new ConexionSQL();
        Connection conn = connMysql.open();
        PreparedStatement pstm = conn.prepareStatement(query);

        // Solo seteamos título y editorial_id
        pstm.setString(1, l.getTitulo());
        pstm.setInt(2, l.getEditorial().getId());

        pstm.executeUpdate(); // se recomienda usar executeUpdate() para INSERT
        System.out.println("Registro exitoso");

        pstm.close();
        connMysql.close();
    } catch(SQLException e) {
        e.printStackTrace(); // Asegura que el error se imprima en consola
        throw e; // También lanza la excepción para que RESTLibro pueda manejarla
    }
}

}