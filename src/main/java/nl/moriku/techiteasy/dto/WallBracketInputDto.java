package nl.moriku.techiteasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import nl.moriku.techiteasy.validation.CreateGroup;
import nl.moriku.techiteasy.validation.PutGroup;

public class WallBracketInputDto {

    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String name;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String size;
    @NotNull(groups = {CreateGroup.class, PutGroup.class})
    private Boolean adjustable;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero(groups = {CreateGroup.class, PutGroup.class})
    private Double price;

    public WallBracketInputDto() {}

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getName() {
        return name;
    }

    public void setName(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String name) {
        this.name = name;
    }

    public @NotBlank(groups = {CreateGroup.class, PutGroup.class}) String getSize() {
        return size;
    }

    public void setSize(@NotBlank(groups = {CreateGroup.class, PutGroup.class}) String size) {
        this.size = size;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean getAdjustable() {
        return adjustable;
    }

    public void setAdjustable(@NotNull(groups = {CreateGroup.class, PutGroup.class}) Boolean adjustable) {
        this.adjustable = adjustable;
    }

    public @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero Double price) {
        this.price = price;
    }
}
