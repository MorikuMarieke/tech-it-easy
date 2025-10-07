package nl.moriku.techiteasy.services;

import nl.moriku.techiteasy.dto.TelevisionInputDto;
import nl.moriku.techiteasy.dto.TelevisionResponseDto;
import nl.moriku.techiteasy.exceptions.ResourceNotFoundException;
import nl.moriku.techiteasy.mapper.TelevisionMapper;
import nl.moriku.techiteasy.model.Television;
import nl.moriku.techiteasy.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TelevisionService {

    private final TelevisionRepository repos;

    @Autowired
    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
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
        List<Television> tvList;

        if (brand == null || brand.isBlank()) {
            tvList = repos.findAll();
        } else {
            tvList = repos.findByBrandIgnoreCase(brand.trim());
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

}
