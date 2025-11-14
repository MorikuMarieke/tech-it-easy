package nl.moriku.techiteasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import nl.moriku.techiteasy.validation.CreateGroup;
import nl.moriku.techiteasy.validation.PutGroup;

public class RemoteControllerInputDto {

    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String name;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String compatibleWith;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String batteryType;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String brand;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero(groups = {CreateGroup.class, PutGroup.class})
    private Double price;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero(groups = {CreateGroup.class, PutGroup.class})
    private Integer originalStock;

    public RemoteControllerInputDto() {}

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getName() {
        return name;
    }

    public void setName(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String name) {
        this.name = name;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String batteryType) {
        this.batteryType = batteryType;
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

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(@NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Integer originalStock) {
        this.originalStock = originalStock;
    }
}
