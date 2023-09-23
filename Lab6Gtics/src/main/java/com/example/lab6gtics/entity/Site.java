package com.example.lab6gtics.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SiteID", nullable = false)
    private Integer id;

    @Column(name = "SiteName")
    private String siteName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationID")
    private Location locationID;

    @Column(name = "InstallationDate")
    private LocalDate installationDate;

    @Column(name = "Latitude", length = 45)
    private String latitude;

    @Column(name = "Longitude", length = 45)
    private String longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Location getLocationID() {
        return locationID;
    }

    public void setLocationID(Location locationID) {
        this.locationID = locationID;
    }

    public LocalDate getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(LocalDate installationDate) {
        this.installationDate = installationDate;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}