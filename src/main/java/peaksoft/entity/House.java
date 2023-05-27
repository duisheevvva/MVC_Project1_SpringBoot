package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import peaksoft.enums.HouseType;


@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor(force = true)
public class House {
     @Id
     @GeneratedValue(
             generator = "house_gen",
             strategy = GenerationType.SEQUENCE)
     @SequenceGenerator(
             name = "house_gen",
             sequenceName = "house_seq",
             allocationSize = 1)
     private Long id;

     @Column(name = "house_type")
     private HouseType houseType;

     private String address;

     private int price;

     private int room;

     private String country;

     private String description;

     @Column(name="image_link")
     private String imageLink;

     @Column(name = "is_booked")
     private Boolean isBooked = false;

     @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
     private Agency agency;
     @OneToOne(mappedBy = "house",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
     private Booking booking;
     @Transient
     private String houseTypeTransient;

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public HouseType getHouseType() {
          return houseType;
     }

     public void setHouseType(HouseType houseType) {
          this.houseType = houseType;
     }

     public String getAddress() {
          return address;
     }

     public void setAddress(String address) {
          this.address = address;
     }

     public int getPrice() {
          return price;
     }

     public void setPrice(int price) {
          this.price = price;
     }

     public int getRoom() {
          return room;
     }

     public void setRoom(int room) {
          this.room = room;
     }

     public String getCountry() {
          return country;
     }

     public void setCountry(String country) {
          this.country = country;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getImageLink() {
          return imageLink;
     }

     public void setImageLink(String imageLink) {
          this.imageLink = imageLink;
     }

     public Boolean isBooked() {
          return this.isBooked;
     }

     public void setBooked(Boolean booked) {
          this.isBooked = booked;
     }

     public Agency getAgency() {
          return agency;
     }

     public void setAgency(Agency agency) {
          this.agency = agency;
     }

     public Booking getBooking() {
          return booking;
     }

     public void setBooking(Booking booking) {
          this.booking = booking;
     }
}
