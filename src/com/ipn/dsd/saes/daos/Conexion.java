
package com.ipn.dsd.saes.daos;

/**
 *
 * @author tavo
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Conexion {
    
private static Connection conexion = null; 
     // Método utilizado para recuperar el valor del atributo Conexion
     // @return Conexion contiene el estado de la conexión
 public Connection getConexion()
 {
   return conexion;
 }
 

// Método utilizado para establecer la conexión con la base de datos
// @return estado regresa el estado de la conexión, true si se estableció la conexión,
// falso en caso contrario

public boolean crearConexion()
{
   try {
      
      Class.forName("com.mysql.jdbc.Driver");
      conexion = DriverManager.getConnection("jdbc:mysql://host:puerto/saesdb","root","escom");
   } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
   } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      return false;
   }
 
   return true;
}

//Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
//@param sql Cadena que contiene la instrucción SQL a ejecutar
//@return estado regresa el estado de la ejecución, true(éxito) o false(error)

public boolean ejecutarSQL(String sql)
{
   try {
      Statement sentencia = conexion.createStatement();
      sentencia.executeUpdate(sql);
   } catch (SQLException ex) {
      ex.printStackTrace();
   return false;
   }
 
   return true;
}
 

//Método utilizado para realizar la instrucción SELECT
//@param sql Cadena que contiene la instrucción SQL a ejecutar
//@return resultado regresa los registros generados por la consulta

public ResultSet ejecutarSQLSelect(String sql)
{
   ResultSet resultado;
   try {
      Statement sentencia = conexion.createStatement();
      resultado = sentencia.executeQuery(sql);
   } catch (SQLException ex) {
      ex.printStackTrace();
      return null;
   }
 
   return resultado;
}

// Método utilizado para establecer la conexión con la base de datos
// @return estado regresa el estado de la conexión, true si se estableció la conexión,
// falso en caso contrario

public boolean cerrarConexion()
{
   try {
      
      conexion.close();
   } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
   }
      return true;
}
}
