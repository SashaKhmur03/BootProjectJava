package by.itstep.sasha.demoboot.entity.announcement;

import by.itstep.sasha.demoboot.entity.site.SiteAd;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import by.itstep.sasha.demoboot.entity.car.Car;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name = "car_announcements")
public class CarAnnouncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ad", unique = true, nullable = false)
    private int id;

    @Column(name = "title", length = 128, nullable = false)
    private String title;

    @Column(name = "description", length = 2048, nullable = true)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "rating_ad", nullable = false)
    private boolean ratingAd;

    @Column(name = "date", nullable = false)
    private int date;

    @Column(name = "location", nullable = false)
    private int location;


    @ManyToOne
    @JoinColumn(name = "id_car", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_site_ad", nullable = false)
    private SiteAd idSiteAd;

    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts", nullable = true)
    private Timestamp updatedTs;
}
