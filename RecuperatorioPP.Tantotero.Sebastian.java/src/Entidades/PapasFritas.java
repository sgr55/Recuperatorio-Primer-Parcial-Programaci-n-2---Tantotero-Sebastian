package Entidades;

public class PapasFritas extends Producto implements IVendible {

    private TipoPapas tipoPapas;

    public PapasFritas(String codigoProducto,
            String nombre,
            double precio,
            Proveedor proveedor,
            TipoPapas tipoPapas) {

        super(codigoProducto, nombre, precio, proveedor);

        this.tipoPapas = tipoPapas;
    }

    @Override
    public double getPrecioTotal() {

        switch (tipoPapas) {

            case CLASICAS:
                return precio * 1.10;

            case CON_CHEDDAR:
                return precio * 1.15;

            default:
                return precio * 1.20;
        }
    }

    @Override
    public String toString() {

        return super.toString()
                + " - "
                + tipoPapas
                + " - Total: $"
                + getPrecioTotal();
    }

    @Override
    public boolean equals(Object obj) {

        if (!super.equals(obj)) {
            return false;
        }

        PapasFritas otra = (PapasFritas) obj;

        return tipoPapas == otra.tipoPapas;
    }

}
