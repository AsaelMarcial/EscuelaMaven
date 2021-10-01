package pojos;

public class InformeSaludPOJO {
    private int idinf_salud;
    private int estudiante_idestudiante;
    private String num_seguro_social;
    private String grupo_sang;

    /**
     *Esta clase contiene los atributos de Informe de salud
     * 
     * @author isra
     * 
     */
    public InformeSaludPOJO() {
    }

    public InformeSaludPOJO(int idinf_salud, int estudiante_idestudiante, String num_seguro_social, String grupo_sang) {
        this.idinf_salud = idinf_salud;
        this.estudiante_idestudiante = estudiante_idestudiante;
        this.num_seguro_social = num_seguro_social;
        this.grupo_sang = grupo_sang;
    }

    public int getIdinf_salud() {
        return idinf_salud;
    }

    public void setIdinf_salud(int idinf_salud) {
        this.idinf_salud = idinf_salud;
    }

    public int getEstudiante_idestudiante() {
        return estudiante_idestudiante;
    }

    public void setEstudiante_idestudiante(int estudiante_idestudiante) {
        this.estudiante_idestudiante = estudiante_idestudiante;
    }

    public String getNum_seguro_social() {
        return num_seguro_social;
    }

    public void setNum_seguro_social(String num_seguro_social) {
        this.num_seguro_social = num_seguro_social;
    }

    public String getGrupo_sang() {
        return grupo_sang;
    }

    public void setGrupo_sang(String grupo_sang) {
        this.grupo_sang = grupo_sang;
    }

    @Override
    public String toString() {
        return "ID Estudiante:" + estudiante_idestudiante + ",Seguro Social:" + num_seguro_social + ",Grupo Sanguineo:" + grupo_sang;
    }


}