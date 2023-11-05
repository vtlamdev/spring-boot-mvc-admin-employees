package com.vtlamdev.business.business.entity;

import jakarta.persistence.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Entity
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int region_id;
    @Column(name = "region_name")
    private String regionName;

    public Region(){}
    public Region(String regionName) {
        this.regionName = regionName;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Region{" +
                "region_id=" + region_id +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
