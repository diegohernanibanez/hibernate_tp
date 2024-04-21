package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
    public static void main(String[] args) {
        ClienteABM abm = new ClienteABM();
        try{
            long ultimoIdCliente = abm.agregar("Ibañez", "Diego", 37829374, LocalDate.of(1994, 1, 16));
            System.out.printf("Id cliente: %d", ultimoIdCliente);

        }
        catch(Exception e){
            System.out.printf("Error: %s\n", e.getMessage());
        }
    }
}
