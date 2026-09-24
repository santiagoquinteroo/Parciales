package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;
import co.edu.uniquindio.poo.model.Habitacion;
import co.edu.uniquindio.poo.model.Reserva;




import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    static void main(){
        JOptionPane.showMessageDialog(null, "Bienvenid@ al hotel StayPlus");

        Hotel hotel= new Hotel("StayPlus","900123456-7","Cra 10 # 20-30 Circasia, Quindío","3114673957",
                new ArrayList<Huesped>(), new ArrayList<Habitacion>(), new ArrayList<Reserva>());

        int opcion;

        do {
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"------MENÚ------ \n" +
                    "1. Registrar huésped \n" +
                    "2. Registrar habitación \n" +
                    "3. Registrar reserva \n" +
                    "4. Confirmar reserva \n" +
                    "5. Consultar huésped por teléfono \n" +
                    "6. Marcar día de ocupación de una habitación \n" +
                    "7. Ver matriz de ocupación \n" +
                    "8. Verificar si una reserva es especial (capicúa) \n" +
                    "9. Calcular ingresos por fecha \n" +
                    "0. Salir"));


            switch (opcion){
                case 1:
                    registrarHuesped(hotel);
                    break;

                case 2:
                    registrarHabitacion(hotel);
                    break;

                case 3:
                    registrarReserva(hotel);
                    break;

                case 4:
                    confirmarReserva(hotel);
                    break;

                case 5:
                    consultarHuespedPorTelefono(hotel);
                    break;

                case 6:
                    marcarDiaOcupacion(hotel);
                    break;

                case 7:
                    imprimirMatrizDeOcupacion(hotel);
                    break;

                case 8:
                    verificarCapicua(hotel);
                    break;

                case 9:
                    calcularIngresos(hotel);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar StayPlus Hotel :)");
                    break;
                default:JOptionPane.showMessageDialog(null,"Opción no encontrada o invalida, intente nuevamente");
            }

        }while(opcion!=0);
    }
    static void registrarHuesped(Hotel hotel){
        String nombre= JOptionPane.showInputDialog(null, "Ingrese el nombre del Huesped: ");
        String documento= JOptionPane.showInputDialog(null, "Ingrese el documento del Huesped: ");
        byte edad= Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese el edad del Huesped: "));
        String telefono= JOptionPane.showInputDialog(null, "Ingrese el telefono del Huesped: ");
        String ciudadDeProcedencia= JOptionPane.showInputDialog(null, "Ingrese la ciudad de procedencia");

        String resultado= hotel.registrarHuesped(nombre, documento, edad, telefono, ciudadDeProcedencia);
        if (resultado.isEmpty()){
            resultado="Huésped registrado con éxito";
        }
        JOptionPane.showMessageDialog(null,resultado);

    }
    static void consultarHuespedPorTelefono(Hotel hotel){
        String telefono= JOptionPane.showInputDialog(null,"Ingrese el teléfono a consultar");
        Huesped huesped=hotel.buscarHuespedPorTelefono(telefono);

        if(huesped==null){
            JOptionPane.showMessageDialog(null,"Huesped no encontrado");
        }else{
            JOptionPane.showMessageDialog(null,"Telefono: "+telefono+" || "+huesped.getNombre()+" || "+huesped.getEdad()+" || "+huesped.getCiudadDeProcedencia()+" || "+huesped.getDocumento());
        }
    }
    static void registrarHabitacion(Hotel hotel){
        byte numero = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese el número de la habitación"));
        String tipo = JOptionPane.showInputDialog(null, "Ingrese el tipo (Individual, Doble o Suite)");
        byte piso = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese el piso"));
        byte capacidad = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese la capacidad máxima de personas"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio por noche"));

        String resultado = hotel.registrarHabitacion(numero, tipo, piso, capacidad, precio);
        if (resultado.isEmpty()) {
            resultado = "Habitación registrada con éxito";
        }
        JOptionPane.showMessageDialog(null, resultado);


    }

    static void registrarReserva(Hotel hotel) {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la reserva");
        String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha (dd/mm/aaaa)");
        byte noches = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese el número de noches"));
        byte cantidadHuespedes = Byte.parseByte(JOptionPane.showInputDialog(null, "Ingrese la cantidad de huéspedes"));
        String metodoPago = JOptionPane.showInputDialog(null, "Ingrese el método de pago (Efectivo, Tarjeta o Transferencia)");
        String documento = JOptionPane.showInputDialog(null, "Ingrese el documento del huésped que reserva");

        int cantidadHabitaciones = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cuántas habitaciones desea reservar?"));
        int[] numerosHabitaciones = new int[cantidadHabitaciones];
        for (int i = 0; i < cantidadHabitaciones; i++) {
            numerosHabitaciones[i] = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Ingrese el número de la habitación " + (i + 1)));
        }

        String resultado = hotel.registrarReserva(codigo, fecha, noches, cantidadHuespedes,
                metodoPago, documento, numerosHabitaciones);
        JOptionPane.showMessageDialog(null, resultado);
    }

    static void confirmarReserva(Hotel hotel) {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la reserva a confirmar");
        Reserva reserva = hotel.buscarReservaPorCodigo(codigo);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null, "Error, no se encontró la reserva");
        } else {
            JOptionPane.showMessageDialog(null, reserva.confirmar());
        }
    }

    static void verificarCapicua(Hotel hotel) {
        String codigo = JOptionPane.showInputDialog(null, "Ingrese el código de la reserva a verificar");
        Reserva reserva = hotel.buscarReservaPorCodigo(codigo);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null, "Error, no se encontró la reserva");
        } else if (reserva.esCapicua()) {
            JOptionPane.showMessageDialog(null, "La reserva " + codigo + " es especial (capicúa)");
        } else {
            JOptionPane.showMessageDialog(null, "La reserva " + codigo + " no es especial");
        }
    }

    static void marcarDiaOcupacion(Hotel hotel) {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de la habitación"));
        Habitacion habitacion = hotel.buscarHabitacionPorNumero(numero);

        if (habitacion == null) {
            JOptionPane.showMessageDialog(null, "Error, no existe esa habitación");
        }
        int dia = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el día (0=Lunes, 1=Martes, 2=Miércoles, 3=Jueves, 4=Viernes, 5=Sábado, 6=Domingo)"));
        String valor = JOptionPane.showInputDialog(null, "Ingrese el estado (O = Ocupada, D = Disponible)");

        String resultado = habitacion.marcarDia(dia, valor.toUpperCase());
        JOptionPane.showMessageDialog(null, resultado);
        }

    static void imprimirMatrizDeOcupacion(Hotel hotel) {
        String mensaje = hotel.imprimirMatrizOcupacion();
        mensaje = mensaje + "\nDía con mayor ocupación: " + hotel.diaMayorOcupacion();
        mensaje = mensaje + "\nDía con menor ocupación: " + hotel.diaMenorOcupacion();
        mensaje = mensaje + "\nTotal de habitaciones ocupadas en la semana: " + hotel.totalHabitacionesOcupadas();
        JOptionPane.showMessageDialog(null, mensaje);
    }
    static void calcularIngresos(Hotel hotel) {
        String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha a consultar (dd/mm/aaaa)");
        double ingresos = hotel.calcularIngresos(fecha);
        JOptionPane.showMessageDialog(null, "Ingresos del " + fecha + ": $" + ingresos);
    }
}







