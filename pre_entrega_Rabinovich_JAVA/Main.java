package pre_entrega_Rabinovich_JAVA;

import java.util.Scanner;
 import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        
        Negocio negocio = new Negocio();
        Empleado empleado = new Empleado("Fernanda", "12345678", "ABC123", negocio);
        

        int linea;

        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("=============================");
            System.out.println("1) Operaciones de artículos");
            System.out.println("2) Operaciones de clientes");
            System.out.println("3) Operaciones de pedidos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            linea = sc.nextInt();
            sc.nextLine();

            

            switch (linea) {
                case 1 -> {
                    int opcion;
                    do {
                        empleado.mostrarMenuArticulos();
                        opcion = sc.nextInt();
                        sc.nextLine();
                        switch (opcion) {
                            case 1 :{
                                System.out.println("1) Listar artículos"); 
                                System.out.println("===================");
                                empleado.listarArticulos();

                                break;
                            }  

                            case 2 : { 
                                System.out.println("2) Buscar artículo por nombre");
                                System.out.println("==============================");
                                System.out.println("Ingrese el nombre del artículo");
                                String nombreArticulo = sc.nextLine();

                                Articulo articulo = empleado.buscarArticulo(nombreArticulo);
                                if(articulo != null){
                                    System.out.println("Artículo encontrado: ");
                                    System.out.println(articulo);
                                } else {
                                    System.out.println("No se encontró un artículo con ese nombre");
                                }
                                
                                break;
                            }

                            case 3 : {
                                System.out.println("3) Buscar artículo por id");
                                System.out.println("==============================");
                                System.out.println("Ingrese el id del artículo");
                                int idArticulo = sc.nextInt();
                                sc.nextLine();

                                Articulo articulo = empleado.buscarArticulo(idArticulo);
                                if(articulo != null){
                                    System.out.println("Artículo encontrado: ");
                                    System.out.println(articulo.toString());
                                } else {
                                    System.out.println("no se encontró un artículo con ese id");
                                }

                                
                                break;
                            }

                            case 4 : {
                                System.out.println("4) Crear artículo");
                                System.out.println("==================");
                                System.out.println("ingrese el nombre del nuevo artículo");
                                String nombreArticulo = sc.nextLine();
                                System.out.println("ingrese el precio del nuevo artículo");
                                double precioArticulo = sc.nextDouble();
                                sc.nextLine();

                                Articulo nuevoArticulo = empleado.crearArticulo(nombreArticulo, precioArticulo);
                                if(nuevoArticulo != null){
                                    System.out.println("Artículo creado:");
                                    System.out.println(nuevoArticulo.toString());
                                } else{
                                    System.out.println("Datos invalidos. No se pudo crear el nuevo producto");
                                }

                                break;
                            }

                            case 5 : {
                                System.out.println("4) Eliminar artículo");
                                System.out.println("=====================");
                                System.out.println("Ingrese el id del artículo");
                                int idArticulo = sc.nextInt();
                                sc.nextLine();

                                Articulo articulo = empleado.eliminarArticulo(idArticulo);
                                if(articulo != null){
                                    System.out.println("Artículo eliminado: ");
                                    System.out.println(articulo.toString());
                                }else{
                                    System.out.println("Datos invalidos. No se pudo eliminar el producto");
                                }


                                break;
                            }

                            case 6 : {
                                System.out.println("4) Modificar artículo");
                                System.out.println("======================");
                                System.out.println("podrá modificar el nombre y/o el precio del artículo");
                                
                                System.out.println("ingrese el id del artículo que desea modificar");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.println("ingrese el nuevo nombre");
                                String nuevoNombre = sc.nextLine();
                                System.out.println("ingrese el nuevo precio");
                                double nuevoPrecio = sc.nextDouble();
                                sc.nextLine();

                                Articulo articulo = empleado.modificarArticulo(id, nuevoNombre, nuevoPrecio);
                                if(articulo != null){
                                    System.out.println("Artículo modificado: ");
                                    System.out.println(articulo.toString());
                                } else{
                                    System.out.println("Datos inválidos. No se pudo modificar el artículo");
                                }


                                break;

                            }


                            case 0 : System.out.println("Volviendo al menú principal...");
                            default : System.out.println("Opción inválida");
                        }
                    } while (opcion != 0);

                    break;
                }
                case 2 -> {
                    int opcion;
                    do {
                        empleado.mostrarMenuClientes();
                        opcion = sc.nextInt();
                        sc.nextLine();

                        switch (opcion) {
                            case 1: {
                                System.out.println("1) Listar clientes"); 
                                System.out.println("===================");
                                empleado.listarClientes();

                                break;
                            }

                            case 2: {
                                System.out.println("2) Buscar cliente por dni");
                                System.out.println("==========================");
                                System.out.println("ingrese el dni del cliente");
                                String dni = sc.nextLine();
                                
                                Cliente cliente = empleado.buscarCliente(dni);
                                if(cliente != null){
                                    System.out.println("Cliente encontrado:");
                                    System.out.println(cliente.toString());
                                } else {
                                    System.out.println("No se ha encontrado un cliente con ese dni");
                                }


                                break;
                            }

                            case 3 : {
                                System.out.println("3) Crear cliente");
                                System.out.println( "================");

                                System.out.println("ingrese el dni del cliente");
                                String dni = sc.nextLine();
                                if(empleado.buscarCliente(dni) != null){
                                    System.out.println("El cliente ya está agendado");
                                    break;
                                }

                                System.out.println("Ingrese el nombre del cliente");
                                String nombre = sc.nextLine();
                                System.out.println("ingrese el email del cliente");
                                String email = sc.nextLine();
                                System.out.println("ingrese el numero de tarjeta asociado al cliente");
                                String tarjeta = sc.nextLine();

                                Cliente cliente = empleado.crearCliente(nombre, dni, email, tarjeta);
                                if(cliente != null){
                                    System.out.println("Ciente creado:");
                                    System.out.println(cliente.toString());

                                } else {
                                    System.out.println("Datos invalidos, no se ha podido crear el cliente");
                                }
                                
                                break;
                            }

                            case 4 : {
                                System.out.println("4) Eliminar cliente");
                                System.out.println("=====================");
                                System.out.println("ingrese el dni del cliente que desea eliminar");
                                String dni = sc.nextLine();
                                Cliente cliente = empleado.eliminarCliente(dni);
                                if(cliente != null){
                                    System.out.println("Cliente eliminado: ");
                                    System.out.println(cliente.toString());
                                } else{
                                    System.out.println("No se encontró un cliente con ese dni. Error al eliminar.");
                                }

                                break;
                            }

                            case 5: {
                                System.out.println("5) Modificar cliente");
                                System.out.println("=====================");

                                System.out.println("ingrese el dni del cliente que desea modificar");
                                String dni = sc.nextLine();
                                if(empleado.buscarCliente(dni) == null){
                                    System.out.println("No se encontró un cliente con ese dni");
                                    break;
                                }

                                System.out.println("ingrese el nuevo nombre");
                                String nuevoNombre = sc.nextLine();
                                System.out.println("ingrese el nuevo email");
                                String nuevoEmail = sc.nextLine();
                                System.out.println("Ingrese la nueva tarjeta asociada");
                                String nuevaTarjeta = sc.nextLine();
                                
                                Cliente cliente = empleado.modificarCliente(dni, nuevoNombre, nuevoEmail, nuevaTarjeta);
                                if(cliente != null){
                                    System.out.println("Ciente modificado: ");
                                    System.out.println(cliente.toString());

                                }else{
                                    System.out.println("Error. No se pudo modificar el cliente");
                                }


                                break;

                            }
                                
                                
                        }

                        
                        
                    } while (opcion != 0);
                    break;
                }

            
                case 3 -> {

                    int opcion;
                    do{
                        empleado.mostrarMenuPedidos();
                        opcion = sc.nextInt();
                        sc.nextLine();

                        switch (opcion) {
                            case 1:{
                                System.out.println("1) Listar Pedidos");
                                System.out.println("==================");
                                empleado.listarPedidos();
                                break;
                            }

                            case 2: {
                                System.out.println("2) Buscar Pedido por ID");
                                System.out.println("=========================");
                                System.out.println("ingrese el id del pedido que desea buscar");
                                int id = sc.nextInt();
                                sc.nextLine();

                                Pedido buscado = empleado.buscarPedido(id);
                                if(buscado != null){
                                    System.out.println("Pedido encontrado: ");
                                    buscado.mostrarse();
                                } else {
                                    System.out.println("No se encontró un pedido con ese id");
                                }

                                break;
                            }


                            case 3 : {
                                System.out.println("3) Crear pedido");
                                System.out.println("=================");
                                System.out.println("Ingrese el dni del cliente. El cliente debe estar registrado");
                                String dni = sc.nextLine();

                                Cliente cliente;

                                if(dni != " "){
                                    dni.trim();
                                    cliente = empleado.buscarCliente(dni);
                                    if (cliente == null){
                                        System.out.println("El cliente no está registrado");
                                        break;

                                    } 
                                } else{
                                    System.out.println("Dni invalido");
                                    break;
                                }

                                int opcionArticulos;
                                ArrayList<ArticuloPedido> articulosPedidos = new ArrayList<>();
                                do{
                                    System.out.println("Agregar un artículo");
                                    System.out.println("0) No.");
                                    System.out.println("1) Si.");
                                    opcionArticulos = sc.nextInt();
                                    sc.nextLine();

                                    
                                    switch (opcionArticulos) {
                                        case 1:{
                                            
                                            System.out.println("Ingrese el nombre del artículo");
                                            String nombreArticulo = sc.nextLine();
                                            Articulo encontrado = empleado.buscarArticulo(nombreArticulo);
                                            if(encontrado == null){
                                                System.out.println("Artículo no encontrado");
                                                break;
                                            }

                                            System.out.println("ingrese la cantidad deseada");
                                            int cantidad = sc.nextInt();
                                            sc.nextLine();

                                            if( cantidad <= 0){
                                                System.out.println("cantidad inválida");
                                                break;
                                            }

                                            ArticuloPedido nuevoArticulo = new ArticuloPedido(encontrado.getId(), encontrado.getNombre(), encontrado.getPrecio(), cantidad);
                                            Articulo agregado = empleado.agregarArticuloParaPedido(articulosPedidos, nuevoArticulo, cliente);
                                            System.out.println("Artículo agregado al pedido:");
                                            System.out.println(agregado.toString());
                                           
                                            break;
                                        }
                                            
                                        case 0 : {
                                            System.out.println("Volviendo para finalizar el pedido");
                                            break;
                                        }
                                    
                                        
                                    }


                                }while(opcionArticulos != 0);

                                Pedido pedidoCreado = empleado.crearPedido(articulosPedidos, cliente);
                                if(pedidoCreado != null){
                                    System.out.println("Pedido creado:");
                                    pedidoCreado.mostrarse();
                                } else{
                                    System.out.println("No se pudo crear el pedido");
                                }
                                


                                break;
                            }
                                
                            case 4 : {
                                System.out.println("4) Eliminar pedido");
                                System.out.println("==================");
                                System.out.println("Ingrese el ID del pedido que desea eliminar");
                                int idPedido = sc.nextInt();
                                sc.nextLine();

                                Pedido pedido = empleado.eliminarPedido(idPedido);
                                if(pedido != null){
                                    System.out.println("Pedido eliminado: ");
                                    pedido.mostrarse();
                                } else{
                                    System.out.println("No se pudo eliminar el pedido");
                                }

                                break;
                            }
                        
                           
                            
                            
                            
                            case 0 : System.out.println("Volviendo al menú principal...");
                            default : System.out.println("Opción inválida");
                        }

                    } while(opcion != 0);
                }

                
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida");
            } 
          
        }while (linea != 0);


        
        sc.close();
    };
}
