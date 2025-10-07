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

    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero
    private Double price;

    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive
    private Double availableSize;

    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @Positive
    private Integer refreshRate;

    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String screenType;

    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String screenQuality;

    @NotNull(groups = {CreateGroup.class, PutGroup.class}) private Boolean smartTv;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) private Boolean wifi;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) private Boolean voiceControl;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) private Boolean hdr;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) private Boolean bluetooth;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) private Boolean ambiLight;

    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero
    private Integer originalStock;

    public TelevisionInputDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public Integer getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
}
