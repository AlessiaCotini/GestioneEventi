package alessiacotini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "concerto")
@DiscriminatorValue("concerto")
public class Concerto extends Evento{
    @Column(name = "genere_concerto")
    private Generes genere;

    @Column(name = "streaming")
    private boolean streaming;

    public Concerto(){}
    public Concerto(String titolo, LocalDate dataevento, String descrizione, TipoEvento tipoevento, int numeromax, Generes genere, boolean streaming, Location location){
        super(titolo, dataevento, descrizione, tipoevento, numeromax, location);
        this.genere = genere;
        this.streaming = streaming;

        //PER ALESSIA I CONCERTI IN STREAMING NON ESISTONO
    }

    public Generes getGenere() {
        return genere;
    }

    @Override
    public String getTitolo() {
        return super.getTitolo();
    }

    @Override
    public String toString() {
        return "Concerto{" +
                ", genere=" + genere +
                ", streaming=" + streaming +
                '}';
    }
}
