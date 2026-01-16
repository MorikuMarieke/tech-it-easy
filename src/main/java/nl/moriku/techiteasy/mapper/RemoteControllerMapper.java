package nl.moriku.techiteasy.mapper;

import nl.moriku.techiteasy.dto.RemoteControllerInputDto;
import nl.moriku.techiteasy.dto.RemoteControllerResponseDto;
import nl.moriku.techiteasy.model.RemoteController;

public class RemoteControllerMapper {
    public static RemoteController toEntity(RemoteControllerInputDto remoteControllerInputDto) {
        RemoteController remoteController = new RemoteController();
        copyAllToEntity(remoteControllerInputDto, remoteController);
        return remoteController;
    }

    public static void copyAllToEntity(RemoteControllerInputDto in, RemoteController tv) {
        tv.setName(in.getName());
        tv.setCompatibleWith(in.getCompatibleWith());
        tv.setBatteryType(in.getBatteryType());
        tv.setBrand(in.getBrand());
        tv.setPrice(in.getPrice());
        tv.setOriginalStock(in.getOriginalStock());
    }

    public static void copyNonNullToEntity(RemoteControllerInputDto in, RemoteController tv) {
        if (in.getName() != null) tv.setName(in.getName());
        if (in.getCompatibleWith() != null) tv.setCompatibleWith(in.getCompatibleWith());
        if (in.getBatteryType() != null) tv.setBatteryType(in.getBatteryType());
        if (in.getBrand() != null) tv.setBrand(in.getBrand());
        if (in.getPrice() != null) tv.setPrice(in.getPrice());
        if (in.getOriginalStock() != null) tv.setOriginalStock(in.getOriginalStock());}

    public static RemoteControllerResponseDto toResponseDto(RemoteController remoteController) {
        RemoteControllerResponseDto dto = new RemoteControllerResponseDto();
        dto.setId(remoteController.getId());
        dto.setName(remoteController.getName());
        dto.setCompatibleWith(remoteController.getCompatibleWith());
        dto.setBatteryType(remoteController.getBatteryType());
        dto.setBrand(remoteController.getBrand());
        dto.setPrice(remoteController.getPrice());
        dto.setOriginalStock(remoteController.getOriginalStock());
        int orig = remoteController.getOriginalStock() == null ? 0 : remoteController.getOriginalStock();
        if (remoteController.getTelevision() != null) {
            dto.setTelevisionId(remoteController.getTelevision().getId());
        }
        return dto;
    }
}
