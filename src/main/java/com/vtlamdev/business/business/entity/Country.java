package com.vtlamdev.business.business.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
@Entity
@Table(name = "countries")
public class Country {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // need to fix them
    @NotNull(message = "Is required") // why use @size is correct but @notnull isn't correct
    //@Size(min = 2,max = 2,message = "only 2 letter")
    @Column(name = "country_id")
    private String countryId;
    @NotNull(message = "Is required")
    @Column(name = "country_name")
    private String countryName;
    @ManyToOne
    @JoinColumn(name = "region_id",insertable = false,updatable = false)
    private Region region;
    @Column(name = "region_id")
    private int regionId;
    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Location> locations; //setter getter
    public Country(){}

    public Country(String countryName, Region region, int regionId, List<Location> locations) {
        this.countryName = countryName;
        this.region = region;
        this.regionId = regionId;
        this.locations = locations;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }


    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                ", region=" + regionId +
                '}';
    }
}
