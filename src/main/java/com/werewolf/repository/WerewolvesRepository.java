package com.werewolf.repository;

import com.werewolf.model.Werewolves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WerewolvesRepository extends JpaRepository<Werewolves, Integer> {
}
