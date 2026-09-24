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
        return msg;
    }
    public Habitacion buscarHabitacionPorNumero(int numero){
        for (Habitacion aux : listaHabitaciones){
            if (aux.getNumero() == numero){
                return aux;
            }
        }
        return null;
    }

    public String registrarReserva (String codigo, String fecha, byte numeroDeNoches, byte cantidadHuespedes,
                                    String metodoPago, String documento, int[] numerosHabitaciones) {
        String msg = "";
        Huesped huesped = buscarHuespedPorDocumento(documento);

        if (huesped == null) {
            return "Error, el huésped no se encuentra registrado";
        }

        Reserva reservaNueva = new Reserva(codigo, fecha, numeroDeNoches, cantidadHuespedes, metodoPago, huesped, this);

        for (int numero : numerosHabitaciones) {
            Habitacion habitacion = buscarHabitacionPorNumero(numero);
            if (habitacion == null) {
                msg+= "Error, la habitación " + numero + " no existe";
            }
            if (!habitacion.verificarDisponibilidad()) {
                msg+= "Error, la habitación " + numero + " no está disponible";
            }
            reservaNueva.agregarHabitacion(habitacion);
        }
        listaReservas.add(reservaNueva);
        msg+="Reserva registrada con éxito. Valor total: S "+reservaNueva.calcularValorTotal();
        return msg;
    }

    public Reserva buscarReservaPorCodigo(String codigo){
        for (Reserva aux : listaReservas){
            if (aux.getCodigo().equals(codigo)){
                return aux;
            }
        }
        return null;


    }
    //__________ MATRIZ OCUPACIÓN

    public int contarHabitacionesOcupadas (int indiceDia){
        int contador=0;
        for (Habitacion aux : listaHabitaciones){
            if (aux.getEstadoSemana().equals("0")){
                contador++;
            }
        }
        return contador;
    }

    public String diaMayorOcupacion() {
        int mejorIndice = -1;
        int mejorConteo = -1;
        for (int dia = 0; dia < Habitacion.DiasSemana.length; dia++) {
            int conteo = contarHabitacionesOcupadas(dia);
            if (conteo > mejorConteo) {
                mejorConteo = conteo;
                mejorIndice = dia;
            }
        }
        return mejorIndice >= 0 ? Habitacion.DiasSemana[mejorIndice] : "No hay datos";
    }

    public String diaMenorOcupacion() {
        int peorIndice = -1;
        int peorConteo = Integer.MAX_VALUE;
        for (int dia = 0; dia < Habitacion.DiasSemana.length; dia++) {
            int conteo = contarHabitacionesOcupadas(dia);
            if (conteo < peorConteo) {
                peorConteo = conteo;
                peorIndice = dia;
            }
        }
        if(peorConteo >= 0 ){
            return Habitacion.DiasSemana[peorConteo];
        }else{
            return "No hay datos";
        }

    }

    public int totalHabitacionesOcupadas() {
        int total = 0;
        for (Habitacion aux : listaHabitaciones) {
            for (String estadoDia : aux.getEstadoSemana()) {
                if (estadoDia.equals("O")) {
                    total++;
                }
            }
        }
        return total;
    }

    public String imprimirMatrizOcupacion() {
        String msg = "Habitación\t";
        for (String dia : Habitacion.DiasSemana) {
            msg +=  dia + "\t";
        }
        msg +=  "\n";

        for (Habitacion aux : listaHabitaciones) {
            msg +=  aux.getNumero() + "\t\t";
            for (String estadoDia : aux.getEstadoSemana()) {
                msg += estadoDia + "\t";
            }
            msg +="\n";
        }
        return msg;
    }


    public double calcularIngresos(String fecha) {
        double ingresos = 0;
        for (Reserva aux : listaReservas) {
            if (aux.getFecha().equals(fecha)) {
                ingresos += aux.getValorTotal();
            }
        }
        return ingresos;
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




