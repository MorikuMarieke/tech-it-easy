package nl.moriku.techiteasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import nl.moriku.techiteasy.validation.CreateGroup;
import nl.moriku.techiteasy.validation.PutGroup;

public class CIModuleInputDto {
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String name;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String type;
    @NotBlank(groups = {CreateGroup.class, PutGroup.class})
    private String brand;
    @NotNull(groups = {CreateGroup.class, PutGroup.class}) @PositiveOrZero(groups = {CreateGroup.class, PutGroup.class})
    private Double price;


    public CIModuleInputDto() {
    }

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
}
