package pre_entrega_Rabinovich_JAVA;

public class ArticuloPedido extends Articulo implements Vendible{

    private int cantidad;

    ArticuloPedido(int id, String nombre, double precio, int cantidad) {
        super(id, nombre, precio);
        setCantidad(cantidad);
    }
    
    private void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }


    

    @Override
    public String toString(){
        return "[ id: " + getId() + " - nombre: " + getNombre() + " - precio por unidad: " + getPrecio() + " cantidad: " + cantidad +  " ]";
    }

    @Override
    public double calcularPrecio(){
        return getPrecio() * cantidad ;
    }
}
