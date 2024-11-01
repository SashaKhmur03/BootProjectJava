package by.itstep.sasha.demoboot.entity.car;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name = "car_images")

public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_image", unique = true, nullable = false)
    private int id;

    @Column(name = "photo_order", nullable = false)
    private int photoOrder;

    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car idCar;

    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;
}
