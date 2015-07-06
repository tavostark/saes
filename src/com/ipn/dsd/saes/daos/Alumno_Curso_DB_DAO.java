
package com.ipn.dsd.saes.daos;

import java.sql.ResultSet;

public class Alumno_Curso_DB_DAO extends Conexion_DB_DAO{
    private static  String SQL_ALUMNO_CURSO= "select id_alumno,id_periodo,id_materia,id_area,id_profesor,id_calificacion from alumno_curso;";
    private static String SQL_ALUMNO_CURSO_INSERT="INSERT INTO alumno_curso (id_periodo,id_materia,id_area,id_profesor) VALUES(";
    private static String SQL_ALUMNO_CURSO_DELETE="DELETE FROM alumno_curso WHERE ";
    private static String SQL_ALUMNO_CURSO_UPDATE="UPDATE alumno_curso SET ";
    

                //INSERT, DELETE
    public Integer alumno_curso_insert (Integer id_alumno,Integer id_periodo,Integer id_materia,Integer id_area,Integer id_profesor,Integer id_calificacion){
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            Integer res=null;
            boolean rs=false;
            try{
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_ALUMNO_CURSO_INSERT+id_alumno+","+id_periodo+","+id_materia+","+id_area+","+id_profesor+","+id_calificacion+");");
                if (rs == true) {
                res = 1;
                } else {
                res = null;
                }
            }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
            finally {
            con.cerrarConexion();
            }
        return res;
    }
    public Integer alumno_curso_delete (String id_alumno,String id_periodo,String id_materia,String id_area,String id_profesor,String id_calificacion){
            Conexion_DB_DAO con =new Conexion_DB_DAO();
            Integer res=null;
            boolean rs=false;
           try{
                con.crearConexion();
                rs=con.ejecutarSQL(SQL_ALUMNO_CURSO_DELETE+"id_alumno="+id_alumno+" AND id_periodo="+id_periodo+" AND id_materia="+id_materia+" AND id_area="+id_area+" AND id_profesor="+id_profesor+" AND id_calificacion="+id_calificacion);
                if (rs == true) {
                res = 1;
                } else {
                res = null;
                }
                }
            catch(Exception e){
                System.out.println("SQLException: " + e);
            }
           finally {
            con.cerrarConexion();
            }
        return res;
    }
    
}
