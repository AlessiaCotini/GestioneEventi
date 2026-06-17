package alessiacotini;

import alessiacotini.DAO.EventiDao;

import alessiacotini.DAO.LocationDAO;
import alessiacotini.DAO.PartecipazioneDAO;
import alessiacotini.DAO.PersonaDAO;
import alessiacotini.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.dialect.function.array.PostgreSQLArrayTrimEmulation;

import java.time.LocalDate;


public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi-pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventiDao eventiDao = new EventiDao(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);

        Evento evento = new Evento("concerto the cure", LocalDate.of(2024,06,14), "firenze rocks",TipoEvento.PUBBLICO, 150000);
        Persona persona = new Persona("Alessia", "Cotini", "alessia.cotini@icloud.com", LocalDate.of(1997, 12,29), TipoSesso.F);
        Location location = new Location("Firenze Rocks", "Firenze");
        Partecipazione partecipazione = new Partecipazione( persona.getNome_persona(),StatoPartecipazione.CONFERMATA);

        personaDAO.save(persona);
        eventiDao.save(evento);
        locationDAO.save(location);
        partecipazioneDAO.save(partecipazione);

        System.out.println();
        System.out.println("Hello");


    }
}
