package Entidades;

public class Hamburguesa extends Producto implements IVendible {

    private TipoHamburguesa tipoHamburguesa;
    private TamanioHamburguesa tamanio;

    public Hamburguesa(String codigoProducto,
            String nombre,
            double precio,
            Proveedor proveedor,
            TipoHamburguesa tipoHamburguesa,
            TamanioHamburguesa tamanio) {

        super(codigoProducto, nombre, precio, proveedor);

        this.tipoHamburguesa = tipoHamburguesa;
        this.tamanio = tamanio;
    }

    @Override
    public double getPrecioTotal() {

        switch (tamanio) {

            case CHICA:
                return precio * 1.05;

            case MEDIANA:
                return precio * 1.10;

            default:
                return precio * 1.20;
        }
    }

    @Override
    public String toString() {

        return super.toString()
                + " - "
                + tipoHamburguesa
                + " - "
                + tamanio
                + " - Total: $"
                + getPrecioTotal();
    }

    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        Hamburguesa otra = (Hamburguesa) obj;

        return tipoHamburguesa == otra.tipoHamburguesa
                && tamanio == otra.tamanio;
    }

}
