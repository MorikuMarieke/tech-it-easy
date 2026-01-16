package nl.moriku.techiteasy.dto;

import java.util.Set;

public class UserOutputDto {
    public String username;
    public String email;
    public boolean enabled;
    public Set<String> authorities;
}
