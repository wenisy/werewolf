package com.cogrood.controller;

import com.cogrood.model.Werewolves;
import com.cogrood.service.WerewolvesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WerewolvesKillerController {

    @Autowired
    private WerewolvesService werewolvesService;

    private final Logger logger = LoggerFactory.getLogger(WerewolvesKillerController.class);

    @CrossOrigin(origins = "http://wolf.retuike.com")
    @RequestMapping(value = "/werewolvesGames", method = RequestMethod.POST)
    public ResponseEntity saveWerewolvesGame(@RequestBody Werewolves werewolves) {
        int Id = werewolvesService.saveWerewolvesGame(werewolves);
        return ResponseEntity.ok(Id);
    }

    @CrossOrigin(origins = "http://wolf.retuike.com")
    @RequestMapping(value = "/werewolvesGames", method = RequestMethod.GET)
    public ResponseEntity getWerewolvesGame(@RequestParam("Id") Integer Id) {
        try {
            return ResponseEntity.ok(werewolvesService.getWerewolvesRole(Id));
        } catch (Exception e) {
            logger.error("Can't return werewolves roles {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
