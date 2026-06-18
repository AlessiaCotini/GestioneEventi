package alessiacotini.DAO;

import alessiacotini.entities.Concerto;
import alessiacotini.entities.Evento;
import alessiacotini.entities.Generes;
import alessiacotini.entities.PartitaDiCalcio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.UUID;


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

    public Evento getById (UUID id){
        Evento evDalDB = this.entityManager.find(Evento.class, id);
        if (evDalDB == null)throw new RuntimeException("Evento non disponibile in archivio");
        return evDalDB;
    }

    public void deleteById (UUID id){
        Evento evDalDB = this.getById(id);
        EntityTransaction transazione = this.entityManager.getTransaction();
        transazione.begin();
        this.entityManager.remove(evDalDB);
        transazione.commit();
        System.out.println("L'evento "+ evDalDB.getTitolo()+ " è stato eliminato dal DATABASE");
    }

    public List<Concerto> getConcertiInStreaming(List<Concerto> concerti){
        TypedQuery<Concerto> query= entityManager.createQuery("SELECT concerti FROM Concerto concerti WHERE concerti.streaming = true", Concerto.class);
        return query.getResultList();
    }
    public List<Concerto> getConcertiPerGenere(Generes params){
        TypedQuery<Concerto> query = entityManager.createQuery("SELECT c FROM Concerto c WHERE c.genere = :params", Concerto.class);
        return query.getResultList();

    }
    public List<PartitaDiCalcio> getPartiteVinteInCasa(PartitaDiCalcio partitaDiCalcio){
        TypedQuery<PartitaDiCalcio> query = entityManager.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.goalInCasa > p.goalOspiti", PartitaDiCalcio.class );
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartiteVinteInTrasferta(PartitaDiCalcio partitaDiCalcio){
        TypedQuery<PartitaDiCalcio> query = entityManager.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.goalInCasa < p.goalOspiti", PartitaDiCalcio.class );
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartitePareggiate(PartitaDiCalcio partitaDiCalcio){
        TypedQuery<PartitaDiCalcio> query = entityManager.createQuery("SELECT p FROM PartitaDiCalcio p WHERE p.goalInCasa = p.goalOspiti", PartitaDiCalcio.class );
        return query.getResultList();
    }

}
