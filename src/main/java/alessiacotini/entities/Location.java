package alessiacotini.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name= "locations")
public class Location {
    @Id
    @Column(name= "location_id")
    @GeneratedValue
    private UUID location_id;

    @Column (name = "nome_location")
    private String nome_location;

    @Column (name = "citta_location")
    private String citta_location;

    public Location(){}
    public Location(String name_location, String citta_location){
        this.nome_location = nome_location;
        this.citta_location = citta_location;
    }

    public UUID getLocation_id() {
        return location_id;
    }

    public String getNome_location() {
        return nome_location;
    }

    public String getCitta_location() {
        return citta_location;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", nome_location='" + nome_location + '\'' +
                ", citta_location='" + citta_location + '\'' +
                '}';
    }
}
