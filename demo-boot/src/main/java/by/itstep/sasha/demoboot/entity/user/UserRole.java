package by.itstep.sasha.demoboot.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role", unique = true, nullable = false)
    private int id;

    @Column(name = "name",  length = 128, nullable = false)
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
