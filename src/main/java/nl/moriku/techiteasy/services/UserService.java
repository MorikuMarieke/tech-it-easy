package nl.moriku.techiteasy.services;

import nl.moriku.techiteasy.dto.UserInputDto;
import nl.moriku.techiteasy.dto.UserOutputDto;
import nl.moriku.techiteasy.mapper.UserMapper;
import nl.moriku.techiteasy.model.Authority;
import nl.moriku.techiteasy.model.User;
import nl.moriku.techiteasy.repositories.UserRepository;
import nl.moriku.techiteasy.security.Roles;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String createUser(UserInputDto input) {
        User user = UserMapper.toUser(input);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Standaard rol toevoegen
        Authority roleUser = new Authority();
        roleUser.setAuthority(Roles.ROLE_USER);
        user.addAuthority(roleUser);  // koppelt automatisch user in jouw addAuthority()

        userRepository.save(user);
        return user.getUsername();
    }

    public void addRoleToUser(String username, String role) {
        if(!role.equals(Roles.ROLE_USER) && !role.equals(Roles.ROLE_ADMIN) && !role.equals(Roles.ROLE_MANAGER)) {
            throw new IllegalArgumentException("Rol onbekend: " + role);
        }

        User user = userRepository.findById(username).orElseThrow(() -> new RuntimeException("User niet gevonden: " + username));

        boolean alreadyHasRole = user.getAuthorities().stream()
            .anyMatch(a -> a.getAuthority().equals(role));

        if (alreadyHasRole) {
            return;
        }

        Authority authority = new Authority();
        authority.setAuthority(role);
        user.addAuthority(authority);
    }

    public UserOutputDto getUser(String username) {
        User user = userRepository.findById(username)
            .orElseThrow(() -> new RuntimeException("User niet gevonden"));
        return UserMapper.toUserOutputDto(user);
    }

    public User getUserEntity(String username) {
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }
}
