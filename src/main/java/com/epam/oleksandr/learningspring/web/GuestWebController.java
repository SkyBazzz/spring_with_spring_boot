package com.epam.oleksandr.learningspring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.oleksandr.learningspring.business.domain.Traveler;
import com.epam.oleksandr.learningspring.business.service.GuestService;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    private GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getHotelGuests(@RequestParam(value = "id", required = false) String id, Model model) {
        List<Traveler> travelers = this.guestService.getHotelGuests();
        model.addAttribute("guests", travelers);
        return "guests";
    }
}
