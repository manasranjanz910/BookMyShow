package dev.manas.BookMyShow.model;
import dev.manas.BookMyShow.model.constant.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private String description;
    @ManyToMany
    private List<Actor>actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature>movieFeatures;
    public Movie(){}

    public Movie(String name , String description)
    {
        this.name =name;
        this.description =description;
    }

    public Movie(String name, String description, List<Actor> actors, List<MovieFeature> movieFeatures) {
        this.name = name;
        this.description = description;
        this.actors = actors;
        this.movieFeatures = movieFeatures;
    }
}
