package nl.moriku.techiteasy.mapper;

import nl.moriku.techiteasy.dto.UserInputDto;
import nl.moriku.techiteasy.dto.UserOutputDto;
import nl.moriku.techiteasy.model.User;
import nl.moriku.techiteasy.model.Authority;

public class UserMapper {

    public static User toUser(UserInputDto dto) {
        User user = new User();
        user.setUsername(dto.username);
        user.setPassword(dto.password); // encoder komt later in service
        user.setEmail(dto.email);
        user.setEnabled(true);
        return user;
    }

    public static UserOutputDto toUserOutputDto(User user) {
        UserOutputDto dto = new UserOutputDto();
        dto.username = user.getUsername();
        dto.email = user.getEmail();
        dto.enabled = user.isEnabled();

        dto.authorities = user.getAuthorities().stream()
            .map(Authority::getAuthority)
            .collect(java.util.stream.Collectors.toSet());

        return dto;
    }
}
