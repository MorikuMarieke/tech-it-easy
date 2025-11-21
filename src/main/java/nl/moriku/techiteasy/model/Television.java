package nl.moriku.techiteasy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "televisions")

public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private Double availableSize;
    @Column(nullable = false)
    private Integer refreshRate;
    @Column(nullable = false)
    private String screenType;
    @Column(nullable = false)
    private String screenQuality;
    @Column(nullable = false)
    private Boolean smartTv;
    @Column(nullable = false)
    private Boolean wifi;
    @Column(nullable = false)
    private Boolean voiceControl;
    @Column(nullable = false)
    private Boolean hdr;
    @Column(nullable = false)
    private Boolean bluetooth;
    @Column(nullable = false)
    private Boolean ambiLight;
    @Column(nullable = false)
    private Integer originalStock = 0;
    @Column(nullable = false)
    private Integer sold = 0;

    @OneToOne
    @JoinColumn(name = "remote_controller_id")
    private RemoteController remoteController;

    @OneToMany(mappedBy = "television")
    private List<CIModule> ciModules = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "televisions_wall_brackets",
        joinColumns = @JoinColumn(name = "television_id"),
        inverseJoinColumns = @JoinColumn(name = "wall_bracket_id")
    )
    private List<WallBracket> wallBrackets = new ArrayList<>();

    public Television() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

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

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public List<CIModule> getCiModules() {
        return ciModules;
    }

    public void setCiModules(List<CIModule> ciModules) {
        this.ciModules = ciModules;
    }

    public List<WallBracket> getWallBrackets() {
        return wallBrackets;
    }

    public void setWallBrackets(List<WallBracket> wallBrackets) {
        this.wallBrackets = wallBrackets;
    }
}
