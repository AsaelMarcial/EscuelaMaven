package pojos;

public class OrigenPOJO {
    private int idOrigen;
    private String estado;
    private String ciudad;

    public OrigenPOJO() {
    }

    public OrigenPOJO(int idOrigen, String estado, String ciudad) {
        this.idOrigen = idOrigen;
        this.estado = estado;
        this.ciudad = ciudad;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(int idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString(){
        return estado + ciudad;
    }
}
