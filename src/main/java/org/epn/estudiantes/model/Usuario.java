package org.epn.estudiantes.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CIUsuario;

    private String Nombre;
    private String correo;
    private String contraseña;
    private String tipoUsuario;

    public int getCIUsuario() {
        return CIUsuario;
    }

    public void setCIUsuario(int CIUsuario) {
        this.CIUsuario = CIUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void iniciarSesion() {
        // Lógica para iniciar sesión
    }

    public void cerrarSesion() {
        // Lógica para cerrar sesión
    }

    public void actualizarPerfil() {
        // Lógica para actualizar el perfil
    }
}
