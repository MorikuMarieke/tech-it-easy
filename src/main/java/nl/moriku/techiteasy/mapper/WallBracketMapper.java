package nl.moriku.techiteasy.mapper;

import nl.moriku.techiteasy.dto.WallBracketInputDto;
import nl.moriku.techiteasy.dto.WallBracketResponseDto;
import nl.moriku.techiteasy.model.Television;
import nl.moriku.techiteasy.model.WallBracket;

import java.util.ArrayList;
import java.util.List;

public class WallBracketMapper {

    public static WallBracket toEntity(WallBracketInputDto wallBracketInputDto) {
        WallBracket wallBracket = new WallBracket();
        copyAllToEntity(wallBracketInputDto, wallBracket);
        return wallBracket;
    }

    public static void copyAllToEntity(WallBracketInputDto in, WallBracket tv) {
        tv.setName(in.getName());
        tv.setSize(in.getSize());
        tv.setAdjustable(in.getAdjustable());
        tv.setPrice(in.getPrice());
    }

    public static void copyNonNullToEntity(WallBracketInputDto in, WallBracket tv) {
        if (in.getName() != null) tv.setName(in.getName());
        if (in.getSize() != null) tv.setSize(in.getSize());
        if (in.getAdjustable() != null) tv.setAdjustable(in.getAdjustable());
        if (in.getPrice() != null) tv.setPrice(in.getPrice());
    }

    public static WallBracketResponseDto toResponseDto(WallBracket wallBracket) {
        WallBracketResponseDto dto = new WallBracketResponseDto();
        dto.setId(wallBracket.getId());
        dto.setName(wallBracket.getName());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setPrice(wallBracket.getPrice());
        if (!wallBracket.getTelevisions().isEmpty()) {
            List<Long> televisionIds = new ArrayList<>();
            for (Television tv : wallBracket.getTelevisions()) {
                televisionIds.add(tv.getId());
            }
            dto.setTelevisionIds(televisionIds);
        }
        return dto;
    }
}
