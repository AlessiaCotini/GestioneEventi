package alessiacotini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "partita_di_calcio")
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra in casa")
    public String squadraDiCasa;
    @Column(name = "squadra ospite")
    public String squadraOspite;
    @Column(name = "squadra vincente")
    public String squadraVincente;
    @Column(name = "goal in casa")
    public int goalInCasa;
    @Column(name = "goal ospiti")
    public int goalOspiti;



    public PartitaDiCalcio(String titolo, LocalDate dataevento, String descrizione, TipoEvento tipoevento, int numeromax, String squadraDiCasa, String squadraOspite, String squadraVincente, int goalInCasa, int goalOspiti,Location location) {
        super(titolo, dataevento, descrizione, tipoevento, numeromax, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalInCasa = goalInCasa;
        this.goalOspiti = goalOspiti;
    }

    public PartitaDiCalcio() {

    }


    public String getSquadraVincente() {
        if (goalOspiti > goalInCasa) {
            return squadraOspite;
        } else if (goalInCasa > goalOspiti) {
            return squadraDiCasa;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                ", squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", goalInCasa=" + goalInCasa +
                ", goalOspiti=" + goalOspiti +
                '}';
    }
}