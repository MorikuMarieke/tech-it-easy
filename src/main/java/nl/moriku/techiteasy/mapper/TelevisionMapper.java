package nl.moriku.techiteasy.mapper;

import nl.moriku.techiteasy.dto.TelevisionResponseDto;
import nl.moriku.techiteasy.dto.TelevisionInputDto;
import nl.moriku.techiteasy.model.Television;

public class TelevisionMapper {

    public static Television toEntity(TelevisionInputDto televisionInputDto) {
        Television television = new Television();
        copyAllToEntity(televisionInputDto, television);
        television.setSold(0);
        return television;
    }

    public static void copyAllToEntity(TelevisionInputDto in, Television tv) {
        tv.setName(in.getName());
        tv.setType(in.getType());
        tv.setBrand(in.getBrand());
        tv.setPrice(in.getPrice());
        tv.setAvailableSize(in.getAvailableSize());
        tv.setRefreshRate(in.getRefreshRate());
        tv.setScreenType(in.getScreenType());
        tv.setScreenQuality(in.getScreenQuality());
        tv.setSmartTv(in.getSmartTv());
        tv.setWifi(in.getWifi());
        tv.setVoiceControl(in.getVoiceControl());
        tv.setHdr(in.getHdr());
        tv.setBluetooth(in.getBluetooth());
        tv.setAmbiLight(in.getAmbiLight());
        tv.setOriginalStock(in.getOriginalStock());
    }

    public static void copyNonNullToEntity(TelevisionInputDto in, Television tv) {
        if (in.getName() != null) tv.setName(in.getName());
        if (in.getType() != null) tv.setType(in.getType());
        if (in.getBrand() != null) tv.setBrand(in.getBrand());
        if (in.getPrice() != null) tv.setPrice(in.getPrice());
        if (in.getAvailableSize() != null) tv.setAvailableSize(in.getAvailableSize());
        if (in.getRefreshRate() != null) tv.setRefreshRate(in.getRefreshRate());
        if (in.getScreenType() != null) tv.setScreenType(in.getScreenType());
        if (in.getScreenQuality() != null) tv.setScreenQuality(in.getScreenQuality());
        if (in.getSmartTv() != null) tv.setSmartTv(in.getSmartTv());
        if (in.getWifi() != null) tv.setWifi(in.getWifi());
        if (in.getVoiceControl() != null) tv.setVoiceControl(in.getVoiceControl());
        if (in.getHdr() != null) tv.setHdr(in.getHdr());
        if (in.getBluetooth() != null) tv.setBluetooth(in.getBluetooth());
        if (in.getAmbiLight() != null) tv.setAmbiLight(in.getAmbiLight());
        if (in.getOriginalStock() != null) tv.setOriginalStock(in.getOriginalStock());}

    public static TelevisionResponseDto toResponseDto(Television television) {
        TelevisionResponseDto dto = new TelevisionResponseDto();
        dto.setId(television.getId());
        dto.setName(television.getName());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());

        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        int orig = television.getOriginalStock() == null ? 0 : television.getOriginalStock();
        int sold = television.getSold() == null ? 0 : television.getSold();
        dto.setCurrentStock(orig - sold);
        return dto;
    }
}
