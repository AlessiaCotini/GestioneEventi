package alessiacotini.DAO;

import alessiacotini.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class EventiDao {
    private final EntityManager entityManager;

    public EventiDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento ev){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(ev);
        transazione.commit();
        System.out.println("L'evento "+ ev.getTitolo() + " è stato aggiunto al DATABASE");
    }

    public Evento getById (int id){
        Evento evDalDB = this.entityManager.find(Evento.class, id);
        if (evDalDB == null)throw new RuntimeException("Evento non disponibile in archivio");
        return evDalDB;
    }

    public void deleteById (int id){
        Evento evDalDB = this.getById(id);
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.remove(evDalDB);
        transazione.commit();
        System.out.println("L'evento "+ evDalDB.getTitolo()+ " è stato eliminato dal DATABASE");
    }
}
