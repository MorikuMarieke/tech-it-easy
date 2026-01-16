package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.UserInputDto;
import nl.moriku.techiteasy.dto.UserOutputDto;
import nl.moriku.techiteasy.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserInputDto input) {
        String username = userService.createUser(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(username);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserOutputDto> getUser(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }
}
