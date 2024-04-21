package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
    ContactoDao dao = new ContactoDao();

    public Contacto traer(long idContacto) {
        Contacto c = dao.traer(idContacto);
        return c;
    }

    public int agregar(String email, String movil, String fijo, Cliente cliente) throws Exception{
        // Lanzar excepción si el cliente ya tiene un contacto
        Contacto c = new Contacto(email, movil, fijo, cliente);
        Contacto contactoExistente = dao.traer(cliente.getIdCliente());
        if (contactoExistente != null) {
            throw new Exception("Ya existe un contacto para este cliente");
        }
        return dao.agregar(c);
    }

    public void modificar(Contacto c) {
        dao.actualizar(c);
    }

    public void eliminar(long idContacto) throws Exception{
        Contacto c = dao.traer(idContacto);
        if (c == null) {
            throw new Exception("No existe el contacto que desea eliminar");
        }
        dao.eliminar(c);
    }
}
