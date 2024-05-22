package dh.backend.models;

public class Odontologo {
    private Integer id;
    private Integer numero_matricula;
    private String nombre;
    private String apellido;

    public Odontologo(Integer numero_matricula, String nombre, String apellido) {
        this.numero_matricula = numero_matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(Integer id, Integer numero_matricula, String nombre, String apellido) {
        this.id = id;
        this.numero_matricula = numero_matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero_matricula() {
        return numero_matricula;
    }

    public void setNumero_matricula(Integer numero_matricula) {
        this.numero_matricula = numero_matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
