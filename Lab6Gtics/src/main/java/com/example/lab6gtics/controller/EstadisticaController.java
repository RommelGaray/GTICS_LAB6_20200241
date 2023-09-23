package com.example.lab6gtics.controller;

import com.example.lab6gtics.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticaController {

    final DeviceRepository deviceRepository;

    final SiteRepository siteRepository;

    final LocationRepository locationRepository;

    final TicketRepository ticketRepository;

    final TechnicianRepository technicianRepository;

    public EstadisticaController(DeviceRepository deviceRepository, SiteRepository siteRepository, LocationRepository locationRepository, TicketRepository ticketRepository, TechnicianRepository technicianRepository) {
        this.deviceRepository = deviceRepository;
        this.siteRepository = siteRepository;
        this.locationRepository = locationRepository;
        this.ticketRepository = ticketRepository;
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"/", ""})
    public String listaEquipo(Model model) {
        model.addAttribute("listaEquipos", deviceRepository.obtenerEmpleadosPorPais());
        return "Estadisticas/listEstadistica";
    }




}
