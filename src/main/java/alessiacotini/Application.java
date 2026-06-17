package alessiacotini;

import alessiacotini.DAO.EventiDao;

import alessiacotini.DAO.LocationDAO;
import alessiacotini.DAO.PartecipazioneDAO;
import alessiacotini.DAO.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;



public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi-pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventiDao eventiDao = new EventiDao(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);

        
        System.out.println("Hello");


    }
}
