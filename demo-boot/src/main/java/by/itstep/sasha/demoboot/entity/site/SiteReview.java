package by.itstep.sasha.demoboot.entity.site;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "sites_reviews")
public class SiteReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_site_review", unique = true, nullable = false)
    private int id;

    @Column(name = "name_site_review", length = 128, nullable = false)
    private String nameSiteReview;

    @Column(name = "url_site_review", length = 2048, nullable = false)
    private String urlSiteReview;

}
