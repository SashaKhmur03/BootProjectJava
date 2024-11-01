package by.itstep.sasha.demoboot.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserDetails {
    private String firstName;
    private String lastName;
    private Collection<? extends GrantedAuthority> authorities;
    private String email;
    private String phoneNumber;
}
