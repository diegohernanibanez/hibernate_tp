package test;

import negocio.ClienteABM;
import datos.Cliente;

public class TestTraerClienteYPrestamos {
    public static void main(String[] args) {
        long idCliente = 1;
        ClienteABM cliAbm = new ClienteABM();
        Cliente cliente = cliAbm.traerClienteYPrestamos(idCliente);
        System.out.printf("Traer Cliente y Prestamos idCliente=%d\n", idCliente);
        System.out.printf("\n%s\n", cliente);
        System.out.printf("\n%s", cliente.getPrestamos());
    }
}
