package db;

import static db.Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pojos.InformeSaludPOJO;



public class InformeSaludDAO {

    public static void ActualizarInforme(int idEstudiante, String seguro, String sangre) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "UPDATE inform_salud SET num_seguro_social=?, grupo_sang=? WHERE estudiante_idestudiante = " + idEstudiante;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, seguro);
                ps.setString(2, sangre);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de actualización en la base de datos: " + e.getMessage());
        }
    }

    public ObservableList<InformeSaludPOJO> ObtenerInformes() {
        ObservableList<InformeSaludPOJO> listaInformes = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM inform_salud";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    InformeSaludPOJO informe = new InformeSaludPOJO();
                    informe.setIdinf_salud(rs.getInt("idinf_salud"));
                    informe.setEstudiante_idestudiante(rs.getInt("estudiante_idestudiante"));
                    informe.setNum_seguro_social(rs.getString("num_seguro_social"));
                    informe.setGrupo_sang(rs.getString("grupo_sang"));

                    listaInformes.add(informe);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return listaInformes;
    }

    public void EliminarInforme(int idinf_salud) {
        String consulta = "DELETE FROM inform_salud WHERE idinf_salud = " + idinf_salud;
        try {
            Connection conn = ConectarBD();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.executeUpdate();

                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de eliminación en la base de datos: " + e.getMessage());
        }
    }

    public void RegistrarInformacionSalud(int est, String seguro, String sangre) {
        String consulta = "INSERT INTO inform_salud (estudiante_idestudiante, num_seguro_social, grupo_sang) VALUES (?, ?, ?)";

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, est);
                ps.setString(2, seguro);
                ps.setString(3, sangre);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de registro en la base de datos: " + e.getMessage());
        }
    }

}