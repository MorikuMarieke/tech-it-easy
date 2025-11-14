package nl.moriku.techiteasy.dto;

import jakarta.validation.constraints.*;
import nl.moriku.techiteasy.validation.CreateGroup;
import nl.moriku.techiteasy.validation.PutGroup;

public class TelevisionInputDto {

    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String name;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String type;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String brand;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero(groups = {CreateGroup.class, PutGroup.class})
    private Double price;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive(groups = {CreateGroup.class, PutGroup.class})
    private Double availableSize;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive(groups = {CreateGroup.class, PutGroup.class})
    private Integer refreshRate;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String screenType;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String screenQuality;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean smartTv;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean wifi;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean voiceControl;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean hdr;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean bluetooth;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean ambiLight;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero(groups = {CreateGroup.class, PutGroup.class})
    private Integer originalStock;

    public TelevisionInputDto() {}

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getName() {
        return name;
    }

    public void setName(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String name) {
        this.name = name;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getType() {
        return type;
    }

    public void setType(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String type) {
        this.type = type;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getBrand() {
        return brand;
    }

    public void setBrand(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String brand) {
        this.brand = brand;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Double price) {
        this.price = price;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(@NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive Double availableSize) {
        this.availableSize = availableSize;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(@NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getScreenType() {
        return screenType;
    }

    public void setScreenType(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String screenType) {
        this.screenType = screenType;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getWifi() {
        return wifi;
    }

    public void setWifi(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean wifi) {
        this.wifi = wifi;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getHdr() {
        return hdr;
    }

    public void setHdr(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean hdr) {
        this.hdr = hdr;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(@NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Integer originalStock) {
        this.originalStock = originalStock;
    }
}
