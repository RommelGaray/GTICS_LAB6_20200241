package com.example.lab6gtics.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID", nullable = false)
    private Integer id;

    @Column(name = "DeviceName")
    private String deviceName;

    @Column(name = "DeviceType")
    private String deviceType;

    @Column(name = "Model")
    private String model;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "SiteID")
    private Site SiteID;

}