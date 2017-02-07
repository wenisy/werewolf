package com.cogrood.service;

import com.cogrood.model.Werewolves;
import com.cogrood.repository.WerewolvesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class WerewolvesService {

    @Autowired
    private WerewolvesRepository werewolvesRepository;

    public int getWerewolvesRole(Integer Id) {
        Werewolves werewolves = werewolvesRepository.findOne(Id);
        return dispatcher(werewolves);
    }

    public int saveWerewolvesGame(Werewolves werewolves) {
        try {
            List<Object> roles = Arrays.asList(werewolves.getRoles());
            Collections.shuffle(roles);
            werewolves.setRoles(roles.toArray());
            return werewolvesRepository.save(werewolves).getId();
        } catch (RuntimeException e) {
            return 0;
        }
    }

    private int dispatcher(Werewolves werewolves) {
        if (null == werewolves) {
            return 0;
        }
        List<Object> roles = Arrays.asList(werewolves.getRoles());
        List<Object> newRoles = roles.stream().skip(1).collect(Collectors.toList());
        if (roles.isEmpty()) {
            werewolvesRepository.delete(werewolves);
            return 0;
        }
        werewolves.setRoles(newRoles.toArray());
        werewolvesRepository.save(werewolves);
        return Integer.parseInt(roles.get(0).toString());
    }
}
