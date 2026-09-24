package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    private ArrayList<Huesped>listaHuespedes;
    private ArrayList<Habitacion>listaHabitaciones;
    private ArrayList<Reserva>listaReservas;

    public Hotel(String nombre, String nit, String direccion, String telefono, ArrayList<Huesped> listaHuespedes, ArrayList<Habitacion> listaHabitaciones, ArrayList<Reserva> listaReservas) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.listaHuespedes = listaHuespedes;
        this.listaHabitaciones = listaHabitaciones;
        this.listaReservas = listaReservas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public void setListaHuespedes(ArrayList<Huesped> listaHuespedes) {
        this.listaHuespedes = listaHuespedes;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public String registrarHuesped(String nombre, String documento, byte edad, String telefono, String ciudadDeProcedencia){
        String msg="";
        Huesped buscado=buscarHuespedPorDocumento(documento);

        if(buscado!=null){
            msg="El huesped ya ha sido registrado previamente";
        }else{
        Huesped huespedNuevo= new Huesped(nombre, documento, edad, telefono, ciudadDeProcedencia, this);
        listaHuespedes.add(huespedNuevo);
        }
        return msg;
    }
    public Huesped buscarHuespedPorDocumento(String documento){
for (Huesped aux: listaHuespedes){
    if (aux.getDocumento().equals(documento)){
        return aux;
            }

        }
        return null;
    }

    public Huesped buscarHuespedPorTelefono(String telefono){
        for (Huesped aux: listaHuespedes){
            if (aux.getTelefono().equals((telefono))){
                return aux;
            }
        }
        return  null;
    }

    public String registrarHabitacion (byte numero,String tipo,byte piso,byte capacidad,double precioPorNoche){
        String msg="";
        Habitacion buscada=buscarHabitacionPorNumero(numero);

        if (buscada!=null){
            msg+="Habitación ya registrada";

        }else{
            Habitacion habitacionNueva= new Habitacion(numero, tipo, piso, capacidad, precioPorNoche, this );
            listaHabitaciones.add(habitacionNueva);

        }
    }
    public Habitacion buscarHabitacionPorNumero(byte numero){
        for (Habitacion aux : listaHabitaciones){
            if (aux.getNumero() == numero){
                return aux;
            }
        }
        return null;
    }

    public String registrarReserva (String codigo, String fecha, int numeroDeNoches, int cantidadHuespedes,
                                    String metodoPago, String documento, int[] numerosHabitaciones){
        String msg = "";
        Huesped huesped = buscarHuespedPorDocumento(documento);

        if (huesped == null) {
            return "Error, el huésped no se encuentra registrado";
        }

        Reserva reservaNueva = new Reserva(codigo, fecha, numeroDeNoches, cantidadHuespedes, metodoPago, huesped, this);

        for (int numero : numerosHabitaciones) {
            Habitacion habitacion = buscarHabitacionPorNumero(numero);
            if (habitacion == null) {
                return "Error, la habitación " + numero + " no existe";
            }
            if (!habitacion.verificarDisponibilidad()) {
                return "Error, la habitación " + numero + " no está disponible";
            }
            reservaNueva.agregarHabitacion(habitacion);
        }
    }

public Reserva buscarReservaPorCodigo(String codigo){
        for (Reserva aux : listaReservas){
            if (aux.getCodigo().equals(codigo)){
                return aux;
            }
        }
        return null;

    }


    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", nit='" + nit + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaHuespedes=" + listaHuespedes +
                ", listaHabitaciones=" + listaHabitaciones +
                ", listaReservas=" + listaReservas +
                '}';
    }

}
