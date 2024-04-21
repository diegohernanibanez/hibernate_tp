package test;

import datos.Prestamo;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public interface TestPagarCuota {
    public static void main(String[] args) {
        PrestamoABM prestamoAbm = new PrestamoABM();
        long idPrestamo = 20;
        Prestamo prestamo = prestamoAbm.traerPrestamo(idPrestamo);
        CuotaABM abm = new CuotaABM();
        try {
            abm.pagarCuota(prestamo);
        } catch (Exception e) {
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }
}
