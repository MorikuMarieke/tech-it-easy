package nl.moriku.techiteasy.services;

import nl.moriku.techiteasy.dto.CIModuleInputDto;
import nl.moriku.techiteasy.dto.CIModuleResponseDto;
import nl.moriku.techiteasy.exceptions.ResourceNotFoundException;
import nl.moriku.techiteasy.mapper.CIModuleMapper;
import nl.moriku.techiteasy.model.CIModule;
import nl.moriku.techiteasy.repositories.CIModuleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CIModuleService {
    private final CIModuleRepository repos;

    public CIModuleService(CIModuleRepository repos) { this.repos = repos; }

    @Transactional
    public CIModule createCIModule(CIModuleInputDto ciModuleInputDto) {
        return this.repos.save(CIModuleMapper.toEntity(ciModuleInputDto));
    }

    public CIModuleResponseDto getCIModuleById(Long id) {
        CIModule cim = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        return CIModuleMapper.toResponseDto(cim);
    }

    public List<CIModuleResponseDto> getAllCIModules() {
        List<CIModuleResponseDto> cimDtoList = new ArrayList<>();
        List<CIModule> ciModules = repos.findAll();
        for (CIModule cim : ciModules) {
            cimDtoList.add(CIModuleMapper.toResponseDto(cim));
        }
        return cimDtoList;
    }

    @Transactional
    public void deleteCIModule(Long id) {
        CIModule cim = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        repos.delete(cim);
    }

    @Transactional
    public CIModuleResponseDto updateCIModule(Long id, CIModuleInputDto in) {
        CIModule cim = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        CIModuleMapper.copyAllToEntity(in, cim);
        return CIModuleMapper.toResponseDto(cim);
    }

    @Transactional
    public CIModuleResponseDto patchCIModule(Long id, CIModuleInputDto in) {
        CIModule cim = repos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("CIModule " + id + " cannot be patched, not found."));
        CIModuleMapper.copyNonNullToEntity(in, cim);

        return CIModuleMapper.toResponseDto(cim);
    }
}
