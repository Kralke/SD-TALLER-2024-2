package com.DAO.TiendaVirtualSB;
import java.sql.*;
/**
 * Clase que permite conectar con la base de datos
 * 
 *
 */
public class Conexion {
   /**Parametros de conexion*/
   static String bd = "sd-tienda";
   static String login = "citizix_user";
   static String password = "S3cret";
   static String url = "jdbc:postgresql://localhost:5432/"+bd;

   Connection connection = null;
   /** Constructor de DbConnection */
   public Conexion() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("org.postgresql.Driver");
         //obtenemos la conexión
         connection = DriverManager.getConnection(url,login,password);
         if (connection!=null){
            System.out.println("Conexión a base de datos "+bd+" OK\n");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return connection;
   }
   public void desconectar(){
	  try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      connection = null;
   }
}