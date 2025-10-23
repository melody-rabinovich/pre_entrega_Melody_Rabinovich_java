package pre_entrega_Rabinovich_JAVA;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private Cliente cliente;
    private ArrayList<ArticuloPedido> articulosPedidos;

    public Pedido(int id, ArrayList<ArticuloPedido> articulosPedidos, Cliente cliente){ // la lista de artículos ya viene hecha
        setId(id);
        setCliente(cliente);
        setArticulosPedidos(articulosPedidos);
    }

    public Pedido(int id){
        setId(id);
        setArticulosPedidos();
    }


    private double calcularTotal(){
        double total = 0;
        for (ArticuloPedido articuloPedido : articulosPedidos) {
            total += articuloPedido.calcularPrecio();
        }

        return total;
    }

    public void mostrarse(){
        System.out.println("PEDIDO: " + id);
        System.out.println("Cliente: ");
        System.out.println(cliente.getNombre() + " - " + cliente.getEmail());
        System.out.println("-----------------------------------------------------");
        for (ArticuloPedido articuloPedido : articulosPedidos) {
            System.out.println(articuloPedido.toString());
        }
        System.out.println(" ");
        System.out.println("total: - - - - - - - - - - - - - - " + calcularTotal());
    }







// ------ getters y setters ----
    private void setId(int id) {
        this.id = id;
    }
    
    private void setArticulosPedidos(ArrayList<ArticuloPedido> articulosPedidos) {
       this.articulosPedidos = articulosPedidos;
    }

    private void setArticulosPedidos(){
         this.articulosPedidos = new ArrayList<>();
    }

    public int getId(){
        return id;
    }


    private void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return cliente;
    }

}
