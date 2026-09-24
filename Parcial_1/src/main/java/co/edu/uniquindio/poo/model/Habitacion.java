package co.edu.uniquindio.poo.model;

public class Habitacion {

    private byte numeroDeHabitacion;
    private byte piso;
    private byte capacidad;
    private int precioPorNoche;

    public Habitacion(byte numeroDeHabitacion, byte piso, byte capacidad, int precioPorNoche) {
        this.numeroDeHabitacion = numeroDeHabitacion;
        this.piso = piso;
        this.capacidad = capacidad;
        this.precioPorNoche = precioPorNoche;
    }

    public byte getNumeroDeHabitacion() {
        return numeroDeHabitacion;
    }

    public void setNumeroDeHabitacion(byte numeroDeHabitacion) {
        this.numeroDeHabitacion = numeroDeHabitacion;
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

    public int getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(int precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numeroDeHabitacion=" + numeroDeHabitacion +
                ", piso=" + piso +
                ", capacidad=" + capacidad +
                ", precioPorNoche=" + precioPorNoche +
                '}';
    }
}
