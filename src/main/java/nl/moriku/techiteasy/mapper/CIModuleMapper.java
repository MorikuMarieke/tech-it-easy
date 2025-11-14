package nl.moriku.techiteasy.mapper;

import nl.moriku.techiteasy.dto.CIModuleInputDto;
import nl.moriku.techiteasy.dto.CIModuleResponseDto;
import nl.moriku.techiteasy.model.CIModule;

public class CIModuleMapper {
    public static CIModule toEntity(CIModuleInputDto ciModuleInputDto) {
        CIModule ciModule = new CIModule();
        copyAllToEntity(ciModuleInputDto, ciModule);
        return ciModule;
    }

    public static void copyAllToEntity(CIModuleInputDto in, CIModule tv) {
        tv.setName(in.getName());
        tv.setType(in.getType());
        tv.setBrand(in.getBrand());
        tv.setPrice(in.getPrice());
    }

    public static void copyNonNullToEntity(CIModuleInputDto in, CIModule tv) {
        if (in.getName() != null) tv.setName(in.getName());
        if (in.getType() != null) tv.setType(in.getType());
        if (in.getBrand() != null) tv.setBrand(in.getBrand());
        if (in.getPrice() != null) tv.setPrice(in.getPrice());
    }

    public static CIModuleResponseDto toResponseDto(CIModule ciModule) {
        CIModuleResponseDto dto = new CIModuleResponseDto();
        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setBrand(ciModule.getBrand());
        dto.setPrice(ciModule.getPrice());
        return dto;
    }
}
