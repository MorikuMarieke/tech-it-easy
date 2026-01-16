package nl.moriku.techiteasy.services;

import nl.moriku.techiteasy.dto.TelevisionInputDto;
import nl.moriku.techiteasy.dto.TelevisionResponseDto;
import nl.moriku.techiteasy.exceptions.ResourceNotFoundException;
import nl.moriku.techiteasy.mapper.TelevisionMapper;
import nl.moriku.techiteasy.model.CIModule;
import nl.moriku.techiteasy.model.RemoteController;
import nl.moriku.techiteasy.model.Television;
import nl.moriku.techiteasy.model.WallBracket;
import nl.moriku.techiteasy.repositories.CIModuleRepository;
import nl.moriku.techiteasy.repositories.RemoteControllerRepository;
import nl.moriku.techiteasy.repositories.TelevisionRepository;
import nl.moriku.techiteasy.repositories.WallBracketRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TelevisionService {

    private final TelevisionRepository repos;
    private final TelevisionRepository televisionRepository;
    private final RemoteControllerRepository remoteControllerRepository;
    private final CIModuleRepository ciModuleRepository;
    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository repos, TelevisionRepository televisionRepository, RemoteControllerRepository remoteControllerRepository, CIModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository) {
        this.repos = repos;
        this.televisionRepository = televisionRepository;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    @Transactional
    public Television createTelevision(TelevisionInputDto televisionInputDto) {
        return this.repos.save(TelevisionMapper.toEntity(televisionInputDto));
    }

    public TelevisionResponseDto getTelevisionById(Long id) {
        Television tv = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Television " + id + " not found."));

        return TelevisionMapper.toResponseDto(tv);
    }

    public List<TelevisionResponseDto> getAllTelevisions(String brand) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        List<Television> tvList;

        if (brand == null || brand.isBlank()) {
            tvList = repos.findAll(sort);
        } else {
            tvList = repos.findByBrandIgnoreCase(brand.trim(), sort);
        }

        List<TelevisionResponseDto> tvDtoList = new ArrayList<>(tvList.size());
        for (Television tv : tvList) {
            tvDtoList.add(TelevisionMapper.toResponseDto(tv));
        }

        return tvDtoList;
    }

    @Transactional
    public void deleteTelevision(Long id) {
        Television tv = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Television " + id + " not found."));

        repos.delete(tv);
    }

    @Transactional
    public TelevisionResponseDto updateTelevision(Long id, TelevisionInputDto in) {
        Television tv = repos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Television " + id + " cannot be updated, not found."));
        TelevisionMapper.copyAllToEntity(in, tv);

        return TelevisionMapper.toResponseDto(tv);
    }

    @Transactional
    public TelevisionResponseDto patchTelevision(Long id, TelevisionInputDto in) {
        Television tv = repos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Television " + id + " cannot be patched, not found."));
        TelevisionMapper.copyNonNullToEntity(in, tv);

        return TelevisionMapper.toResponseDto(tv);
    }

    @Transactional
    public void assignRemoteControllerToTelevision(Long tvId, Long rcId) {
        Television tv = televisionRepository.findById(tvId).orElseThrow(() -> new ResourceNotFoundException("Television " + tvId + " not found."));

        RemoteController rc = remoteControllerRepository.findById(rcId).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + rcId + " not found."));

        tv.setRemoteController(rc);
        televisionRepository.save(tv);
    }

    @Transactional
    public void assignCIModuleToTelevision(Long tvId, Long cimId) {
        Television tv = televisionRepository.findById(tvId).orElseThrow(() -> new ResourceNotFoundException("Television " + tvId + " not found."));

        CIModule cim = ciModuleRepository.findById(cimId).orElseThrow(() -> new ResourceNotFoundException("CI Module " + cimId + " not found."));

        cim.setTelevision(tv);
        ciModuleRepository.save(cim);
    }

    @Transactional
    public void assignWallBracketToTelevision(Long tvId, Long wbId) {
        Television tv = televisionRepository.findById(tvId).orElseThrow(() -> new ResourceNotFoundException("Television " + tvId + " not found."));

        WallBracket wb = wallBracketRepository.findById(wbId).orElseThrow(() -> new ResourceNotFoundException("Wall Bracket " + wbId + " not found."));

        tv.getWallBrackets().add(wb);
        televisionRepository.save(tv);
    }

}
