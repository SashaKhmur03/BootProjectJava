package by.itstep.sasha.demoboot.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {

    public User(String firstName, String lastName, String phoneNumber, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    private int id;

    @Column(name = "first_name", length = 128, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 128, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "email", length = 128, nullable = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "address", nullable = true)
    private UserAddress address;

    @Column(name = "created_ts", nullable = false)
    @CreationTimestamp
    private Timestamp createdTs;

    @Column(name = "updated_ts", nullable = true)
    private Timestamp updatedTs;

}