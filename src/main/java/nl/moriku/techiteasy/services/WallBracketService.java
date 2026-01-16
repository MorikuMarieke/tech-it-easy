package nl.moriku.techiteasy.services;

import nl.moriku.techiteasy.dto.WallBracketInputDto;
import nl.moriku.techiteasy.dto.WallBracketResponseDto;
import nl.moriku.techiteasy.exceptions.ResourceNotFoundException;
import nl.moriku.techiteasy.mapper.WallBracketMapper;
import nl.moriku.techiteasy.model.WallBracket;
import nl.moriku.techiteasy.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class WallBracketService {
    private final WallBracketRepository repos;

    public WallBracketService(WallBracketRepository repos) { this.repos = repos; }

    @Transactional
    public WallBracket createWallBracket(WallBracketInputDto wallBracketInputDto) {
        return this.repos.save(WallBracketMapper.toEntity(wallBracketInputDto));
    }

    public WallBracketResponseDto getWallBracketById(Long id) {
        WallBracket wb = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        return WallBracketMapper.toResponseDto(wb);
    }

    public List<WallBracketResponseDto> getAllWallBrackets() {
        List<WallBracketResponseDto> wbDtoList = new ArrayList<>();
        List<WallBracket> wallBrackets = repos.findAll();
        for (WallBracket wb : wallBrackets) {
            wbDtoList.add(WallBracketMapper.toResponseDto(wb));
        }
        return wbDtoList;
    }

    @Transactional
    public void deleteWallBracket(Long id) {
        WallBracket wb = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        repos.delete(wb);
    }

    @Transactional
    public WallBracketResponseDto updateWallBracket(Long id, WallBracketInputDto in) {
        WallBracket wb = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Remote controller " + id + " not found."));
        WallBracketMapper.copyAllToEntity(in, wb);
        return WallBracketMapper.toResponseDto(wb);
    }

    @Transactional
    public WallBracketResponseDto patchWallBracket(Long id, WallBracketInputDto in) {
        WallBracket wb = repos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("WallBracket " + id + " cannot be patched, not found."));
        WallBracketMapper.copyNonNullToEntity(in, wb);

        return WallBracketMapper.toResponseDto(wb);
    }
}
