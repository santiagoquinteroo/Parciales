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

                case 5:
                    consultarHuespedPorTelefono(hotel);
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar StayPlus Hotel :)");

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




}
