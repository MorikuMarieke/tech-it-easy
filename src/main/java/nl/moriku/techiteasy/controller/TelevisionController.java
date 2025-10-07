package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.TelevisionResponseDto;
import nl.moriku.techiteasy.dto.TelevisionInputDto;
import nl.moriku.techiteasy.mapper.TelevisionMapper;
import nl.moriku.techiteasy.model.Television;
import nl.moriku.techiteasy.services.TelevisionService;
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
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TelevisionResponseDto> addTelevision(@Validated(CreateGroup.class) @RequestBody TelevisionInputDto televisionInputDto) {

        Television television = this.service.createTelevision(televisionInputDto);
        TelevisionResponseDto televisionResponseDto = TelevisionMapper.toResponseDto(television);

        URI uri = URI.create(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + television.getId()).toUriString());

        return ResponseEntity.created(uri).body(televisionResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevisionById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getTelevisionById(id));
    }

    @GetMapping
    public ResponseEntity<List<TelevisionResponseDto>> getAllTelevisions(@RequestParam(value = "brand", required = false) String brand) {

        return ResponseEntity.ok(service.getAllTelevisions(brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable("id") Long id) {
        service.deleteTelevision(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable("id") Long id, @Validated(PutGroup.class) @RequestBody TelevisionInputDto in) {

        return ResponseEntity.ok(service.updateTelevision(id, in));
    }

    @PatchMapping("/televisions/{id}")
    public ResponseEntity<TelevisionResponseDto> updatePartialTelevision(@PathVariable Long id, @Validated(PatchGroup.class) @RequestBody TelevisionInputDto in) {

        return ResponseEntity.ok(service.patchTelevision(id, in));
    }

}
