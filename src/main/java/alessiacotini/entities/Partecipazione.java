package alessiacotini.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "partecipazioni")
public class Partecipazione {
    @Id
    @Column(name= "partecipazione_id")
    @GeneratedValue
    private UUID partecipazione_id;

    @Column (name = "persona_partecipazione")
    private String persona_partecipazione;

    @Column(name = "stato")
    private StatoPartecipazione stato_partecipazione;

    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    public Partecipazione(){
    }
    public Partecipazione(String persona_partecipazione, String evento_id, StatoPartecipazione stato_partecipazione, Persona personaId){
        this.persona_partecipazione = persona_partecipazione;
        this.stato_partecipazione = stato_partecipazione;
    }
    public UUID getPartecipazione_id() {
        return partecipazione_id;
    }

    public String getPersona_partecipazione() {
        return persona_partecipazione;
    }
}

