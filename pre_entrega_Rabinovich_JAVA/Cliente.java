package pre_entrega_Rabinovich_JAVA;

public class Cliente extends Persona {
    private String email;
    private String tarjeta;

    public Cliente(String nombre, String dni, String email, String tarjeta) {
        super(nombre, dni);
        setEmail(email);
        setTarjeta(tarjeta);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getEmail() {
        return email;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void actualizar(String nombre, String email, String tarjeta) {
        setNombre(nombre);
        setEmail(email);
        setTarjeta(tarjeta);
    }

    @Override
    public String toString() {
        return "[nombre: " + getNombre() + " - DNI: " + getDni() + " - email: " + email + " - tarjeta: " + tarjeta + " ]";
    }

}
