package by.itstep.sasha.demoboot.entity.site;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name = "sites_ads")
public class SiteAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_site_ad", unique = true, nullable = false)
    private int id;

    @Column(name = "name_site_ad", length = 128, nullable = false)
    private String nameSiteAd;

    @Column(name = "url_site_ad", length = 2048, nullable = false)
    private String urlSiteAd;


}
