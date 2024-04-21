package test;

import java.util.List;

import datos.Prestamo;
import datos.Cuota;
import negocio.CuotaABM;
import negocio.PrestamoABM;

public class TestTraerCuota {
    public static void main(String[] args) {
        CuotaABM abm = new CuotaABM();
        PrestamoABM prestamoABM = new PrestamoABM();
        long idPrestamo = 20;
        Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
        List<Cuota> cuotas = abm.traerCuota(p);

        for (Cuota cuota : cuotas) {
            System.out.printf("Cuota: %s\n", cuota);
        }
    }
}
