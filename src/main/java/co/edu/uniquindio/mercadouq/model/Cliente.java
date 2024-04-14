package co.edu.uniquindio.mercadouq.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private  static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;
    private String sexo;
    private String identificacion;
    private String pais;

    public Cliente(String nombre, int edad, String sexo, String identificacion, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.identificacion = identificacion;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
