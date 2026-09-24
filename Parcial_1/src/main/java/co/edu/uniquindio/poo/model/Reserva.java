package co.edu.uniquindio.poo.model;

public class Reserva {

    private String codigo;
    private String fecha;
    private byte numeroDeNoches;
    private byte cantidadDeHuespedes;
    private int valorTotal;

    public Reserva(String codigo, String fecha, byte numeroDeNoches, byte cantidadDeHuespedes, int valorTotal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.numeroDeNoches = numeroDeNoches;
        this.cantidadDeHuespedes = cantidadDeHuespedes;
        this.valorTotal = valorTotal;
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

    public byte getNumeroDeNoches() {
        return numeroDeNoches;
    }

    public void setNumeroDeNoches(byte numeroDeNoches) {
        this.numeroDeNoches = numeroDeNoches;
    }

    public byte getCantidadDeHuespedes() {
        return cantidadDeHuespedes;
    }

    public void setCantidadDeHuespedes(byte cantidadDeHuespedes) {
        this.cantidadDeHuespedes = cantidadDeHuespedes;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", numeroDeNoches=" + numeroDeNoches +
                ", cantidadDeHuespedes=" + cantidadDeHuespedes +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
