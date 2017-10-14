package py.com.ffcc.jee.example.service;

import py.com.ffcc.jee.example.model.Venta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class VentaService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Venta> listar() {
        return entityManager.createQuery("SELECT v FROM Venta v").getResultList();
    }

    public Venta crear(Venta venta) {
        venta.setFechaCreacion(new Date());
        entityManager.persist(venta);
        return venta;
    }
}
