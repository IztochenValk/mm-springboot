package com.adrar.cdafad.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.Year;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table
@Data
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    @NotBlank(message = "Le title ne peut pas être vide")
    @Length(min = 2, max = 50)
    private String title;
    @Column(length = 255)
    private String description;
    @Column(name = "publish_at")
    @PastOrPresent
    private Date publishAt;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @ManyToMany
    @JoinTable(name = "game_category",
    joinColumns = @JoinColumn( name = "game_id" ),
    inverseJoinColumns = @JoinColumn( name = "category_id" ) )
    private List<Category> categories = new ArrayList<>();
}
