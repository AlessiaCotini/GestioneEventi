package alessiacotini.DAO;

import alessiacotini.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;


public class LocationDAO {
    private final EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Location loc){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(loc);
        transazione.commit();
        System.out.println("Location "+ loc.getNome_location() + " è stata aggiunta al DATABASE");
    }

    public Location getById (UUID id){
        Location locDalDB = this.entityManager.find(Location.class, id);
        if (locDalDB == null)throw new RuntimeException("Location non disponibile in archivio");
        return locDalDB;
    }

    public void deleteById (UUID id){
        Location locDalDB = this.getById(id);
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.remove(locDalDB);
        transazione.commit();
        System.out.println("La location "+ locDalDB.getNome_location()+ " è stata eliminata dal DATABASE");
    }
}
