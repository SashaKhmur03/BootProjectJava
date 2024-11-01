package by.itstep.sasha.demoboot.entity.car;

import by.itstep.sasha.demoboot.entity.announcement.CarAnnouncement;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car", unique = true, nullable = false)
    private int id;

    @Column(name = "brand", length = 128, nullable = false)
    private String brand;

    @Column(name = "model", length = 128, nullable = false)
    private String model;

    @Column(name = "color", length = 128, nullable = true)
    private String color;

    @Column(name = "engine_capacity", nullable = true)
    private double engineCapacity;

    @Column(name = "year_of_issue", nullable = false)
    private Date yearOfIssue;

    @OneToMany(mappedBy = "idCar")
    private Set<CarImage> carImageSet;

    @OneToMany(mappedBy = "car")
    private Set<CarAnnouncement> announcements;


    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;
}
