package by.itstep.sasha.demoboot.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Setter
@Table(name = "user_address")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address", unique = true, nullable = false)
    private int id;

    @Column(name = "country", length = 128, nullable = false)
    private String country;

    @Column(name = "region", length = 128, nullable = false)
    private String region;

    @OneToMany(mappedBy = "address")
    private Set<User> users;
}
