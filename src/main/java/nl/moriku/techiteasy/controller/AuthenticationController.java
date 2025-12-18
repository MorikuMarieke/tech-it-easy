package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.JwtRequestDto;
import nl.moriku.techiteasy.dto.JwtResponseDto;
import nl.moriku.techiteasy.security.CustomUserDetailsService;
import nl.moriku.techiteasy.security.JwtUtil;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/authenticated")
    public ResponseEntity<Object> authenticated(Authentication authentication, Principal principal) {
        return ResponseEntity.ok(principal);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponseDto> createAuthenticateToken(@RequestBody JwtRequestDto requestDto) {

        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authToken);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).build();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String jwt = jwtUtil.generateToken(userDetails);

        JwtResponseDto response = new JwtResponseDto(jwt);
        return ResponseEntity.ok(response);
    }
}
