package pre_entrega_Rabinovich_JAVA;
import java.util.ArrayList;

import pre_entrega_Rabinovich_JAVA.Cliente;


public class Empleado extends Persona {
    private String legajo;
    private Negocio negocioDeTrabajo;

    public Empleado(String nombre, String dni, String legajo, Negocio negocioDeTrabajo) {
        super(nombre, dni);
        setLegajo(legajo);
        setNegocioDeTrabajo(negocioDeTrabajo);
    }

    public Empleado (String nombre, String dni, String legajo){
        super(nombre, dni);
        setNegocioDeTrabajo();

    }

// ---- CRUD ARTÍCULOS --------------------------------------------------------------
    public void mostrarMenuArticulos(){

        System.out.println(" ========================================= ");
        System.out.println("============  MENÚ DE ARTICULOS  ==========");
        System.out.println(" ===========================================");
        System.out.println("1) Listar artículos");
        System.out.println("2) Buscar artículo por nombre");
        System.out.println("3) Buscar artículo por id");
        System.out.println("4) Crear artículo");
        System.out.println("5) Eliminar artículo");
        System.out.println("6) Modificar artículo");
        System.out.println("0) Salir");
        System.out.println("Opción: ");
    }

    public void listarArticulos(){
        negocioDeTrabajo.listarArticulos();
    }

    public Articulo buscarArticulo(String nombre){
        return negocioDeTrabajo.buscarArticulo(nombre.trim().toLowerCase());
    }

    public Articulo buscarArticulo(int id){
        return negocioDeTrabajo.buscarArticulo(id);
    }

    public Articulo crearArticulo(String nombre, double precio){
        // no pide el id porque está automatizado
        Articulo creado = null;
        if(nombre != "" && precio > 0){
            nombre.trim().toLowerCase();
            creado = negocioDeTrabajo.crearArticulo(nombre, precio);
        }
        return creado;
    }

    public Articulo eliminarArticulo(int id){
        Articulo eliminado = null;
        if(id > 0){
            if(buscarArticulo(id) != null){
                eliminado = negocioDeTrabajo.eliminarArticulo(id);
            }
        }
        return eliminado;
    }

    public Articulo modificarArticulo(int id, String nuevoNombre, double nuevoPrecio){
        Articulo modificado = null;
        if(id >= 0 && nuevoNombre != "" && nuevoPrecio > 0){
            modificado = negocioDeTrabajo.modificarArticulo(id, nuevoNombre.trim().toLowerCase(), nuevoPrecio);
        }
        return modificado;
    }

    
// ---- CRUD CLIENTES --------------------------------------------------------------
    public void mostrarMenuClientes(){
        System.out.println(" ========================================= ");
        System.out.println("============  MENÚ DE CLIENTES  ==========");
        System.out.println(" ===========================================");
        System.out.println("1) Listar clientes");
        System.out.println("2) Buscar cliente por dni");
        System.out.println("3) Crear cliente");
        System.out.println("4) Eliminar cliente");
        System.out.println("5) Modificar cliente");
        System.out.println("0) Salir");
        System.out.println("Opción: ");
    }

    public void listarClientes(){
        negocioDeTrabajo.listarClientes();;
    }

    public Cliente buscarCliente(String dni){
        if (dni != null){
            dni.trim();
        }
        return negocioDeTrabajo.buscarCliente(dni);
    }

    public Cliente crearCliente(String nombre, String dni, String email, String tarjeta){
        Cliente creado = null;
        if (nombre != "" && dni != "" && email != "" && tarjeta != ""){
            nombre.trim().toLowerCase();
            dni.trim();
            email.trim().toLowerCase();
            tarjeta.trim();

            creado = negocioDeTrabajo.crearCliente(nombre, dni, email, tarjeta);
        }
        return creado;
    }

    public Cliente eliminarCliente(String dni){
        Cliente eliminado = null;
        if(dni != ""){
            if(buscarCliente(dni) != null){// le hace el trim() internamente
                eliminado = negocioDeTrabajo.eliminarCliente(dni);
            } 
        }

        return eliminado;
    }

    public Cliente modificarCliente(String dniBuscado, String nuevoNombre, String nuevoEmail, String nuevaTarjeta){
        Cliente modificado = null;
        if(dniBuscado != "" && nuevoNombre != "" && nuevoEmail != "" && nuevaTarjeta != "" ){
            modificado = negocioDeTrabajo.modificarCliente(nuevoNombre.trim().toLowerCase(), dniBuscado.trim(), nuevoEmail.trim().toLowerCase(), nuevaTarjeta.trim());
        }

        return modificado;
    }



// ---- CRUD PEDIDOS --------------------------------------------------------------
    public void mostrarMenuPedidos(){
        System.out.println(" ========================================= ");
        System.out.println("============  MENÚ DE PEDIDOS  ==========");
        System.out.println(" ===========================================");
        System.out.println("1) Listar pedidos");
        System.out.println("2) Buscar pedido por id");
        System.out.println("3) Crear pedido");
        System.out.println("4) Eliminar pedido");
        // System.out.println("5) Modificar pedido");
        System.out.println("0) Salir");
        System.out.println("Opción: ");
    }

    public void listarPedidos(){
        negocioDeTrabajo.listarPedidos();
    }

    public Pedido buscarPedido(int id){
        Pedido encontrado = null;
        if (id >= 0){
            encontrado = negocioDeTrabajo.buscarPedido(id);
        }
        return encontrado;
    }

    public ArticuloPedido agregarArticuloParaPedido(ArrayList<ArticuloPedido> articulosPedidos, ArticuloPedido articulo, Cliente cliente){
        // le llega la referencia a la lista, y se encarga de verificar que exista el artículo
        // la lista después se pasa para poder crear un pedido
        ArticuloPedido agregado = null;
        if(buscarArticulo(articulo.getId()) != null){
            articulosPedidos.add(articulo);
            agregado = articulo;
        }
        return agregado; // devuelvo el artículo y no la lista, para que desde afuera se pueda evaluar si se agregó o no. La referencia a la lista debería estar afuera
    }

    public Pedido crearPedido(ArrayList<ArticuloPedido> articulosPedidos, Cliente cliente){
        Pedido creado = null;
        if(articulosPedidos != null && articulosPedidos.size() > 0 && cliente != null){

            if(buscarCliente(cliente.getDni()) != null){
                 creado = negocioDeTrabajo.crearPedido(articulosPedidos, cliente);
            }
        }
        return creado;
    }


    public Pedido eliminarPedido(int id){
        Pedido eliminado = null;
        if(id >= 0){
            eliminado = negocioDeTrabajo.eliminarPedido(id);
        }
        return eliminado;
    }













// -------- Getters + Setters
    private void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    private void setNegocioDeTrabajo(Negocio negocioDeTrabajo) {
        this.negocioDeTrabajo = negocioDeTrabajo;
    }

    private void setNegocioDeTrabajo(){
        this.negocioDeTrabajo = new Negocio();
    }

    public String getLegajo() {
        return legajo;
    }

    public Negocio getNegocioDeTrabajo() {
        return negocioDeTrabajo;
    }
    
}
