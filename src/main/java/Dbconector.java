import java.sql.*;

public class Dbconector {
        public void cargarClase() throws Exception {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }
        public void actualizarDpto() throws Exception {
            Statement stmt = null;
            ResultSet rs = null;
            int filasAfectadas = 0;

            try {
                cargarClase();

                Connection c = DriverManager.getConnection("jdbc:mysql://db4free/qatar2022", "manupe", "manupe2003");

                stmt = c.createStatement();

                filasAfectadas = stmt.executeUpdate("INSERT INTO Empleados (DNI, Nombre, Apellido, Nacionalidad, Departamento) VALUES (\"32111444\", \"Marcos\", \"Rojo\", \"Argentina\", \"M\")");
                System.out.println("filas afectadas: " + filasAfectadas);

                filasAfectadas = stmt.executeUpdate("UPDATE Empleados SET Nacionalidad = \"Bolivia\" WHERE DNI = \"32111444\"");
                System.out.println("filas afectadas: " + filasAfectadas);

                filasAfectadas = stmt.executeUpdate("DELETE FROM Empleados WHERE ID = \"V\")");
                System.out.println("filas afectadas: " + filasAfectadas);

            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
            finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {}
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {}
                }

            }
        }
        public void ConsultarDpto() throws Exception{
            Statement stmt = null;
            ResultSet rs = null;

            try{
                cargarClase();

                Connection c = DriverManager.getConnection("jdbc:mysql://db4free.net/qatar2022", "manupe", "manupe2003");

                stmt = c.createStatement();

                rs = stmt.executeQuery("SELECT * FROM Empleados WHERE Departamento = \"L\"");

                while (rs.next()){
                    System.out.println(rs.getString("Nombre") + " " + rs.getString("Apellido"));
                }

                rs = stmt.executeQuery("SELECT * FROM Departamentos ORDER BY Departamento ASC");

                while (rs.next()){
                    char id = rs.getString(1).charAt(0);
                    String dpto = rs.getString(2);
                    float presupuesto = rs.getFloat(3);

                    System.out.println("ID:" + id + " Departamento:" + dpto + " Presupuesto:" + presupuesto);
                }

            }catch (Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
            finally {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {}
                }

                if (stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {}
                }
            }


        }

    }


