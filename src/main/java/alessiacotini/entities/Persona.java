package alessiacotini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "persone")
public class Persona {
    @Id
    @Column(name= "persona_id")
    @GeneratedValue
    private UUID persona_id;

    @Column (name = "nome_persona")
    private String nome_persona;

    @Column (name = "cognome_persona")
    private String cognome_persona;

    @Column (name = "email_persona")
    private String email_persona;

    @Column(name= "data_di_nascita")
    private LocalDate data_di_nascita;

    @Column (name = "sesso")
    private TipoSesso sesso_persona;

    @OneToMany
            (mappedBy = "persona")
    private List<Partecipazione> lista_partecipazioni = new ArrayList<>();

    public Persona(){}
    public Persona(String nome_persona, String cognome_persona, String email_persona, LocalDate data_di_nascita, TipoSesso sesso_persona) {
        this.nome_persona = nome_persona;
        this.cognome_persona = cognome_persona;
        this.email_persona = email_persona;
        this.data_di_nascita = data_di_nascita;
        this.sesso_persona = sesso_persona;
    }


    public UUID getPersona_id() {
        return persona_id;
    }

    public String getNome_persona() {
        return nome_persona;
    }

    public List<Partecipazione> getLista_partecipazioni() {
        return lista_partecipazioni;
    }
}

