package pre_entrega_Rabinovich_JAVA;

public class Persona {
    private String nombre;
    private String dni;

    public Persona(String nombre, String dni){
        setNombre(nombre);
        setDni(dni);

    }

    protected void setNombre(String nombre){
        this.nombre = nombre;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    
    @Override
    public String toString() {
        return "[nombre: " + nombre + " - DNI: " + dni + " ]";
    }
}
