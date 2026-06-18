package alessiacotini.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_di_evento")
public abstract class Evento {

    @Id
    @Column (name= "evento_id")
    @GeneratedValue
    private UUID evento_id;

    @Column (name = "titolo_evento")
    private String titolo;

    @Column (name = "data_evento")
    private LocalDate dataevento;

    @Column (name = "descrizione_evento")
    private String descrizione;

    @Column (name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoevento;

    @Column (name = "numero_max_partecipanti")
    private int numeromax;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;


    public Evento(){};
    public Evento (String titolo, LocalDate dataevento,String descrizione,TipoEvento tipoevento,int numeromax, Location location){
        this.titolo = titolo;
        this.dataevento= dataevento;
        this.descrizione = descrizione;
        this.tipoevento = tipoevento;
        this.numeromax = numeromax;
        this.location = location;
    }

    public String getTitolo() {
        return titolo;
    }

    public UUID getEvento_id() {
        return UUID.fromString(String.valueOf(evento_id));
    }

    @Override
    public String toString() {

        return "Evento{" +
                ", titolo='" + titolo + '\'' +
                ", dataevento=" + dataevento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoevento=" + tipoevento +
                ", numeromax=" + numeromax +
                '}';
    }
}
