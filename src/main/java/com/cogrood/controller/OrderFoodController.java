package com.reagroup.spotlight.controller;

import com.reagroup.spotlight.service.SpotlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class SpotlightController {

    private final SpotlightService spotlightService;

    @Autowired
    public SpotlightController(SpotlightService spotlightService) {
        this.spotlightService = spotlightService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor(null));
    }

    @RequestMapping(value = "/spotlight")
    public ResponseEntity<?> spotlight(@RequestParam("loc") String[] loc) {
        List<String> locations = Arrays.asList(loc);
        if (locations.isEmpty() || locations.stream().map(String::trim).allMatch(String::isEmpty)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(spotlightService.getSpotlight(locations));
    }

}
