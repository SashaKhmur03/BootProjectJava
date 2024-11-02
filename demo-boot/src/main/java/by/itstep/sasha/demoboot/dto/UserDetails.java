package by.itstep.sasha.demoboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@AllArgsConstructor
@Data
public class CustomUserDetails implements UserDetails {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String email;
    private String phoneNumber;
}
