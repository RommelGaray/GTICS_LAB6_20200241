package com.example.lab6gtics.controller;

import com.example.lab6gtics.entity.Device;
import com.example.lab6gtics.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/equipos")
public class EquipoController {

    final DeviceRepository deviceRepository;

    final SiteRepository siteRepository;

    final LocationRepository locationRepository;

    final TicketRepository ticketRepository;

    final TechnicianRepository technicianRepository;

    public EquipoController(DeviceRepository deviceRepository, SiteRepository siteRepository, LocationRepository locationRepository, TicketRepository ticketRepository, TechnicianRepository technicianRepository) {
        this.deviceRepository = deviceRepository;
        this.siteRepository = siteRepository;
        this.locationRepository = locationRepository;
        this.ticketRepository = ticketRepository;
        this.technicianRepository = technicianRepository;
    }


    @GetMapping(value = {"/", ""})
    public String listaEquipo(Model model) {
        model.addAttribute("listaEquipos", deviceRepository.findAll());
        return "Equipos/listEquipo";
    }


    @GetMapping("/newForm")
    public String newFormEquipo(Model model) {
        model.addAttribute("listaEquipos",deviceRepository.findAll());
        model.addAttribute("listaSitios",siteRepository.findAll());
        return "Equipos/newFrm";
    }


    @PostMapping("/save")
    public String guardarMascota(Device device, RedirectAttributes attr) {
        deviceRepository.save(device);
        attr.addFlashAttribute("msg", "Equipo " + device.getDeviceName() + " creado exitosamente");
        return "redirect:/equipos";
    }

    @GetMapping("/delete")
    public String borrarMascota(Model model,
                                @RequestParam("id") int id,
                                RedirectAttributes attr) {
        Optional<Device> device = deviceRepository.findById(id);
        if (device.isPresent()) {
            deviceRepository.deleteById(id);
            attr.addFlashAttribute("msg", "Equipo " + device.get().getDeviceName() + " borrado exitosamente");

        }
        return "redirect:/equipos";
    }



}
