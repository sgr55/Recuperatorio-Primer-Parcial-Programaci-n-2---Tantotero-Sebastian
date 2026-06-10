package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Hamburgueseria implements Iterable<Producto> {

    private String nombre;
    private int capacidad;
    private ArrayList<Producto> productos;

    public Hamburgueseria(String nombre) {
        this(nombre, 3);
    }

    public Hamburgueseria(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    private boolean sonIguales(Producto producto) {
        return productos.contains(producto);
    }

    public void agregar(Producto producto) {

        if (productos.size() >= capacidad) {
            System.out.println("Sin capacidad");
            return;
        }

        if (sonIguales(producto)) {
            System.out.println("Producto repetido");
            return;
        }

        productos.add(producto);
    }

    private double getPrecioDeHamburguesas() {

        double total = 0;

        for (Producto producto : productos) {

            if (producto instanceof Hamburguesa) {
                total += ((Hamburguesa) producto).getPrecioTotal();
            }
        }

        return total;
    }

    private double getPrecioDePapas() {

        double total = 0;

        for (Producto producto : productos) {

            if (producto instanceof PapasFritas) {
                total += ((PapasFritas) producto).getPrecioTotal();
            }
        }

        return total;
    }

    private double getPrecioProductos(TipoProducto tipo) {

        switch (tipo) {

            case HAMBURGUESAS:
                return getPrecioDeHamburguesas();

            case PAPAS:
                return getPrecioDePapas();

            default:
                return getPrecioTotal();
        }
    }

    private double getPrecioTotal() {

        double total = 0;

        for (Producto producto : productos) {
            total += ((IVendible) producto).getPrecioTotal();
        }

        return total;
    }

    public Producto getProductoMasCaro() {

        if (productos.isEmpty()) {
            return null;
        }

        Producto masCaro = productos.get(0);

        for (Producto producto : productos) {

            if (((IVendible) producto).getPrecioTotal()
                    > ((IVendible) masCaro).getPrecioTotal()) {

                masCaro = producto;
            }
        }

        return masCaro;
    }

    @Override
    public Iterator<Producto> iterator() {
        return productos.iterator();
    }

    @Override
    public String toString() {

        String salida = "";

        salida += "Hamburgueseria: " + nombre + "\n";
        salida += "Capacidad: " + capacidad + "\n";
        salida += "Cantidad: " + productos.size() + "\n\n";

        for (Producto producto : productos) {
            salida += producto + "\n";
        }

        salida += "\nTotal Hamburguesas: "
                + getPrecioProductos(TipoProducto.HAMBURGUESAS);

        salida += "\nTotal Papas: "
                + getPrecioProductos(TipoProducto.PAPAS);

        salida += "\nTotal General: "
                + getPrecioProductos(TipoProducto.AMBAS);

        return salida;
    }
}
