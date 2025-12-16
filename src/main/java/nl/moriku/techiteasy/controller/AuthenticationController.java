package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.JwtRequestDto;
import nl.moriku.techiteasy.dto.JwtResponseDto;
import nl.moriku.techiteasy.security.CustomUserDetailsService;
import nl.moriku.techiteasy.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

//    @PostMapping("/authenticate")
//    public ResponseEntity<JwtResponseDto> createAuthenticateToken(@RequestBody JwtRequestDto requestDto) {
//        try {
//            var
//        }
//    } Ik was halverwege hier bezig met het implementeren van postmapping voor authenticatie.
}
