package alessiacotini;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestioneeventi-pu");
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
