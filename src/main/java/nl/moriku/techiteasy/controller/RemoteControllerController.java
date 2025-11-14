package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.RemoteControllerInputDto;
import nl.moriku.techiteasy.dto.RemoteControllerResponseDto;
import nl.moriku.techiteasy.mapper.RemoteControllerMapper;
import nl.moriku.techiteasy.model.RemoteController;
import nl.moriku.techiteasy.services.RemoteControllerService;
import nl.moriku.techiteasy.validation.CreateGroup;
import nl.moriku.techiteasy.validation.PatchGroup;
import nl.moriku.techiteasy.validation.PutGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/remote-controllers")
public class RemoteControllerController {

    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RemoteControllerResponseDto> addRemoteController(@Validated(CreateGroup.class) @RequestBody RemoteControllerInputDto remoteControllerInputDto) {

        RemoteController remoteController = this.service.createRemoteController(remoteControllerInputDto);
        RemoteControllerResponseDto remoteControllerResponseDto = RemoteControllerMapper.toResponseDto(remoteController);

        URI uri = URI.create(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + remoteController.getId()).toUriString());

        return ResponseEntity.created(uri).body(remoteControllerResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> getRemoteControllerById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getRemoteControllerById(id));
    }

    @GetMapping
    public ResponseEntity<List<RemoteControllerResponseDto>> getAllRemoteControllers() {

        return ResponseEntity.ok(service.getAllRemoteControllers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemoteController(@PathVariable("id") Long id) {
        service.deleteRemoteController(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> updateRemoteController(@PathVariable("id") Long id, @Validated(PutGroup.class) @RequestBody RemoteControllerInputDto in) {

        return ResponseEntity.ok(service.updateRemoteController(id, in));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> updatePartialRemoteController(@PathVariable Long id, @Validated(PatchGroup.class) @RequestBody RemoteControllerInputDto in) {

        return ResponseEntity.ok(service.patchRemoteController(id, in));
    }
}
