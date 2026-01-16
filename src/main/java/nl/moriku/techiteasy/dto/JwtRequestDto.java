package nl.moriku.techiteasy.dto;

public class JwtRequestDto {
    private String username;
    private String password;

    public JwtRequestDto() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
