package nl.moriku.techiteasy.controller;

import nl.moriku.techiteasy.dto.CIModuleInputDto;
import nl.moriku.techiteasy.dto.CIModuleResponseDto;
import nl.moriku.techiteasy.mapper.CIModuleMapper;
import nl.moriku.techiteasy.model.CIModule;
import nl.moriku.techiteasy.services.CIModuleService;
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
@RequestMapping("/ci-modules")
public class CIModuleController {
    private final CIModuleService service;

    public CIModuleController(CIModuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CIModuleResponseDto> addCIModule(@Validated(CreateGroup.class) @RequestBody CIModuleInputDto ciModuleInputDto) {

        CIModule ciModule = this.service.createCIModule(ciModuleInputDto);
        CIModuleResponseDto ciModuleResponseDto = CIModuleMapper.toResponseDto(ciModule);

        URI uri = URI.create(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + ciModule.getId()).toUriString());

        return ResponseEntity.created(uri).body(ciModuleResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CIModuleResponseDto> getCIModuleById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getCIModuleById(id));
    }

    @GetMapping
    public ResponseEntity<List<CIModuleResponseDto>> getAllCIModules() {

        return ResponseEntity.ok(service.getAllCIModules());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCIModule(@PathVariable("id") Long id) {
        service.deleteCIModule(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CIModuleResponseDto> updateCIModule(@PathVariable("id") Long id, @Validated(PutGroup.class) @RequestBody CIModuleInputDto in) {

        return ResponseEntity.ok(service.updateCIModule(id, in));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CIModuleResponseDto> updatePartialCIModule(@PathVariable Long id, @Validated(PatchGroup.class) @RequestBody CIModuleInputDto in) {

        return ResponseEntity.ok(service.patchCIModule(id, in));
    }
}
