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
import java.util.ArrayList;
import java.util.List;


public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi-pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventiDao eventiDao = new EventiDao(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);


        Location prima = new Location("Ippodromo", "Firenze");
        Location seconda = new Location("Ippodromo", "Roma");
        Location terza = new Location("Ippodromo", "Bari");
        Location quarta = new Location("STREM", "STREAM");
        Location quinta = new Location("STREAM", "STREAM");
         locationDAO.save(prima);
         locationDAO.save(seconda);
         locationDAO.save(terza);
         locationDAO.save(quarta);
         locationDAO.save(quinta);

        Concerto concertothecure = new Concerto("The Cure", LocalDate.of(2026,06,15),"Tutti al firenze rocks" ,TipoEvento.PUBBLICO,750000, Generes.ROCK, false, prima  );
        Concerto concertokneecap = new Concerto("Kneecap", LocalDate.of(2026,07,14),"Tutti al Roma festival" ,TipoEvento.PUBBLICO,5000, Generes.POP, false, seconda);
        Concerto concertovasco = new Concerto("Vasco", LocalDate.of(2026,06,18),"Tutti a ballare in Puglia" ,TipoEvento.PUBBLICO,75000, Generes.ROCK, false, terza );
        Concerto concertoblink = new Concerto("Blink-182", LocalDate.of(2027,05,2),"Accendiamo il pc perche tanto non vengono" ,TipoEvento.PUBBLICO,1500, Generes.ROCK, true, quarta );
        Concerto concertooasis = new Concerto("Oasis", LocalDate.of(2026,9,2),"Tanto i biglietti non li prendiamo" ,TipoEvento.PUBBLICO,150000, Generes.ROCK, true, quinta );

         eventiDao.save(concertothecure);
         eventiDao.save(concertoblink);
         eventiDao.save(concertokneecap);
         eventiDao.save(concertovasco);
         eventiDao.save(concertooasis);

         List<Concerto> concerti = new ArrayList<>();
         concerti.add(concertothecure);
         concerti.add(concertokneecap);
         concerti.add(concertoblink);
         concerti.add(concertovasco);
         concerti.add(concertooasis);

         List<Concerto> concertistrem = eventiDao.getConcertiInStreaming(concerti);
        System.out.println(concertistrem);

        System.out.println("Hello");
    }
}
