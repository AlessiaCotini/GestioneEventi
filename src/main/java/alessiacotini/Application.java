package alessiacotini;

import alessiacotini.DAO.EventiDao;
import alessiacotini.entities.Evento;
import alessiacotini.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi-pu");
    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventiDao eventiDao = new EventiDao(entityManager);

        Evento primo = new Evento("concerto", LocalDate.now(),"concerto the cure", TipoEvento.PUBBLICO, 150000);
        Evento secondo = new Evento("concerto estivo", LocalDate.now(),"concerto nirvana", TipoEvento.PUBBLICO, 750000);
        Evento terzo = new Evento("concerto invernale", LocalDate.now(),"concerto foo fighters", TipoEvento.PUBBLICO, 190000);

        //eventiDao.save(primo);
        //eventiDao.save(secondo);
        //eventiDao.save(terzo);
        eventiDao.getById(1);
        eventiDao.deleteById(2);
    }
}
