package nl.moriku.techiteasy.dto;

public class JwtResponseDto {
    private String jwt;

    public JwtResponseDto(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
