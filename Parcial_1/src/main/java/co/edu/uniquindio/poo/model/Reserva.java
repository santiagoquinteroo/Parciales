package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Reserva {


    private String codigo;
    private String fecha;
    private int numeroNoches;
    private int cantidadHuespedes;
    private String estado;
    private String metodoPago;
    private float valorTotal;

    private Huesped huesped;
    private Hotel ownedByHotel;


    private Habitacion[] listaHabitaciones;

    public Reserva(String codigo, String fecha, int numeroNoches, int cantidadHuespedes,
                   String metodoPago, Huesped huesped, Hotel ownedByHotel) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.numeroNoches = numeroNoches;
        this.cantidadHuespedes = cantidadHuespedes;
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        this.ownedByHotel = ownedByHotel;
        this.estado = "Pendiente";
        this.valorTotal = 0;
        this.listaHabitaciones = new Habitacion[5];

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public int getCantidadHuespedes() {
        return cantidadHuespedes;
    }

    public void setCantidadHuespedes(int cantidadHuespedes) {
        this.cantidadHuespedes = cantidadHuespedes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Hotel getOwnedByHotel() {
        return ownedByHotel;
    }

    public void setOwnedByHotel(Hotel ownedByHotel) {
        this.ownedByHotel = ownedByHotel;
    }

    public Habitacion[] getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(Habitacion[] listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }
    public String agregarHabitacion(Habitacion habitacion) {
        for (int i = 0; i < listaHabitaciones.length; i++) {
            if (listaHabitaciones[i] == null) {
                listaHabitaciones[i] = habitacion;
                calcularValorTotal();
                return "Habitación " + habitacion.getNumero() + " agregada a la reserva";
            }
        }
        return "Error: la reserva ya tiene el máximo de habitaciones permitido";
    }


    public float calcularValorTotal() {
        float suma = 0;
        for (Habitacion h : listaHabitaciones) {
            if (h != null) {
                suma += h.getPrecioPorNoche();
            }
        }
        this.valorTotal = suma * numeroNoches;
        return this.valorTotal;
    }

    public String confirmar() {
        this.estado = "Confirmada";
        for (Habitacion h : listaHabitaciones) {
            if (h != null) {
                h.actualizarEstado("Reservada");
            }
        }
        return "Reserva " + codigo + " confirmada correctamente";
    }



    public boolean esCapicua() {
        if (codigo == null || codigo.isEmpty()) {
            return false;
        }
        for (int i = 0; i < codigo.length(); i++) {
            if (!Character.isDigit(codigo.charAt(i))) {
                return false;
            }
        }
        String invertido = new StringBuilder(codigo).reverse().toString();
        return codigo.equals(invertido);
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", numeroNoches=" + numeroNoches +
                ", cantidadHuespedes=" + cantidadHuespedes +
                ", estado='" + estado + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                ", huesped=" + huesped +
                ", ownedByHotel=" + ownedByHotel +
                ", listaHabitaciones=" + Arrays.toString(listaHabitaciones) +
                '}';
    }
}
