package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "agencies")
@Data
@NoArgsConstructor(force = true)
public class Agency  {
    @Id
    @GeneratedValue(
            generator = "agency_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "agency_gen",
            sequenceName = "agency_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String country;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "image_link")
    private String imageLink;
    private String email;

    @OneToMany(mappedBy = "agency",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE})
    private List<House> houses;

    @ManyToMany(mappedBy = "agencies",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Customer> customers;

    public Agency(String name, String country, String phoneNumber, String imageLink, String email) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.imageLink = imageLink;
        this.email = email;
    }
}
