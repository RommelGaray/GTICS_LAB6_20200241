package com.example.lab6gtics.repository;

import com.example.lab6gtics.dto.EquiposPorPaisDto;
import com.example.lab6gtics.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    @Query(value = "SELECT L.Country,\n" +
            "    COUNT(D.DeviceID) AS CantidadDeDispositivos\n" +
            "FROM Device D\n" +
            "JOIN Site S ON D.SiteID = S.SiteID\n" +
            "JOIN Location L ON S.LocationID = L.LocationID\n" +
            "GROUP BY L.Country\n" +
            "ORDER BY CantidadDeDispositivos DESC;",
            nativeQuery = true)
    List<EquiposPorPaisDto> obtenerEmpleadosPorPais();
}
