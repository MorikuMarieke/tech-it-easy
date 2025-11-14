package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.WallBracketInputDto;
import nl.moriku.techiteasy.dto.WallBracketResponseDto;
import nl.moriku.techiteasy.mapper.WallBracketMapper;
import nl.moriku.techiteasy.model.WallBracket;
import nl.moriku.techiteasy.services.WallBracketService;
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
@RequestMapping("/wall-brackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WallBracketResponseDto> addWallBracket(@Validated(CreateGroup.class) @RequestBody WallBracketInputDto wallBracketInputDto) {

        WallBracket wallBracket = this.service.createWallBracket(wallBracketInputDto);
        WallBracketResponseDto wallBracketResponseDto = WallBracketMapper.toResponseDto(wallBracket);

        URI uri = URI.create(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + wallBracket.getId()).toUriString());

        return ResponseEntity.created(uri).body(wallBracketResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> getWallBracketById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getWallBracketById(id));
    }

    @GetMapping
    public ResponseEntity<List<WallBracketResponseDto>> getAllWallBrackets() {

        return ResponseEntity.ok(service.getAllWallBrackets());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallBracket(@PathVariable("id") Long id) {
        service.deleteWallBracket(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> updateWallBracket(@PathVariable("id") Long id, @Validated(PutGroup.class) @RequestBody WallBracketInputDto in) {

        return ResponseEntity.ok(service.updateWallBracket(id, in));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> updatePartialWallBracket(@PathVariable Long id, @Validated(PatchGroup.class) @RequestBody WallBracketInputDto in) {

        return ResponseEntity.ok(service.patchWallBracket(id, in));
    }
}
