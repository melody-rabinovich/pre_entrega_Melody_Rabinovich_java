package pre_entrega_Rabinovich_JAVA;


import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;


public class Negocio {
    private ArrayList<Articulo> articulos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;

    public Negocio(){
        inicializarArticulos(); // no necesito que venga por parámetro
        inicializarClientes();
        inicializarPedidos();
    }

// ---- CRUD ARTÍCULOS --------------------------------------------------------------
    public void listarArticulos(){
        System.out.println("LISTA DE ARTÍCULOS");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.toString());
        }
        System.out.println("--------------------------------------------------");
    }

    public Articulo buscarArticulo(String nombre){ // no deberían haber repetidos, pero ne caso de que los haya, devuelve el primero encontrado
        boolean encontrado = false;
        Articulo buscado = null;
        int i = 0;
        Articulo actual;
        while (!encontrado && i < articulos.size()){
            actual = articulos.get(i);
            if(actual.getNombre().equals(nombre)){
                buscado = actual;
            }
            i ++;
        }
        return buscado;
    }

    public Articulo buscarArticulo(int id){
        boolean encontrado = false;
        Articulo buscado = null;
        int i = 0;
        Articulo actual;
        while (!encontrado && i < articulos.size()){
            actual = articulos.get(i);
            if(actual.getId() == id){
                buscado = actual;
            }
            i ++;
        }
        return buscado;
    }

    public Articulo crearArticulo(String nombre, double precio ){
        // que se valide externamente si los campos están completos
        
        Articulo articuloNuevo = null;
        int id = ultimoIndex(articulos) + 1;
        if (buscarArticulo(nombre) == null){
            articuloNuevo = new Articulo(id, nombre, precio);
            articulos.add(articuloNuevo);
        } 

        return articuloNuevo;
    }
    
    public Articulo eliminarArticulo (int id){
        Articulo buscado = buscarArticulo(id);
        Articulo eliminado = null;
        
        if(buscado != null){
            articulos.remove(buscado);
            eliminado = buscado;
        }

        return eliminado;
    } 

    public Articulo modificarArticulo(int id, String nuevoNombre, double nuevoPrecio){
        Articulo articuloModificado = null;
        Articulo encontrado = buscarArticulo(id);
        if( encontrado != null){
            encontrado.actualizar(nuevoNombre, nuevoPrecio);
            articuloModificado = encontrado;
        }
        return articuloModificado;
    }



//------- CRUD CLIENTES ----------------
    public void listarClientes(){
        System.out.println("LISTA DE CLIENTES");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
        System.out.println("--------------------------------------------------");
    }

    public Cliente buscarCliente(String dni){
        Cliente encontrado = null;
        Cliente actual;
        int i = 0;
        while (encontrado == null && i < clientes.size()){
            actual = clientes.get(i);
            if(actual.getDni().equals(dni)){
                encontrado = actual;
            }
            i ++;
        }
        return encontrado;
    }

    public Cliente crearCliente(String nombre, String dni, String email, String tarjeta){
        Cliente nuevoCliente = null;
        if (buscarCliente(dni) == null){
            nuevoCliente = new Cliente(nombre, dni, email, tarjeta);
            clientes.add(nuevoCliente);
        }

        return nuevoCliente;
    }

    public Cliente eliminarCliente(String dni){
        Cliente buscado = buscarCliente(dni);
        Cliente eliminado = null;

        if( buscado != null){
            clientes.remove(buscado);
            eliminado = buscado;
        }

        return eliminado;
    }
    
    public Cliente modificarCliente(String nombre, String dni, String email, String tarjeta){
        Cliente clienteModificado = null;
        Cliente encontrado = buscarCliente(dni);

        if( encontrado != null){
            encontrado.actualizar(nombre, email, tarjeta);
            clienteModificado = encontrado;
        }

        return clienteModificado;
    }


// ---- CRUD PEDIDOS --------------------------------------------------------------
    public void listarPedidos(){
        System.out.println("LISTA DE PEDIDOS");
        for (Pedido pedido : pedidos) {
            pedido.mostrarse();
        }
    }

    public Pedido buscarPedido(int id){
        Pedido encontrado = null;
        Pedido actual;
        int i = 0;
        while(encontrado == null && i < pedidos.size()){
            actual = pedidos.get(i);
            if (actual.getId() == id){
                encontrado = actual;
            }
            i ++;
        }
        return encontrado;
    }

    public Pedido crearPedido(ArrayList<ArticuloPedido> articuloPedidos, Cliente cliente){
        // la lista de artículos la tiene que generar el empleado
        Pedido creado = null;
        int id = ultimoIndex(pedidos) + 1;
        if (buscarPedido(id) == null){ // no hace falta en realidad
            creado = new Pedido(id, articuloPedidos, cliente);
            pedidos.add(creado);
        }
        return creado;

    }

    public Pedido eliminarPedido(int id){
        Pedido buscado = buscarPedido(id);
        Pedido eliminado = null;
        if(buscado != null){
            pedidos.remove(buscado);
            eliminado = buscado;
        }

        return eliminado;
    }



// --------------------------------------------------------------------------
    private <T> int ultimoIndex(ArrayList<T> arrayList){
        return arrayList.size() - 1;
    }
// --------------------------------------------------------------------------


// -------- Getters + Setters
    private void inicializarArticulos() {
        articulos = new ArrayList<>() ;
        articulos.add(new Articulo(0, "manzana", 300));
        articulos.add(new Articulo(1, "naranja", 400));
    }

    // no querría que todos tengan acceso a mis artículos
    // public ArrayList<Articulo> getArticulos() { // devuelve un nuevo array copiado del original
    //     return new ArrayList<>(articulos);
    // }

    private void inicializarPedidos(){
        pedidos = new ArrayList<>();

    }

    private void inicializarClientes(){
        clientes = new ArrayList<>();
        clientes.add(new Cliente ("carlos", "87654321", "carlos@gmail.com", "1234567890"));

    }

    public ArrayList<Pedido> getPedidos(){
        return new ArrayList<>(pedidos);
    }
    
}
