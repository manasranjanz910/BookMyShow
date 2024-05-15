package dev.manas.BookMyShow.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBY;
    private String updatedBy;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public BaseModel(){}

    public BaseModel(LocalDateTime createdAt, LocalDateTime updatedAt, String createdBY, String updatedBy, int id) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBY = createdBY;
        this.updatedBy = updatedBy;
        this.id = id;
    }
}
