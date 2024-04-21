package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
    public static void main(String[] args) {
        ClienteABM abm = new ClienteABM();
        // traer el obj a modificar
        // Nota: Se usa 'L' al final del número para especificar que de tipo long
        Cliente cliente = abm.traer(1L);
        System.out.printf("Cliente a Modificar: %s\n\n", cliente);
        // modificar por set los atributos
        // Nota: Esto no se hace desde el test, es a modo demostrativo.
        cliente.setDni(35000002);
        try{
            abm.modificar(cliente);
        }
        catch (Exception e){
            System.out.printf("Error: %s\n", e.getMessage());
        }
        // En este caso se usa el traer por int
        // ya que al no aclarar el tipo (como en el traer anterior) se asume que es int
        Cliente clienteMod = abm.traer(35000002);
        System.out.printf("Cliente Modificado: %s\n", clienteMod);
    }
}