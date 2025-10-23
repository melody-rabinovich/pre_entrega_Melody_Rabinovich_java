package pre_entrega_Rabinovich_JAVA;

public class Articulo{
    private int id;
    private String nombre;
    private double precio;

    Articulo(int id, String nombre, double precio){
        setId(id); 
        setNombre(nombre);
        setPrecio(precio);
    }

    
    private void setId(int id) {
        this.id = id;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }

    public void actualizar(String nombre, double precio) {
        setNombre(nombre);
        setPrecio(precio);
    }

    @Override
    public String toString(){
        return "[ id: " + id + " - nombre: " + nombre + " - precio: " + precio + " ]";
    }


    
    
}
