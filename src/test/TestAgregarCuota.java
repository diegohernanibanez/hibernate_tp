package test;

import java.time.LocalDate;

import datos.Prestamo;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class TestAgregarCuota {
    public static void main(String[] args) {
        PrestamoABM prestamoAbm = new PrestamoABM();
        long idPrestamo = 2;
        Prestamo prestamo = prestamoAbm.traerPrestamo(idPrestamo);
        LocalDate fechaVencimiento = LocalDate.of(2024, 10, 15);
        CuotaABM abm = new CuotaABM();
        long ultimoIdCuota = abm.agregar(3, fechaVencimiento, 6000, 600, 26, 1, 6000, prestamo);
        System.out.printf("Id cuota: %d", ultimoIdCuota);
    }
}
