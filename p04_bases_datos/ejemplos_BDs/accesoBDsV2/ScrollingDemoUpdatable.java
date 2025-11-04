/* Acesso a la base de datos:
   - Con recorrido aleatorio o ResultSet arrastable (ResultSet.TYPE_SCROLL_INSENSITIVE
                                                   y ResultSet.CONCUR_READ_ONLY)
   - Con Statemen de sólo lectura -> createStatement() (sin parámetros. Opciones por defecto.
   - Actualizaciones, borrados, e inserciones directas a la BDs y no al ResulSet.
 */

package accesoBDsV2;

import java.sql.*;
import java.io.*;

public class ScrollingDemoUpdatable {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    try {
      conn = ConnectionFactory.getConnection();
      /* Los resultSet puede ser (Primer par�metro de createStatement):
         - Por defecto (lineal o no arrastable / Sólo hacia adelante) -> ResultSet.TYPE_FORWARD_ONLY
         - Insensible a los cambios de la BDs -> ResultSet.TYPE_SCROLL_INSENSITIVE 
         - Sensible a los cambios de la BDs -> Con ResultSet.TYPE_SCROLL_SENSITIVE
         El segundo par�metro de createStatement establece el tipo de concurrencia
       */
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                  ResultSet.CONCUR_UPDATABLE); //Tomas: UPDATABLE
      String sql = "SELECT * FROM empleado";
                   //+ "ORDER BY apellido"; // Tomas: Derby no admite ORDER BY
      rset = stmt.executeQuery(sql);

      if (rset.next()) {
        rset.beforeFirst();
        boolean done = false;
        BufferedReader in = 
          new BufferedReader(new InputStreamReader(System.in));
        while (!done) {
          System.out.println("\nOpciones: F (first), N (next), P (previous), " 
                           + "L (last), U (Update),  I (Increase), Q (quit) : ");
          String s = in.readLine();
          boolean result = false;
          if (s.equalsIgnoreCase("F")) {
            result = rset.first();
          } else if (s.equalsIgnoreCase("N")) {
            result = rset.next();
          } else if (s.equalsIgnoreCase("P")) {
            result = rset.previous();
          } else if (s.equalsIgnoreCase("L")) {
            result = rset.last();
          } else if (s.equalsIgnoreCase("U")) {                 
              result = rset.absolute(1); // Tomas: update the ?th row. If commented, then the current row is updated.
              float newBonus = rset.getFloat("SUELDO") + 100;
              rset.updateFloat("SUELDO", newBonus);
              rset.updateRow();
          } else if (s.equalsIgnoreCase("I")) {
              // Tomas: se inserta al final pero no se puede ver ahora (TYPE_SCROLL_INSENSITIVE) hay que cargar el resultset de nuevo
              rset.moveToInsertRow();
              rset.updateInt(1, 50);
              rset.updateString("NOMBRE", "Eloisa");
              rset.updateString("APELLIDO", "GARCIA");
              rset.updateString(4, "default.jpg");
              rset.updateFloat("SUELDO", 1200);
              rset.updateFloat(6, 2000);              
              java.util.Date d = new java.util.Date();  
              rset.updateDate(7, new java.sql.Date(d.getYear(), d.getMonth(), d.getDay()));             
              rset.insertRow();
              rset.moveToCurrentRow();
              result = true;
          } else if (s.equalsIgnoreCase("Q")) {
            done = true;
       
      }
          
          if (done) {
            break;
          } 
          if (result) {
            System.out.println("CURSOR movido a la fila " + rset.getRow());
            System.out.println("NUMERO: " + rset.getInt(1) 
                               + ", NOMBRE: " + rset.getString(2) 
                               + ", APELLIDO: " + rset.getString(3)
                               + ", FOTO: " + rset.getString(4)
                               + ", SUELDO: " + rset.getFloat(5)
                               + ", SUELDO-MAXIMO: " + rset.getFloat(6)
                               + ", FECHA-ALTA: " + rset.getDate(7)
            );
          }
          else {              
            System.out.println(result + " NO se puede mover el cursor");
          } 
        } 
        in.close();
      } else {
        System.out.println("ResultSet sin filas");
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
    finally {
      ConnectionFactory.close(rset);
      ConnectionFactory.close(stmt);
      ConnectionFactory.close(conn);
    }
  }
}
