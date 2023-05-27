package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(
            generator = "customer_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "customer_gen",
            sequenceName = "customer_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Agency> agencies;

    @OneToMany(mappedBy = "customer",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Booking>  bookings;



}
