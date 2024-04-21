package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
    public static void main(String[] args) {
        PrestamoABM prestamoABM = new PrestamoABM();
        long idPrestamo = 1;
        System.out.printf("TraerPrestamo idPrestamo=%d\n", idPrestamo);
        Prestamo prestamo = prestamoABM.traerPrestamo(idPrestamo);
        System.out.printf("\n%s pertenece a %s\n", prestamo, prestamo.getCliente());
        ClienteABM clienteABM = new ClienteABM();
        int dni = 14000000;
        Cliente cliente = clienteABM.traer(dni);
        System.out.printf("\nTraerPrestamos del Cliente=%s\n", cliente);
        List<Prestamo> prestamos = prestamoABM.traerPrestamo(cliente);
        for (Prestamo p : prestamos)
            System.out.printf("\n%sPertenece a %s\n", p, p.getCliente());
    }
}
