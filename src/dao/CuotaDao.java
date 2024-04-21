package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Cuota;
import datos.Prestamo;

public class CuotaDao {
    private static Session session;
    private Transaction tx;

    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }

    public int agregar(Cuota objeto) {
        int id = 0;
        try {
            iniciaOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
        return id;
    }

    public Cuota traer(long idCuota) {
        Cuota objeto = null;
        try {
            iniciaOperacion();
            objeto = (Cuota) session.get(Cuota.class, idCuota);
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Cuota> traer(Prestamo p) {
        List<Cuota> lista = null;
        try {
            iniciaOperacion();
            String hQL = "from Cuota c inner join fetch c.prestamo p where p.idPrestamo=:idPrestamo order by c.nroCuota asc";
            lista = session.createQuery(hQL, Cuota.class).setParameter("idPrestamo",
                    p.getIdPrestamo()).getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public void actualizar(Cuota objeto) {
        try {
            iniciaOperacion();
            session.update(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void eliminar(Cuota objeto) {
        try {
            iniciaOperacion();
            session.delete(objeto);
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            session.close();
        }
    }
}