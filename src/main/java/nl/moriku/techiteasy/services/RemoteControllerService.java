package nl.moriku.techiteasy.services;

import nl.moriku.techiteasy.dto.RemoteControllerInputDto;
import nl.moriku.techiteasy.dto.RemoteControllerResponseDto;
import nl.moriku.techiteasy.dto.TelevisionInputDto;
import nl.moriku.techiteasy.dto.TelevisionResponseDto;
import nl.moriku.techiteasy.exceptions.ResourceNotFoundException;
import nl.moriku.techiteasy.mapper.RemoteControllerMapper;
import nl.moriku.techiteasy.mapper.TelevisionMapper;
import nl.moriku.techiteasy.model.RemoteController;
import nl.moriku.techiteasy.model.Television;
import nl.moriku.techiteasy.repositories.RemoteControllerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RemoteControllerService {
    private final RemoteControllerRepository repos;

    public RemoteControllerService(RemoteControllerRepository repos) { this.repos = repos; }

    @Transactional
    public RemoteController createRemoteController(RemoteControllerInputDto remoteControllerInputDto) {
        return this.repos.save(RemoteControllerMapper.toEntity(remoteControllerInputDto));
    }

    public RemoteControllerResponseDto getRemoteControllerById(Long id) {
        RemoteController rc = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        return RemoteControllerMapper.toResponseDto(rc);
    }

    public List<RemoteControllerResponseDto> getAllRemoteControllers() {
        List<RemoteControllerResponseDto> rcDtoList = new ArrayList<>();
        List<RemoteController> remoteControllers = repos.findAll();
        for (RemoteController rc : remoteControllers) {
            rcDtoList.add(RemoteControllerMapper.toResponseDto(rc));
        }
        return rcDtoList;
    }

    @Transactional
    public void deleteRemoteController(Long id) {
        RemoteController rc = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        repos.delete(rc);
    }

    @Transactional
    public RemoteControllerResponseDto updateRemoteController(Long id, RemoteControllerInputDto in) {
        RemoteController rc = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        RemoteControllerMapper.copyAllToEntity(in, rc);
        return RemoteControllerMapper.toResponseDto(rc);
    }

    @Transactional
    public RemoteControllerResponseDto patchRemoteController(Long id, RemoteControllerInputDto in) {
        RemoteController rc = repos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("RemoteController " + id + " cannot be patched, not found."));
        RemoteControllerMapper.copyNonNullToEntity(in, rc);

        return RemoteControllerMapper.toResponseDto(rc);
    }
}
