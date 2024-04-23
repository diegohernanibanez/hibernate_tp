package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
    ClienteDao dao = new ClienteDao();

    public Cliente traer(long idCliente) {
        return dao.traer(idCliente);
    }

    public Cliente traer(int dni) {
        return dao.traer(dni);
    }

    public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
        Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
        Cliente clienteExistente = dao.traer(dni);
        if (clienteExistente != null) {
            throw new Exception("Ya existe un cliente con el mismo DNI");
        }
        return dao.agregar(c);
    }

    public void modificar(Cliente c) throws Exception{
        Cliente clienteExistente = dao.traer(c.getDni());
        if (clienteExistente != null) {
            throw new Exception("Ya existe un cliente con el mismo DNI");
        }
        dao.actualizar(c);
    }

    public void eliminar(long idCliente) throws Exception{
        Cliente c = dao.traer(idCliente);
        if (c == null) {
            throw new Exception("No existe el cliente que desea eliminar");
        }
        dao.eliminar(c);
    }

    public List<Cliente> traer() {
        return dao.traer();
    }

    public Cliente traerClienteYPrestamos(long idCliente) {
        return dao.traerClienteYPrestamos(idCliente);
    }

}