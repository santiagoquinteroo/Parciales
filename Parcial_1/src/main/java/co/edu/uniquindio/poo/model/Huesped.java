package co.edu.uniquindio.poo.model;

public class Huesped {

    private String nombre;
    private String documento;
    private byte edad;
    private String telefono;
    private String ciudadDeProcedencia;

    private Hotel ownedByHotel;

    public Huesped(String nombre, String documento, byte edad, String telefono, String ciudadDeProcedencia, Hotel ownedByHotel) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.telefono = telefono;
        this.ciudadDeProcedencia = ciudadDeProcedencia;
        this.ownedByHotel = ownedByHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudadDeProcedencia() {
        return ciudadDeProcedencia;
    }

    public void setCiudadDeProcedencia(String ciudadDeProcedencia) {
        this.ciudadDeProcedencia = ciudadDeProcedencia;
    }

    public Hotel getOwnedByHotel() {
        return ownedByHotel;
    }

    public void setOwnedByHotel(Hotel ownedByHotel) {
        this.ownedByHotel = ownedByHotel;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", ciudadDeProcedencia='" + ciudadDeProcedencia + '\'' +
                ", ownedByHotel=" + ownedByHotel +
                '}';
    }
}
