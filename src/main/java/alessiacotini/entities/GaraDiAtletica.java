package alessiacotini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "gara_di_atletica")
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento{

    //UNA GARA TANTI PARTECIPANTI

    @OneToMany
    @JoinTable (name = "set_atleti",
            joinColumns = @JoinColumn(name = "gara_atletica_id"),
            inverseJoinColumns = @JoinColumn(name="atleta_id"))
    private List<Persona> set_atleti;

    //OGNI GARA HA UN VINCITORE

    @OneToOne
    @JoinColumn(name = "vincitore")
    public Persona vincitore;

    public GaraDiAtletica(){}
    public GaraDiAtletica(String titolo, LocalDate dataevento, String descrizione, TipoEvento tipoevento, int numeromax, List<Persona> set_atleti, Persona vincitore,Location location){
        super(titolo, dataevento, descrizione, tipoevento, numeromax, location);
        this.set_atleti = set_atleti;
        this.vincitore = vincitore;
    }


    public List<Persona> getSet_atleti() {
        return set_atleti;
    }

    public void setSet_atleti(List<Persona> set_atleti) {
        this.set_atleti = set_atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                ", set_atleti=" + set_atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
