package pojos;

public class EstudiantePOJO {
    private int idEstudiante;
    private String primer_nom;
    private String primer_ape;
    private String seg_nom;
    private String segundo_ape;
    private boolean activo;
    private int idColegio;
    private String historial;
    private int idOrigen;

    public EstudiantePOJO() {
    }

    public EstudiantePOJO(int idEstudiante, String primer_nom, String primer_ape, String seg_nom, String segundo_ape, boolean activo, int idColegio, String historial, int idOrigen) {
        this.idEstudiante = idEstudiante;
        this.primer_nom = primer_nom;
        this.primer_ape = primer_ape;
        this.seg_nom = seg_nom;
        this.segundo_ape = segundo_ape;
        this.activo = activo;
        this.idColegio = idColegio;
        this.historial = historial;
        this.idOrigen = idOrigen;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getPrimer_nom() {
        return primer_nom;
    }

    public void setPrimer_nom(String primer_nom) {
        this.primer_nom = primer_nom;
    }

    public String getPrimer_ape() {
        return primer_ape;
    }

    public void setPrimer_ape(String primer_ape) {
        this.primer_ape = primer_ape;
    }

    public String getSeg_nom() {
        return seg_nom;
    }

    public void setSeg_nom(String seg_nom) {
        this.seg_nom = seg_nom;
    }

    public String getSegundo_ape() {
        return segundo_ape;
    }

    public void setSegundo_ape(String segundo_ape) {
        this.segundo_ape = segundo_ape;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    @Override
    public String toString(){
        return primer_nom +" "+ seg_nom +" "+primer_ape+" "+segundo_ape;
    }
}
