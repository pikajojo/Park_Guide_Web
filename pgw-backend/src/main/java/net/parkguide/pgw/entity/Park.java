package net.parkguide.pgw.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parks")
public class Park {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "park_name")
    public String name;

    @Column(name = "park_country")
    public String country;

    @Column(name = "park_city")
    public String city;

    @Column(name = "price")
    public long price;

    @Column(name = "web_link")
    public String webLink;


}
