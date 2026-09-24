package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Habitacion {
    public static final String[] DiasSemana={
            "Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"
    };

    private byte numero;
    private String tipo;
    private byte piso;
    private byte capacidad;
    private double precioPorNoche;
    private String estado;


    private Hotel ownedByHotel;
    private String[] estadoSemana;

    public Habitacion(byte numero, String tipo, byte piso, byte capacidad, double precioPorNoche, Hotel ownedByHotel) {
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
        this.estado = "Disponible";
        this.ownedByHotel = ownedByHotel;
        this.estadoSemana = new String[DiasSemana.length];
        Arrays.fill(estadoSemana,"D");
    }

    public byte getNumero() {
        return numero;
    }

    public void setNumeroDeHabitacion(byte numeroDeHabitacion) {
        this.numero = numeroDeHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public byte getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(byte capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Hotel getOwnedByHotel() {
        return ownedByHotel;
    }

    public void setOwnedByHotel(Hotel ownedByHotel) {
        this.ownedByHotel = ownedByHotel;
    }

    public String[] getEstadoSemana() {
        return estadoSemana;
    }

    public void setEstadoSemana(String[] estadoSemana) {
        this.estadoSemana = estadoSemana;
    }

    public void actualizarEstado(String nuevoEstado){
        this.estado=nuevoEstado;
    }
    public  boolean verificarDisponibilidad(){
        return estado.equals("Disponible");
    }
public String marcarDia(int indiceDia, String valor){

    if (indiceDia<0 || indiceDia>= estadoSemana.length){
        return "Error: El día debe estar entre 0(Lunes) o 6(Domingo)";
    }
    estadoSemana[indiceDia] = valor;
return "Dia actualizado correctamente"+indiceDia+" = "+valor;
}

    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroDeHabitacion=" + numero +
                ", tipo='" + tipo + '\'' +
                ", piso=" + piso +
                ", capacidad=" + capacidad +
                ", precioPorNoche=" + precioPorNoche +
                ", estado='" + estado + '\'' +
                ", ownedByHotel=" + ownedByHotel +
                ", estadoSemana=" + Arrays.toString(estadoSemana) +
                '}';
    }
}
