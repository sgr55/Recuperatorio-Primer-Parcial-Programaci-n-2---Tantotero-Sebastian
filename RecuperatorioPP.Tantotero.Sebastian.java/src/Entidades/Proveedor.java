package Entidades;

public class Proveedor {

    private String nombre;
    private String ciudad;
    private int antiguedad;

    public Proveedor(String nombre, String ciudad, int antiguedad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.antiguedad = antiguedad;
    }

    public static boolean sonIguales(Proveedor p1, Proveedor p2) {

        return p1.nombre.equals(p2.nombre)
                && p1.ciudad.equals(p2.ciudad)
                && p1.antiguedad == p2.antiguedad;
    }

    private String getInfoProveedor() {

        return nombre + " - "
                + ciudad + " - "
                + antiguedad;
    }

    @Override
    public String toString() {
        return getInfoProveedor();
    }

    public String getNombre() {
        return nombre;
    }

}