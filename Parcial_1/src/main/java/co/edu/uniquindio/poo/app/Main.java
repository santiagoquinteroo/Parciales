package co.edu.uniquindio.poo.app;
import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;
import co.edu.uniquindio.poo.model.Habitacion;
import co.edu.uniquindio.poo.model.Reserva;




import javax.swing.JOptionPane;

public class Main {
    static void main(){
        JOptionPane.showMessageDialog(null, "Bienvenid@ al hotel StayPlus");

        int opcion;

        do {
            opcion=Integer.valueOf(JOptionPane.showInputDialog(null,"------MENÚ------ \n"+
                                                                "1. Consultar huesped \n"+
                                                                "2. Control de disponibilidad de habitaciones \n" +
                                                                "3. Matriz de ocupación del Hotel \n"+
                                                                "4. Número especial de reserva \n"+
                                                                "0. Ingresos del Hotel"));


            switch (opcion){
                case 1:
                    break;

                default:JOptionPane.showMessageDialog(null,"Opción no encontrada o invalida, intente nuevamente");
            }

        }while(opcion!=0);
    }



}
