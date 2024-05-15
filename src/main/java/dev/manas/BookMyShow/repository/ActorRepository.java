package dev.manas.BookMyShow.repository;

import dev.manas.BookMyShow.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
    Actor findActorByName(String name);

}
