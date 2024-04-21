package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {
    public static void main(String[] args) {
        ClienteABM abm = new ClienteABM();
        long id = 999;
        Cliente cliente = abm.traer(id);
        System.out.printf("Cliente a eliminar: %s\n", cliente);
        try{
            abm.eliminar(id);
        }
        catch(Exception e){
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }
}
