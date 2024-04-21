package negocio;

import dao.CuotaDao;

import java.time.LocalDate;
import java.util.List;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
    private CuotaDao dao = new CuotaDao();

    public Cuota traerCuota(long idCuota) {
        return dao.traer(idCuota);
    }

    public List<Cuota> traerCuota(Prestamo p) {
        return dao.traer(p);
    }

    public int agregar(int nroCuota, LocalDate fechaVencimiento, double saldoPendiente, double amortizacion,
        double interesCuota, double cuota, double deuda, Prestamo prestamo){
        Cuota c = new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, deuda, prestamo);
        // Se deberia poder agregar cuotas?
        // Que logica deberia tener?
        return dao.agregar(c);
    }

    public void modificar(Cuota c) {
        dao.actualizar(c);
    }

    // La logica de pagar deberia estar en el ABM
    // Deberia tener un exception al hacer el get?
    public void pagarCuota(Prestamo p) throws Exception{
        List<Cuota> cuotas = traerCuota(p);
        Cuota c = new Cuota();
        for (Cuota cuota : cuotas) {
            if(!cuota.isCancelada()){
                c = cuota;
                break;
            }
        }
        
        LocalDate hoy = LocalDate.now();
        c.setCancelada(true);
        c.setFechaDePago(hoy);
        if(c.getFechaVencimiento().isBefore(hoy)){
            c.setPunitorios(0.02);
        }
        modificar(c);
    }
}
