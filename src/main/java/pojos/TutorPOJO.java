package pojos;

public class TutorPOJO {
    private int idAcudiente;
    private String ident_madre;
    private String ident_padre;
    private String nom_madre;
    private String nom_padre;
    private String direc_elec;
    private String telefono;
    private String telefono_2;
    private int idEstudiante;

    public TutorPOJO() {
    }

    public TutorPOJO(int idAcudiente, String ident_madre, String ident_padre, String nom_madre, String nom_padre, String direc_elec, String telefono, String telefono_2, int idEstudiante) {
        this.idAcudiente = idAcudiente;
        this.ident_madre = ident_madre;
        this.ident_padre = ident_padre;
        this.nom_madre = nom_madre;
        this.nom_padre = nom_padre;
        this.direc_elec = direc_elec;
        this.telefono = telefono;
        this.telefono_2 = telefono_2;
        this.idEstudiante = idEstudiante;
    }

    public int getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(int idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public String getIdent_madre() {
        return ident_madre;
    }

    public void setIdent_madre(String ident_madre) {
        this.ident_madre = ident_madre;
    }

    public String getIdent_padre() {
        return ident_padre;
    }

    public void setIdent_padre(String ident_padre) {
        this.ident_padre = ident_padre;
    }

    public String getNom_madre() {
        return nom_madre;
    }

    public void setNom_madre(String nom_madre) {
        this.nom_madre = nom_madre;
    }

    public String getNom_padre() {
        return nom_padre;
    }

    public void setNom_padre(String nom_padre) {
        this.nom_padre = nom_padre;
    }

    public String getDirec_elec() {
        return direc_elec;
    }

    public void setDirec_elec(String direc_elec) {
        this.direc_elec = direc_elec;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(String telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public String toString(){
        return nom_madre + " y " + nom_padre;
    }

}