package db;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pojos.EstudiantePOJO;
import pojos.OrigenPOJO;
import static db.Conexion.ConectarBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrigenDAO {
    public ObservableList<OrigenPOJO> ObtenerOrigenes() {
        ObservableList<OrigenPOJO> listaOrigenes = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM origen";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    OrigenPOJO o = new OrigenPOJO();
                    o.setIdOrigen(rs.getInt("idorigen"));
                    o.setEstado(rs.getString("estado"));
                    o.setCiudad(rs.getString("ciudad"));

                    listaOrigenes.add(o);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaOrigenes;
    }

    public static void RegistrarOrigen(String estado, String ciudad) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "INSERT INTO origen (estado, ciudad) VALUES (?, ?)";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, estado);
                ps.setString(2, ciudad);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de registro en la base de datos: " + e.getMessage());
        }
    }

    public Boolean ExisteOrigen(String estado, String ciudad) {
        ArrayList<OrigenPOJO> listaOrigenes = new ArrayList<OrigenPOJO>();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM origen WHERE estado= ? AND ciudad= ? ;";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, estado);
                ps.setString(2, ciudad);
                ResultSet rs = ps.executeQuery();

                while (rs.next() == true) {
                    OrigenPOJO o = new OrigenPOJO();
                    o.setIdOrigen(rs.getInt("idorigen"));
                    o.setEstado(rs.getString("estado"));
                    o.setCiudad(rs.getString("ciudad"));

                    listaOrigenes.add(o);
                }

                if(!listaOrigenes.isEmpty()){
                    return true;
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return false;
    }

    public static void ActualizarOrigen(int idOrigen, String estado, String ciudad) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "UPDATE origen SET estado=?, ciudad=? WHERE idorigen = " + idOrigen;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, estado);
                ps.setString(2, ciudad);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de actualización en la base de datos: " + e.getMessage());
        }
    }

    public void EliminarOrigen(int idOrigen) {
        String consulta;
        try {
            Connection conn = ConectarBD();
            if (conn != null) {
                consulta = "DELETE FROM origen WHERE idorigen = " + idOrigen;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.executeUpdate();

                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de eliminación en la base de datos: " + e.getMessage());
        }
    }

    public ObservableList<OrigenPOJO> ObtenerOrigenesPorEstado(String estado) {
        ObservableList<OrigenPOJO> listaOrigenes = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM origen WHERE estado= ? ";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, estado);
                ResultSet rs = ps.executeQuery();

                while (rs.next() == true) {
                    OrigenPOJO o = new OrigenPOJO();
                    o.setIdOrigen(rs.getInt("idorigen"));
                    o.setEstado(rs.getString("estado"));
                    o.setCiudad(rs.getString("ciudad"));

                    listaOrigenes.add(o);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaOrigenes;
    }


    public boolean TieneEstudiantes(int idOrigen) {
        String consulta;
        ObservableList<EstudiantePOJO> listaEstudiantes = FXCollections.observableArrayList();

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM estudiante WHERE origen_idorigen= " + idOrigen;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next() == true) {
                    EstudiantePOJO e = new EstudiantePOJO();
                    e.setPrimer_nom(rs.getString("primer_nom"));
                    e.setPrimer_ape(rs.getString("primer_ape"));
                    e.setSeg_nom(rs.getString("seg_nom"));
                    e.setSegundo_ape(rs.getString("seg_ape"));
                    e.setActivo(rs.getBoolean("activo"));
                    e.setIdColegio(rs.getInt("colegio_idcolegio"));
                    e.setHistorial(rs.getString("historial"));
                    e.setIdOrigen(rs.getInt("origen_idorigen"));

                    listaEstudiantes.add(e);

                }

                rs.close();
                ps.close();
                conn.close();
            }

            if(!listaEstudiantes.isEmpty()){
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error de actualización en la base de datos: " + e.getMessage());
        }

        return false;
    }
}
