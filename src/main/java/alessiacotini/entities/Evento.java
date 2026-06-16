package alessiacotini.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity @Table(name = "eventi")
public class Evento {

    @Id
    @Column (name= "evento_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public Evento(){};
    public Evento (String titolo, LocalDate dataevento,String descrizione,TipoEvento tipoevento,int numeromax){
        this.titolo = titolo;
        this.dataevento= dataevento;
        this.descrizione = descrizione;
        this.tipoevento = tipoevento;
        this.numeromax = numeromax;
    }

    public String getTitolo() {
        return titolo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataevento=" + dataevento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoevento=" + tipoevento +
                ", numeromax=" + numeromax +
                '}';
    }
}
