package negocio;

import dao.PrestamoDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;

public class PrestamoABM {
    private PrestamoDao dao = new PrestamoDao();

    public Prestamo traerPrestamo(long idPrestamo) {
        return dao.traer(idPrestamo);
    }

    public List<Prestamo> traerPrestamo(Cliente c) {
        return dao.traer(c);
    }

    public int agregar(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception{
        // Pendiente implementar lógica de negocio
        // Preguntar si la logica de negocio esta bien implementada
        if(cantCuotas < 2){
            throw new Exception("No se puede agregar el prestamo con solo una cuota");
        }
        Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, cliente);

        Cuota cuotaParaAgregar;
        List<Cuota> cuotas = new ArrayList<Cuota>();

        for(int i = 0; i < cantCuotas; i++){
            cuotaParaAgregar = new Cuota();
            int nroCuota = i + 1;
            double saldoPendiente;
            
            if(i == 0){
                saldoPendiente = monto;
            }
            else{
                saldoPendiente = cuotas.get(i - 1).getSaldoPendiente();
            }
            double amortizacion = (saldoPendiente * interes) / (Math.pow((1 + interes), cantCuotas - i) - 1);
            double interesCuota = saldoPendiente * interes;
            double cuota = amortizacion + interesCuota;
            double deuda = saldoPendiente - amortizacion;
            saldoPendiente = saldoPendiente - amortizacion;
            LocalDate fechaDeVencimiento = fecha.plusMonths(nroCuota);
            cuotaParaAgregar = new Cuota(nroCuota, fechaDeVencimiento, saldoPendiente, amortizacion, interesCuota, cuota, deuda, p);
            cuotas.add(cuotaParaAgregar);
        }
        Set<Cuota> setCuotas = new HashSet<Cuota>(cuotas);
        p.setCuotas(setCuotas);
        return dao.agregar(p);
    }

    public void modificarPrestamo(Prestamo p) {
        // Pendiente implementar lógica de negocio
        dao.actualizar(p);
    }
}
