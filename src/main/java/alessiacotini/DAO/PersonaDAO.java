package alessiacotini.DAO;

import alessiacotini.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;


public class PersonaDAO
{
    private final EntityManager entityManager;

    public PersonaDAO
            (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Persona per){
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.persist(per);
        transazione.commit();
        System.out.println("La persona "+ per.getNome_persona() + " è stata aggiunta al DATABASE");
    }

    public Persona getById (UUID id){
        Persona perDalDB = this.entityManager.find(Persona.class, id);
        if (perDalDB == null)throw new RuntimeException("Persona non disponibile in archivio");
        return perDalDB;
    }

    public void deleteById (UUID id){
        Persona perDalDB = this.getById(id);
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.remove(perDalDB);
        transazione.commit();
        System.out.println("La persona "+ perDalDB.getNome_persona()+ " è stata eliminata dal DATABASE");
    }
}
