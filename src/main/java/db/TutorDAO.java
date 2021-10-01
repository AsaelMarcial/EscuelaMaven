package db;

import static db.Conexion.ConectarBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pojos.EstudiantePOJO;
import pojos.TutorPOJO;

/**
 *
 * @author israz
 */
public class TutorDAO {
    public ObservableList<TutorPOJO> ObtenerTutores() {
        ObservableList<TutorPOJO> listaTutores = FXCollections.observableArrayList();
        String consulta = null;
        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "SELECT * FROM tutor";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    TutorPOJO t = new TutorPOJO();
                    t.setIdAcudiente(rs.getInt("idacudiente"));
                    t.setIdEstudiante(rs.getInt("estudiante_idestudiante"));
                    t.setIdent_madre(rs.getString("ident_madre"));
                    t.setIdent_padre(rs.getString("ident_padre"));
                    t.setNom_madre(rs.getString("nom_madre"));
                    t.setNom_padre(rs.getString("nom_padre"));
                    t.setDirec_elec(rs.getString("direc_elec"));
                    t.setTelefono(rs.getString("telefono"));
                    t.setTelefono_2(rs.getString("telefono_2"));

                    listaTutores.add(t);
                }

                rs.close();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de consulta en la base de datos: " + e.getMessage());
        }

        return listaTutores;
    }

    public void RegistrarTutor(int idEstudiante, String ident_madre, String ident_padre, String nom_madre, String nom_padre, String direc_elec, String telefono, String telefono_2) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "INSERT INTO tutor "
                        + "(estudiante_idestudiante, ident_madre, ident_padre, nom_madre, nom_padre, direc_elec, telefono, telefono_2) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idEstudiante);
                ps.setString(2, ident_madre);
                ps.setString(3, ident_padre);
                ps.setString(4, nom_madre);
                ps.setString(5, nom_padre);
                ps.setString(6, direc_elec);
                ps.setString(7, telefono);
                ps.setString(8, telefono_2);


                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de registro en la base de datos: " + e.getMessage());
        }
    }

    public void ActualizarTutor(int idAcudiente, int idEstudiante, String ident_madre, String ident_padre, String nom_madre, String nom_padre, String direc_elec, String telefono, String telefono_2) {
        String consulta;

        try {
            Connection conn = ConectarBD();

            if (conn != null) {
                consulta = "UPDATE tutor "
                        + "SET idacudiente=?, estudiante_idestudiante=?, ident_madre=?, ident_padre=?, nom_madre=?, nom_padre=?, direc_elec=?, telefono=?, telefono_2=? "
                        + "WHERE idacudiente = " + idAcudiente;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idAcudiente);
                ps.setInt(2, idEstudiante);
                ps.setString(3, ident_madre);
                ps.setString(4, ident_padre);
                ps.setString(5, nom_madre);
                ps.setString(6, nom_padre);
                ps.setString(7, direc_elec);
                ps.setString(8, telefono);
                ps.setString(9, telefono_2);

                ps.executeUpdate();
                ps.close();
                conn.close();
            }

        } catch (SQLException e) {
            System.out.println("Error de actualización en la base de datos: " + e.getMessage());
        }
    }

    public void EliminarTutor(int idAcudiente) {
        String consulta;
        try {
            Connection conn = ConectarBD();
            if (conn != null) {
                consulta = "DELETE FROM tutor WHERE idacudiente = " + idAcudiente;
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.executeUpdate();

                ps.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error de eliminación en la base de datos: " + e.getMessage());
        }
    }
}
