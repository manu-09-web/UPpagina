package com.formulario.modelos;

public class Formulario {
    private int idFormulario;
    private String nombre;
    private String correo;
    private String telefono;
    private String preparatoria;
    private String dudas;

    public Formulario() {}

    public Formulario(String nombre, String correo, String telefono, String preparatoria, String dudas) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.preparatoria = preparatoria;
        this.dudas = dudas;
    }

    public int getIdFormulario() { return idFormulario; }
    public void setIdFormulario(int idFormulario) { this.idFormulario = idFormulario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getPreparatoria() { return preparatoria; }
    public void setPreparatoria(String preparatoria) { this.preparatoria = preparatoria; }

    public String getDudas() { return dudas; }
    public void setDudas(String dudas) { this.dudas = dudas; }
}