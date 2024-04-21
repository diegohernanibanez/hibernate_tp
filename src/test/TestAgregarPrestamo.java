package test;

import java.time.LocalDate;

import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {
    public static void main(String[] args) {
        ClienteABM abmCliente = new ClienteABM();
        PrestamoABM abmPrestamo = new PrestamoABM();

        Cliente cliente = abmCliente.traer(2l);
        System.out.printf("\n Cliente traido :%s\n", cliente);

        try {
            int idPrestamo = abmPrestamo.agregar(LocalDate.now(), 100000, 0.1, 12, cliente);
            Prestamo prestamo = abmPrestamo.traerPrestamo(idPrestamo);
            System.out.printf("\n Prestamo creado :%s\n", prestamo);

        } catch (Exception e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }

    }
}
