package alessiacotini.DAO;

import alessiacotini.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;


public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione par){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(par);
        transazione.commit();
        System.out.println("La partecipazione "+ par.getPersona_partecipazione() + " è stata aggiunta al DATABASE");
    }

    public Partecipazione getById (UUID id){
        Partecipazione parDalDB = this.entityManager.find(Partecipazione.class, id);
        if (parDalDB == null)throw new RuntimeException("Partecipazione non disponibile in archivio");
        return parDalDB;
    }

    public void deleteById (UUID id){
        Partecipazione parDalDB = this.getById(id);
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.remove(parDalDB);
        transazione.commit();
        System.out.println("La partecipazione "+ parDalDB.getPersona_partecipazione()+ " è stata eliminata dal DATABASE");
    }
}
