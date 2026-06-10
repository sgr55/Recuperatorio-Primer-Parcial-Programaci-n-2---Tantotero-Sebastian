package Entidades;

import java.util.Random;

public abstract class Producto {

    protected Proveedor proveedor;
    protected String codigoProducto;
    protected String nombre;
    protected double precio;
    protected int calorias;
    protected int tiempoPreparacion;

    protected static Random generadorAleatorio;

    static {
        generadorAleatorio = new Random();
    }

    public Producto(String codigoProducto,
            String nombre,
            double precio,
            Proveedor proveedor) {

        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    public Producto(String codigoProducto,
            String nombre,
            double precio,
            String nombreProveedor,
            String ciudadProveedor,
            int antiguedadProveedor) {

        this(codigoProducto,
                nombre,
                precio,
                new Proveedor(
                        nombreProveedor,
                        ciudadProveedor,
                        antiguedadProveedor));
    }

    public int getCalorias() {

        if (calorias == 0) {
            calorias = generadorAleatorio.nextInt(601) + 200;
        }

        return calorias;
    }

    public int getTiempoPreparacion() {

        if (tiempoPreparacion == 0) {
            tiempoPreparacion = generadorAleatorio.nextInt(19) + 2;
        }

        return tiempoPreparacion;
    }

    private static String mostrar(Producto producto) {

        return producto.codigoProducto
                + " - "
                + producto.nombre
                + " - $"
                + producto.precio
                + " - "
                + producto.proveedor
                + " - Calorias: "
                + producto.getCalorias()
                + " - Tiempo: "
                + producto.getTiempoPreparacion();
    }

    private static boolean sonIguales(Producto p1, Producto p2) {

        return p1.codigoProducto.equals(p2.codigoProducto)
                && Proveedor.sonIguales(
                        p1.proveedor,
                        p2.proveedor);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Producto)) {
            return false;
        }

        Producto otro = (Producto) obj;

        return Producto.sonIguales(this, otro);
    }

    @Override
    public String toString() {
        return Producto.mostrar(this);
    }

}
