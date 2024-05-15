package dev.manas.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Actor extends BaseModel{
    private String name;
    @ManyToMany
    private List<Movie> movies;
    public Actor(){}
    public Actor(String name,List<Movie>movies) {
        this.name = name;
        this.movies = movies;
    }

}
