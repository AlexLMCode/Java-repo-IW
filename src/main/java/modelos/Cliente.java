package modelos;

import java.util.Objects;

public class Cliente {
    private String cedula;
    private String nombres;
    private String apellidos;
    private Telefono telefono;
    private Direccion direccion;
    private CorreoElectronico correo;

    public Cliente(String cedula, String nombres, String apellidos, Telefono telefono, Direccion direccion, CorreoElectronico correo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }
    
    public Cliente(String cedula){
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.cedula, other.cedula);
    }

    public String getTelefono() {
        return this.telefono.getNumero();
    }

    public String getDireccion() {
        return this.direccion.getCallePrincipal();
    }

    public String getCorreoElectronico() {
        return this.correo.getCorreo();
    }

    public void setTelefono(String telefono) {
        this.telefono = new Telefono(telefono);
    }

    public void setDireccion(String callePrincipal,String calleSecundaria) {
        this.direccion = new Direccion(callePrincipal,calleSecundaria);
    }

    public void setCorreo(String correo) {
        this.correo = new CorreoElectronico(correo);
    }
    
    
}
