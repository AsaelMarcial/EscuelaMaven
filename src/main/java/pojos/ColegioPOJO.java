package pojos;

public class ColegioPOJO {

    private int idColegio;
    private String tipo;
    private String ciudad;
    private String nombre;

    public ColegioPOJO(){

    }

    public ColegioPOJO(int idColegio, String tipo, String ciudad, String nombre) {
        this.idColegio = idColegio;
        this.tipo = tipo;
        this.ciudad = ciudad;
        this.nombre = nombre;
    }

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return nombre + ciudad;
    }

}