package alessiacotini;

import alessiacotini.DAO.EventiDao;

import alessiacotini.DAO.LocationDAO;
import alessiacotini.DAO.PartecipazioneDAO;
import alessiacotini.DAO.PersonaDAO;
import alessiacotini.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi-pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventiDao eventiDao = new EventiDao(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);

        Concerto concertothecure = new Concerto("The Cure", LocalDate.of(2026,06,15),"Tutti al firenze rocks" ,TipoEvento.PUBBLICO,750000, Generes.ROCK, false, new Location("Ippodromo", "Firenze") );
        Concerto concertokneecap = new Concerto("Kneecap", LocalDate.of(2026,07,14),"Tutti al Roma festival" ,TipoEvento.PUBBLICO,5000, Generes.POP, false, new Location("Ippodromo", "Roma") );
        Concerto concertovasco = new Concerto("Vasco", LocalDate.of(2026,06,18),"Tutti a ballare in Puglia" ,TipoEvento.PUBBLICO,75000, Generes.ROCK, false, new Location("Ippodromo", "Bari") );
        Concerto concertoblink = new Concerto("Blink-182", LocalDate.of(2027,05,2),"Accendiamo il pc perche tanto non vengono" ,TipoEvento.PUBBLICO,1500, Generes.ROCK, true, new Location("STREM", "STREAM") );
        Concerto concertooasis = new Concerto("Oasis", LocalDate.of(2026,9,2),"Tanto i biglietti non li prendiamo" ,TipoEvento.PUBBLICO,150000, Generes.ROCK, true, new Location("STREAM", "STREAM") );
         eventiDao.save(concertothecure);
         eventiDao.save(concertoblink);
         eventiDao.save(concertokneecap);
         eventiDao.save(concertovasco);
         eventiDao.save(concertooasis);

        System.out.println("Hello");
    }
}
