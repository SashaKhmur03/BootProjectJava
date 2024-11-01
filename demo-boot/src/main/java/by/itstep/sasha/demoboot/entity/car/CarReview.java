package by.itstep.sasha.demoboot.entity.car;


import by.itstep.sasha.demoboot.entity.site.SiteReview;
import by.itstep.sasha.demoboot.entity.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "car_reviews")
public class CarReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review", unique = true, nullable = false)
    private int id;

    @Column(name = "rating_review", nullable = false)
    private int ratingReview;

    @Column(name = "text_review", length = 2048, nullable = false)
    private String textReview;

    @ManyToOne
    @JoinColumn(name = "id_site_review", nullable = false)
    private SiteReview idSiteReview;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User userCarReview;

    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;

}
