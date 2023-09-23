package com.example.lab6gtics.repository;

import com.example.lab6gtics.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
